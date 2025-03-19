package net.trashelemental.enchanted_wands_tomes.item.custom.UniqueWands;

import net.minecraft.world.item.ItemStack;
import net.trashelemental.enchanted_wands_tomes.item.custom.WandItem;

public class UnbreakableWandItem extends WandItem {
    public UnbreakableWandItem(Properties properties, int baseDamage, int baseCooldown, int maxEnchantments, int enchantmentValue) {
        super(properties, baseDamage, baseCooldown, maxEnchantments, enchantmentValue);
    }

    @Override
    public int getAdjustedDurabilityLoss(ItemStack stack) {
        return 0;
    }
}
