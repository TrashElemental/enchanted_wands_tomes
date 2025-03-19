package net.trashelemental.enchanted_wands_tomes.item.custom.UniqueTomes;

import net.minecraft.world.item.ItemStack;
import net.trashelemental.enchanted_wands_tomes.item.custom.TomeItem;

public class KnockbackTomeItem extends TomeItem {
    public KnockbackTomeItem(Properties properties, int baseCooldown, int enchantmentValue, int maxEnchantments) {
        super(properties, baseCooldown, enchantmentValue, maxEnchantments);
    }

    @Override
    public int getKnockbackLevel(ItemStack stack) {
        return 1;
    }
}
