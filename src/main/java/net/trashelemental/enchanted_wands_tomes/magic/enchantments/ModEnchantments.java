package net.trashelemental.enchanted_wands_tomes.magic.enchantments;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.trashelemental.enchanted_wands_tomes.EnchantedWandsTomes;

public class ModEnchantments {




    private static ResourceKey<Enchantment> key(String p_345314_) {
        return ResourceKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix(p_345314_));
    }

}

