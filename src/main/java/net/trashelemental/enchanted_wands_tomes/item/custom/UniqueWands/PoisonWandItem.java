package net.trashelemental.enchanted_wands_tomes.item.custom.UniqueWands;

import net.trashelemental.enchanted_wands_tomes.item.custom.WandItem;

public class PoisonWandItem extends WandItem {
    public PoisonWandItem(Properties properties, int baseDamage, int baseCooldown, int maxEnchantments, int enchantmentValue) {
        super(properties, baseDamage, baseCooldown, maxEnchantments, enchantmentValue);
    }

    @Override
    public int getSpiderLevel() {
        return 2;
    }
}
