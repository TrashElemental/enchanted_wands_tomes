package net.trashelemental.enchanted_wands_tomes.item.custom.UniqueTomes;

import net.trashelemental.enchanted_wands_tomes.item.custom.TomeItem;

public class FastTomeItem extends TomeItem {
    public FastTomeItem(Properties properties, int baseCooldown, int enchantmentValue, int maxEnchantments) {
        super(properties, baseCooldown, enchantmentValue, maxEnchantments);
    }

    @Override
    public int getCooldownLevel() {
        return 1;
    }
}
