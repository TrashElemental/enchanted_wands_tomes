package net.trashelemental.enchanted_wands_tomes.item.custom.UniqueTomes;

import net.minecraft.world.item.ItemStack;
import net.trashelemental.enchanted_wands_tomes.item.custom.TomeItem;

public class ZaniteTomeItem extends TomeItem {
    public ZaniteTomeItem(Properties properties, int baseCooldown, int enchantmentValue, int maxEnchantments) {
        super(properties, baseCooldown, enchantmentValue, maxEnchantments);
    }

    private int getAdjustedKnockback(ItemStack stack) {
        int currentDamage = stack.getDamageValue();
        int maxDamage = stack.getMaxDamage();

        double durabilityPercent = 1.0 - (double) currentDamage / maxDamage;

        if (durabilityPercent >= 0.75) {
            return 0;
        } else if (durabilityPercent >= 0.5) {
            return 1;
        } else if (durabilityPercent >= 0.25) {
            return (int) 1.5;
        } else {
            return 3;
        }
    }


    @Override
    public int getKnockbackLevel(ItemStack stack) {

        return getAdjustedKnockback(stack);
    }
}
