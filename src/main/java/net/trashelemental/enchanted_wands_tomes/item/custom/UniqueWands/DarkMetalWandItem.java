package net.trashelemental.enchanted_wands_tomes.item.custom.UniqueWands;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.trashelemental.enchanted_wands_tomes.item.custom.WandItem;

import java.util.List;

public class DarkMetalWandItem extends WandItem {
    public DarkMetalWandItem(Properties properties, int baseDamage, int baseCooldown, int maxEnchantments, int enchantmentValue) {
        super(properties, baseDamage, baseCooldown, maxEnchantments, enchantmentValue);
    }

    @Override
    public int getSmiteLevel() {
        return 1;
    }

}
