package net.trashelemental.enchanted_wands_tomes.item.custom.UniqueWands;

import net.minecraft.world.item.ItemStack;
import net.trashelemental.enchanted_wands_tomes.item.custom.WandItem;

public class KnockbackWandItem extends WandItem {
    public KnockbackWandItem(Properties properties, int baseDamage, int baseCooldown, int maxEnchantments, int enchantmentValue) {
        super(properties, baseDamage, baseCooldown, maxEnchantments, enchantmentValue);
    }

    @Override
    public int getKnockbackLevel(ItemStack stack) {
        return 1;
    }
}
