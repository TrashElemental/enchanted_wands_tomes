package net.trashelemental.enchanted_wands_tomes.item.custom.UniqueTomes;

import net.trashelemental.enchanted_wands_tomes.item.custom.TomeItem;

public class IlluniteTomeItem extends TomeItem {
    public IlluniteTomeItem(Properties properties, int baseCooldown, int enchantmentValue, int maxEnchantments) {
        super(properties, baseCooldown, enchantmentValue, maxEnchantments);
    }

    @Override
    public int getStealthLevel() {
        return 1;
    }

    @Override
    public int getFreezeLevel() {
        return 1;
    }
}
