package net.trashelemental.enchanted_wands_tomes.item.custom.UniqueWands;

import net.minecraft.world.item.ItemStack;
import net.trashelemental.enchanted_wands_tomes.item.custom.WandItem;

public class ZaniteWandItem extends WandItem {
    public ZaniteWandItem(Properties properties, int baseDamage, int baseCooldown, int maxEnchantments, int enchantmentValue) {
        super(properties, baseDamage, baseCooldown, maxEnchantments, enchantmentValue);
    }

    private int getBonusDamage(ItemStack stack) {
        int currentDamage = stack.getDamageValue();
        int maxDamage = stack.getMaxDamage();

        double durabilityPercent = 1.0 - (double) currentDamage / maxDamage;

        if (durabilityPercent >= 0.75) {
            return 0;
        } else if (durabilityPercent >= 0.5) {
            return 1;
        } else if (durabilityPercent >= 0.25) {
            return 2;
        } else {
            return 3;
        }
    }


    @Override
    public int getDamageLevel(ItemStack stack) {

        return getBonusDamage(stack);
    }

}
