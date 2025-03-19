package net.trashelemental.enchanted_wands_tomes.util.Wand;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.trashelemental.junkyard_lib.visual.particle.ParticleMethods;

import java.util.List;
import java.util.Random;

public class WandEffects {

    public static void FireEffect(LivingEntity target, int fireTicks){
        target.igniteForTicks(fireTicks);
    }

    public static void ChannelingEffect(Level level, LivingEntity target, Entity owner, double lightningChance) {
        Random random = new Random();
        int roll = random.nextInt(100) + 1;

        if (!level.isClientSide && (roll <= lightningChance || level.isThundering()) && level.canSeeSky(target.blockPosition())) {
            LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(level);
            if (lightning != null) {
                lightning.moveTo(target.getX(), target.getY(), target.getZ());
                if (owner instanceof ServerPlayer player) {
                    lightning.setCause(player);
                }
                level.addFreshEntity(lightning);
            }
        }
    }

    public static void FreezeEffect(LivingEntity target, int freezeTime){
        target.setTicksFrozen(freezeTime);
    }

    public static void HealEffect(LivingEntity target, float healAmount) {
        target.heal(healAmount);
    }

    public static void LuckEffect(LivingEntity target, double dropChance) {
        if (!(target.level() instanceof ServerLevel serverLevel)) return;

        Random random = new Random();
        int roll = random.nextInt(100) + 1;

        if (roll <= dropChance) {
            ResourceKey<LootTable> lootTableKey = target.getLootTable();
            LootTable lootTable = serverLevel.getServer().reloadableRegistries().getLootTable(lootTableKey);

            LootParams.Builder lootParamsBuilder = new LootParams.Builder(serverLevel)
                    .withParameter(LootContextParams.THIS_ENTITY, target)
                    .withParameter(LootContextParams.ORIGIN, target.position())
                    .withOptionalParameter(LootContextParams.DAMAGE_SOURCE, target.damageSources().magic());

            LootParams lootParams = lootParamsBuilder.create(LootContextParamSets.ENTITY);
            lootTable.getRandomItems(lootParams, target.getLootTableSeed(), target::spawnAtLocation);
        }
    }

    public static void ArmorEffect(Entity owner, float healAmount) {
        if (!(owner instanceof Player player)) return;

        player.heal(healAmount);
    }

    public static void LoyaltyEffect(Level level, Entity owner, Vec3 impactPos, double radius) {
        if (!(owner instanceof Player player) || level.isClientSide) return;

        List<ItemEntity> nearbyItems = level.getEntitiesOfClass(ItemEntity.class,
                new AABB(impactPos.x - radius, impactPos.y - radius, impactPos.z - radius,
                        impactPos.x + radius, impactPos.y + radius, impactPos.z + radius));

        for (ItemEntity item : nearbyItems) {
            ItemStack stack = item.getItem();
            boolean added = player.getInventory().add(stack);

            if (added) {
                item.discard();
                level.playSound(null, owner.getX(), owner.getY(), owner.getZ(),
                        SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2F, 1.0F);
                ParticleMethods.ParticlesBurst(level, ParticleTypes.ENCHANTED_HIT,
                        item.getX(), item.getY() + 1, item.getZ(), 10, 0.5);
            }
        }
    }

    public static void SmiteEffect(LivingEntity target, int effectTime) {
        target.addEffect(new MobEffectInstance(MobEffects.GLOWING, effectTime));

        if (target.getType().is(EntityTypeTags.SENSITIVE_TO_SMITE)) {
            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, effectTime));
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, effectTime));
        }
    }

    public static void SpiderEffect(LivingEntity target, double poisonChance, int effectTime) {
        Random random = new Random();
        int roll = random.nextInt(100) + 1;

        if (roll <= poisonChance) {
            target.addEffect(new MobEffectInstance(MobEffects.POISON, effectTime));
        }

        if (target.getType().is(EntityTypeTags.SENSITIVE_TO_BANE_OF_ARTHROPODS)) {
            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, effectTime));
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, effectTime));
        }
    }

    public static void ThwackEffect(LivingEntity target, Level level, double baseDespawnChance) {
        Random random = new Random();
        double missingHealth = target.getMaxHealth() - target.getHealth();
        double despawnChance = Math.min(baseDespawnChance + missingHealth, 15.0);
        int roll = random.nextInt(100) + 1;

        if (roll <= despawnChance && !(target instanceof Player ||
                target instanceof WitherBoss ||
                target instanceof EnderDragon)) {
            target.discard();
            ParticleMethods.ParticlesBurst(target.level(), ParticleTypes.FIREWORK,
                    target.getX(), target.getY() + 1, target.getZ(), 100, 0.5);
        }
        else if (roll <= despawnChance) {
            target.setHealth(target.getHealth() - 30);
            ParticleMethods.ParticlesBurst(target.level(), ParticleTypes.FIREWORK,
                    target.getX(), target.getY() + 1, target.getZ(), 100, 0.5);
        }
    }

    public static void WaterEffect(LivingEntity target, int breathReduction, int waterDamage) {
        if (target.isInWaterRainOrBubble()) {
            target.setAirSupply(target.getAirSupply() - breathReduction);
            target.setHealth(target.getHealth() - waterDamage);
        }
    }

    public static void LaunchEffect(LivingEntity target, int effectTime) {
        target.addEffect(new MobEffectInstance(MobEffects.LEVITATION, effectTime));
    }

    public static void KnockbackEffect(LivingEntity target, Entity source, double strength) {
        if (source == null) return;

        Vec3 knockbackDirection = target.position().subtract(source.position()).normalize();
        Vec3 knockbackVelocity = new Vec3(knockbackDirection.x * strength, 0.1, knockbackDirection.z * strength);

        target.setDeltaMovement(target.getDeltaMovement().add(knockbackVelocity));
        target.hasImpulse = true;
    }


}
