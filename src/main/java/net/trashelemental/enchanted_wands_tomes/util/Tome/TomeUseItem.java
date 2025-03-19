package net.trashelemental.enchanted_wands_tomes.util.Tome;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.trashelemental.enchanted_wands_tomes.item.custom.TomeItem;
import net.trashelemental.enchanted_wands_tomes.util.EnchantmentChecker;
import net.trashelemental.enchanted_wands_tomes.util.ModTags;
import net.trashelemental.junkyard_lib.visual.particle.ParticleMethods;

import java.util.List;

public class TomeUseItem {

    public void useTomeItem(Player user, ItemStack stack, Level level) {

        if (!(stack.getItem() instanceof TomeItem tome)) {
            return;
        }

        EnchantmentChecker check = new EnchantmentChecker();
        int silkTouchLevel = tome.getSilkTouchLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.SILK_TOUCH);
        int gatherLevel = tome.getCollectLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.TOME_PULL);
        int knockbackLevel = tome.getKnockbackLevel(stack) + check.checkEnchantmentLevel(stack, ModTags.Enchantments.KNOCKBACK);
        int stealthLevel = tome.getStealthLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.TOME_STEALTH);

        double entityRadius = 3.0;
        double projectileRadius = 5.0;
        double knockbackStrength = 2.0 + knockbackLevel;
        double projectileSlowFactor = 0.3;

        addUserEffectModifiers(stack, user);

        if (silkTouchLevel > 0) {
            applySilkTouchEffects(stack, user, level);
        }

        if (!level.isClientSide) {
            applyKnockback(stack, user, level, knockbackStrength, entityRadius, projectileRadius, projectileSlowFactor);

            if (gatherLevel >= 1) {
                gatherNearbyItems(level, user, (5.0 + gatherLevel));
            }
        }

        if (stealthLevel >= 1) {
            tryTeleport(stack, user);
        } else {
            tryDashAttack(stack, user);
        }
    }

    private void addUserEffectModifiers(ItemStack stack, LivingEntity affected) {

        if (!(stack.getItem() instanceof TomeItem tome)) {
            return;
        }

        EnchantmentChecker check = new EnchantmentChecker();
        int fireLevel = tome.getFireLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.FIRE);
        int channelingLevel = tome.getChannelingLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.CHANNELING);
        int freezeLevel = tome.getFreezeLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.FREEZE);
        int launchLevel = tome.getLaunchLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.LAUNCH);
        int luckLevel = tome.getLuckLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.LUCK);
        int waterLevel = tome.getWaterLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.WATER);
        int healLevel = tome.getHealLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.HEAL);
        int armorLevel = tome.getArmorLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.TOME_ARMOR);

        if (fireLevel >= 1) {
            affected.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300 + (fireLevel * 100)));
        }

        if (channelingLevel >= 1) {
            affected.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 200 + (channelingLevel * 100), channelingLevel - 1));
            affected.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200 + (channelingLevel * 100), channelingLevel - 1));
        }

        if (freezeLevel >= 1) {
            affected.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200 + (freezeLevel * 100), freezeLevel - 1));
            affected.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200 + (freezeLevel * 100), 2));

            BlockPos playerPos = affected.blockPosition();
            Level world = affected.level();

            for (BlockPos pos : BlockPos.betweenClosed(playerPos.offset(-5, -5, -5), playerPos.offset(5, 5, 5))) {
                if (world.getBlockState(pos).is(Blocks.WATER)) {
                    world.setBlock(pos, Blocks.FROSTED_ICE.defaultBlockState(), 3);

                    if (world instanceof ServerLevel serverLevel) {
                        serverLevel.sendParticles(ParticleTypes.SNOWFLAKE,
                                pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                                10,
                                0.3, 0.3, 0.3,
                                0.05
                        );
                    }
                }
            }
        }

        if (launchLevel >= 1) {
            affected.setDeltaMovement(affected.getDeltaMovement().x, (0.5 + (launchLevel * 0.5)) * 0.5, affected.getDeltaMovement().z);
            affected.hasImpulse = true;
            affected.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 40 + (launchLevel * 20)));
        }

        if (luckLevel >= 1) {
            affected.addEffect(new MobEffectInstance(MobEffects.LUCK, 400 + (luckLevel * 200), luckLevel - 1));
        }

        if (waterLevel >= 1) {
            affected.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 400 + (waterLevel * 200)));

            if (affected.isOnFire()) {
                affected.extinguishFire();
            }

            BlockPos playerPos = affected.blockPosition();
            Level world = affected.level();

            for (BlockPos pos : BlockPos.betweenClosed(playerPos.offset(-5, -5, -5), playerPos.offset(5, 5, 5))) {
                if (world.getBlockState(pos).is(Blocks.FIRE)) {
                    world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);

                    if (world instanceof ServerLevel serverLevel) {
                        serverLevel.sendParticles(ParticleTypes.RAIN,
                                pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                                10,
                                0.3, 0.3, 0.3,
                                0.05
                        );
                    }
                }
            }
        }

        if (healLevel >= 1) {
            affected.heal(healLevel * 2);
        }

        if (armorLevel >= 1) {
            affected.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 400, armorLevel - 1));
        }

    }

    private void addEntityEffectModifiers(ItemStack stack, Level level, Entity entity) {

        if (!(stack.getItem() instanceof TomeItem tome)) {
            return;
        }

        EnchantmentChecker check = new EnchantmentChecker();
        int fireLevel = tome.getFireLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.FIRE);
        int AOELevel = tome.getAOELevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.TOME_AOE);
        int debuffLevel = tome.getDebuffLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.TOME_DEBUFF);

        if (fireLevel >= 1) {
            entity.setRemainingFireTicks(80 + (20 * fireLevel));
        }

        if (AOELevel >= 1) {
            Holder<DamageType> damageTypeHolder = level.registryAccess()
                    .registryOrThrow(Registries.DAMAGE_TYPE)
                    .getHolderOrThrow(DamageTypes.MAGIC);
            entity.hurt(new DamageSource(damageTypeHolder), AOELevel);
        }

        if (debuffLevel >= 1) {
            if (entity instanceof LivingEntity livingEntity) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80 + (debuffLevel * 20), debuffLevel));
                livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 80 + (debuffLevel * 20), debuffLevel));
                livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 80 + (debuffLevel * 20), debuffLevel));
            }
        }
    }

    public void applySilkTouchEffects(ItemStack stack, Player user, Level level) {
        double entityRadius = 3.0;

        if (!level.isClientSide) {
            List<Player> nearbyPlayers = level.getEntitiesOfClass(Player.class,
                    new AABB(user.getX() - entityRadius, user.getY() - entityRadius, user.getZ() - entityRadius,
                            user.getX() + entityRadius, user.getY() + entityRadius, user.getZ() + entityRadius));

            for (Player nearbyPlayer : nearbyPlayers) {
                addUserEffectModifiers(stack, nearbyPlayer);
            }

            List<LivingEntity> nearbyTamedEntities = level.getEntitiesOfClass(LivingEntity.class,
                    new AABB(user.getX() - entityRadius, user.getY() - entityRadius, user.getZ() - entityRadius,
                            user.getX() + entityRadius, user.getY() + entityRadius, user.getZ() + entityRadius));

            for (LivingEntity entity : nearbyTamedEntities) {
                if (entity instanceof TamableAnimal tamable && tamable.isTame()) {
                    addUserEffectModifiers(stack, entity);
                }
            }
        }
    }

    private void applyKnockback(ItemStack stack, Player user, Level level, double knockbackStrength, double entityRadius, double projectileRadius, double projectileSlowFactor) {

        if (!(stack.getItem() instanceof TomeItem tome)) {
            return;
        }

        EnchantmentChecker check = new EnchantmentChecker();
        int silkTouchLevel = tome.getSilkTouchLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.SILK_TOUCH);

        AABB entityArea = new AABB(
                user.getX() - entityRadius, user.getY() - entityRadius, user.getZ() - entityRadius,
                user.getX() + entityRadius, user.getY() + entityRadius, user.getZ() + entityRadius
        );

        AABB projectileArea = new AABB(
                user.getX() - projectileRadius, user.getY() - projectileRadius, user.getZ() - projectileRadius,
                user.getX() + projectileRadius, user.getY() + projectileRadius, user.getZ() + projectileRadius
        );

        List<Entity> nearbyEntities = level.getEntities(user, entityArea,
                entity -> entity instanceof LivingEntity && entity != user
        );

        List<Entity> nearbyProjectiles = level.getEntities(user, projectileArea,
                entity -> entity instanceof Projectile
        );

        for (Entity entity : nearbyEntities) {
            if (silkTouchLevel >= 1 && (entity instanceof Player || (entity instanceof TamableAnimal tamable && tamable.isTame()))) {
                continue;
            }

            Vec3 direction = entity.position().subtract(user.position()).normalize();
            entity.setDeltaMovement(direction.scale(knockbackStrength));

            addEntityEffectModifiers(stack, level, entity);
        }

        for (Entity entity : nearbyProjectiles) {
            Vec3 velocity = entity.getDeltaMovement();
            Vec3 reversedVelocity = velocity.reverse().scale(projectileSlowFactor);

            entity.setDeltaMovement(reversedVelocity);

            if (entity instanceof Projectile projectile) {
                ((ServerLevel) level).getChunkSource().broadcastAndSend(
                        projectile, new ClientboundSetEntityMotionPacket(projectile)
                );
            }
        }
    }

    private void gatherNearbyItems(Level level, Player user, double radius) {
        if (level.isClientSide) return;

        List<ItemEntity> nearbyItems = level.getEntitiesOfClass(ItemEntity.class,
                new AABB(user.getX() - radius, user.getY() - radius, user.getZ() - radius,
                        user.getX() + radius, user.getY() + radius, user.getZ() + radius)
        );

        for (ItemEntity item : nearbyItems) {
            ItemStack stack = item.getItem();
            boolean added = user.getInventory().add(stack);

            if (added) {
                item.discard();
                level.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2F, 1.0F);
                ParticleMethods.ParticlesBurst(level, ParticleTypes.ENCHANTED_HIT,
                        item.getX(), item.getY() + 1, item.getZ(), 10, 0.5);
            }
        }
    }

    private void tryDashAttack(ItemStack stack, Player player) {

        if (!(stack.getItem() instanceof TomeItem tome)) {
            return;
        }

        EnchantmentChecker check = new EnchantmentChecker();
        int dashLevel = tome.getDashLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.TOME_DASH);

        if (dashLevel >= 1) {
            float yaw = player.getYRot();
            float pitch = player.getXRot();

            double xMotion = -Mth.sin(yaw * (float) Math.PI / 180) * Mth.cos(pitch * (float) Math.PI / 180);
            double yMotion = -Mth.sin(pitch * (float) Math.PI / 180);
            double zMotion = Mth.cos(yaw * (float) Math.PI / 180) * Mth.cos(pitch * (float) Math.PI / 180);

            float dashStrength = 1.5F + (dashLevel * 0.5F);
            double magnitude = Math.sqrt(xMotion * xMotion + yMotion * yMotion + zMotion * zMotion);
            xMotion *= dashStrength / magnitude;
            yMotion *= dashStrength / magnitude;
            zMotion *= dashStrength / magnitude;

            player.setDeltaMovement(new Vec3(xMotion, yMotion, zMotion));
            player.hasImpulse = true;

            player.startAutoSpinAttack(20);
        }
    }

    private void tryTeleport(ItemStack stack, Player player) {
        if (!(stack.getItem() instanceof TomeItem tome)) {
            return;
        }

        EnchantmentChecker check = new EnchantmentChecker();
        int stealthLevel = tome.getStealthLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.TOME_STEALTH);
        int dashLevel = tome.getDashLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.TOME_DASH);

        if (stealthLevel >= 1 && !player.level().isClientSide) {
            Level level = player.level();
            Vec3 lookVec = player.getLookAngle().normalize();

            for (int i = 16; i >= 1; i--) {
                Vec3 basePos = player.position().add(lookVec.scale(i));

                for (int yOffset = -5; yOffset <= 5; yOffset++) {
                    BlockPos blockPos = BlockPos.containing(basePos).offset(0, yOffset, 0);

                    if (isSafeTeleportPosition(level, blockPos)) {
                        Vec3 originalPosition = player.position();

                        player.randomTeleport(blockPos.getX() + 0.5, blockPos.getY(), blockPos.getZ() + 0.5, true);
                        player.resetFallDistance();

                        if (dashLevel >= 1) {
                            damageEntitiesBetween(level, player, originalPosition, player.position(), (2 + dashLevel));
                        }

                        player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, stealthLevel * 20));
                        return;
                    }
                }
            }
        }
        tryDashAttack(stack, player);
    }

    private void damageEntitiesBetween(Level level, Player player, Vec3 startPos, Vec3 endPos, float damage) {
        Vec3 direction = endPos.subtract(startPos).normalize();
        double distance = startPos.distanceTo(endPos);

        for (double t = 0; t < distance; t += 1.0) {
            Vec3 currentPos = startPos.add(direction.scale(t));
            BlockPos blockPos = BlockPos.containing(currentPos);

            List<Entity> entities = player.level().getEntities(player, new AABB(blockPos));
            for (Entity entity : entities) {
                if (entity instanceof LivingEntity && entity != player) {

                    Holder<DamageType> damageTypeHolder = level.registryAccess()
                            .registryOrThrow(Registries.DAMAGE_TYPE)
                            .getHolderOrThrow(DamageTypes.MAGIC);
                    ((LivingEntity) entity).hurt(new DamageSource(damageTypeHolder), damage);
                }
            }
        }
    }

    private boolean isSafeTeleportPosition(Level level, BlockPos pos) {
        return level.getBlockState(pos.below()).isSolidRender(level, pos.below())
                && level.getBlockState(pos).isAir()
                && level.getBlockState(pos.above()).isAir();
    }


}


