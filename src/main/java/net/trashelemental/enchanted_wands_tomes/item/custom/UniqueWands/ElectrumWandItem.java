package net.trashelemental.enchanted_wands_tomes.item.custom.UniqueWands;

import net.trashelemental.enchanted_wands_tomes.item.custom.WandItem;

public class ElectrumWandItem extends WandItem {
    public ElectrumWandItem(Properties properties, int baseDamage, int baseCooldown, int maxEnchantments, int enchantmentValue) {
        super(properties, baseDamage, baseCooldown, maxEnchantments, enchantmentValue);
    }

    @Override
    public int getCooldownLevel() {
        return 1;
    }

    @Override
    public int getRangeLevel() {
        return 1;
    }
}
