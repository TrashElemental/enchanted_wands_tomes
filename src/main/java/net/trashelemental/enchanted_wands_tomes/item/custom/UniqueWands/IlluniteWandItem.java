package net.trashelemental.enchanted_wands_tomes.item.custom.UniqueWands;

import net.trashelemental.enchanted_wands_tomes.item.custom.WandItem;

public class IlluniteWandItem extends WandItem {
    public IlluniteWandItem(Properties properties, int baseDamage, int baseCooldown, int maxEnchantments, int enchantmentValue) {
        super(properties, baseDamage, baseCooldown, maxEnchantments, enchantmentValue);
    }

    @Override
    public int getThwackLevel() {
        return 1;
    }

    @Override
    public int getFreezeLevel() {
        return 1;
    }
}
