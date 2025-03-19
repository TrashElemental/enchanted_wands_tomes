package net.trashelemental.enchanted_wands_tomes.util.Wand;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.trashelemental.enchanted_wands_tomes.entity.custom.WandProjectileEntity;
import net.trashelemental.enchanted_wands_tomes.item.custom.WandItem;
import net.trashelemental.enchanted_wands_tomes.util.EnchantmentChecker;
import net.trashelemental.enchanted_wands_tomes.util.ModTags;

public class WandFireProjectile {

    public void performProjectileAttack(Player player, Level level, double speed, int damage, ItemStack stack) {
        if (level.isClientSide) return;

        Vec3 lookDirection = player.getLookAngle().normalize();
        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.ENDER_PEARL_THROW, SoundSource.PLAYERS, 0.5F, 1.5F);

        WandProjectileEntity mainProjectile = new WandProjectileEntity(level, player, lookDirection,
                speed, damage);
        checkModifiers(stack, mainProjectile);
        level.addFreshEntity(mainProjectile);

        Vec3 projectilePos = mainProjectile.position();

        EnchantmentChecker check = new EnchantmentChecker();
        int bonusShots = check.checkEnchantmentLevel(stack, ModTags.Enchantments.MULTISHOT);
        if (bonusShots > 0) {
            Vec3 rightVector = lookDirection.cross(new Vec3(0, 1, 0)).normalize();

            for (int i = 0; i < bonusShots; i++) {
                double offset = ((i / 2) + 1) * (i % 2 == 0 ? 0.5 : -0.5);

                Vec3 spawnPosition = projectilePos.add(rightVector.scale(offset));

                WandProjectileEntity bonusProjectile = new WandProjectileEntity(level, player, lookDirection,
                        speed, damage);
                bonusProjectile.setPos(spawnPosition.x, spawnPosition.y, spawnPosition.z);

                checkModifiers(stack, bonusProjectile);
                level.addFreshEntity(bonusProjectile);
            }
        }
    }

    private void checkModifiers(ItemStack stack, WandProjectileEntity projectile) {

        if (!(stack.getItem() instanceof WandItem wand)) {
            return;
        }
        EnchantmentChecker check = new EnchantmentChecker();

        int fireLevel = wand.getFireLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.FIRE);
        int channelingLevel = wand.getChannelingLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.CHANNELING);
        int freezeLevel = wand.getFreezeLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.FREEZE);
        int knockbackLevel = wand.getKnockbackLevel(stack) + check.checkEnchantmentLevel(stack, ModTags.Enchantments.KNOCKBACK);
        int launchLevel = wand.getLaunchLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.LAUNCH);
        int luckLevel = wand.getLuckLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.LUCK);
        int waterLevel = wand.getWaterLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.WATER);
        int smiteLevel = wand.getSmiteLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.WAND_SMITE);
        int spiderLevel = wand.getSpiderLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.WAND_SPIDER);
        int thwackLevel = wand.getThwackLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.WAND_THWACK);
        int healLevel = wand.getHealLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.HEAL);
        int silkTouchLevel = wand.getSilkTouchLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.SILK_TOUCH);
        int AOELevel = wand.getAOELevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.WAND_AOE);
        int collectLevel = wand.getCollectLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.WAND_LURE);
        int armorLevel = wand.getArmorLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.WAND_ARMOR);


        if (fireLevel > 0) {
            projectile.setFireEffect(true);
            projectile.setBurnTicks(80 + (fireLevel * 20));
        }

        if (channelingLevel > 0) {
            projectile.setChannelingEffect(true);
            projectile.setLightningChance(50 * channelingLevel);
        }

        if (waterLevel > 0) {
            projectile.setWaterEffect(true);
            projectile.setWaterDamage(waterLevel);
            projectile.setBreathReduction(2 * waterLevel);
        }

        if (spiderLevel > 0) {
            projectile.setSpiderEffect(true);
            projectile.setPoisonChance(33 * spiderLevel);
            projectile.setPoisonEffectTime(80 * (spiderLevel * 20));
        }

        if (smiteLevel > 0) {
            projectile.setSmiteEffect(true);
            projectile.setSmiteEffectTime(80 * (smiteLevel * 20));
        }

        if (freezeLevel > 0) {
            projectile.setFreezeEffect(true);
            projectile.setFreezeTicks(280 * freezeLevel);
        }

        if (thwackLevel > 0) {
            projectile.setThwackEffect(true);
            projectile.setInstantDespawnChance(thwackLevel);
        }

        if (luckLevel > 0) {
            projectile.setLuckEffect(true);
            projectile.setDropChance(20 * luckLevel);
        }

        if (healLevel > 0) {
            projectile.setHealEffect(true);
            projectile.setHealAmount(healLevel * 4);
        }

        if (silkTouchLevel > 0) {
            projectile.setSilkTouchEffect(true);
        }

        if (AOELevel > 0) {
            projectile.setAOEEffect(true);
            projectile.setAOEArea(1.5 + (AOELevel * 0.5));
        }

        if (luckLevel > 0) {
            projectile.setLuckEffect(true);
            projectile.setDropChance(10 + (5 * luckLevel));
        }

        if (collectLevel > 0) {
            projectile.setCollectEffect(true);
            projectile.setCollectArea(1.5 + (collectLevel * 0.5));
        }

        if (armorLevel > 0) {
            projectile.setArmorEffect(true);
            projectile.setArmorHealAmount(armorLevel);
        }

        if (launchLevel > 0) {
            projectile.setLaunchEffect(true);
            projectile.setLaunchEffectTime(40 + (20 * launchLevel));
        }

        if (knockbackLevel > 0) {
            projectile.setKnockbackEffect(true);
            projectile.setKnockbackStrength(1.5 * (0.5 * knockbackLevel));
        }

    }
}
