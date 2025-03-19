package net.trashelemental.enchanted_wands_tomes.item.custom.UniqueWands;

import net.trashelemental.enchanted_wands_tomes.item.custom.WandItem;

public class WardenWandItem extends WandItem {
    public WardenWandItem(Properties properties, int baseDamage, int baseCooldown, int maxEnchantments, int enchantmentValue) {
        super(properties, baseDamage, baseCooldown, maxEnchantments, enchantmentValue);
    }

    @Override
    public int getAOELevel() {
        return 2;
    }
}
