package net.trashelemental.enchanted_wands_tomes.item.custom.UniqueTomes;

import net.trashelemental.enchanted_wands_tomes.item.custom.TomeItem;

public class ElectrumTomeItem extends TomeItem {
    public ElectrumTomeItem(Properties properties, int baseCooldown, int enchantmentValue, int maxEnchantments) {
        super(properties, baseCooldown, enchantmentValue, maxEnchantments);
    }

    @Override
    public int getCooldownLevel() {
        return 1;
    }
}
