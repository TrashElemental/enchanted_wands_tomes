package net.trashelemental.enchanted_wands_tomes.item.custom.UniqueWands;

import net.trashelemental.enchanted_wands_tomes.item.custom.WandItem;

public class DepthWandItem extends WandItem {
    public DepthWandItem(Properties properties, int baseDamage, int baseCooldown, int maxEnchantments, int enchantmentValue) {
        super(properties, baseDamage, baseCooldown, maxEnchantments, enchantmentValue);
    }

    @Override
    public int getWaterLevel() {
        return 1;
    }

}
