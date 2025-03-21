package net.trashelemental.enchanted_wands_tomes.util;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.enchantment.Enchantment;

public class CheckEnchantForCompatibility {

    public static boolean isEnchantmentInTags(Holder<Enchantment> enchantment) {
        return enchantment.is(ModTags.Enchantments.FIRE) ||
                enchantment.is(ModTags.Enchantments.CHANNELING) ||
                enchantment.is(ModTags.Enchantments.COOLDOWN_REDUCE) ||
                enchantment.is(ModTags.Enchantments.FREEZE) ||
                enchantment.is(ModTags.Enchantments.HEAL) ||
                enchantment.is(ModTags.Enchantments.KNOCKBACK) ||
                enchantment.is(ModTags.Enchantments.LAUNCH) ||
                enchantment.is(ModTags.Enchantments.LUCK) ||
                enchantment.is(ModTags.Enchantments.MULTISHOT) ||
                enchantment.is(ModTags.Enchantments.SILK_TOUCH) ||
                enchantment.is(ModTags.Enchantments.WATER) ||
                enchantment.is(ModTags.Enchantments.TOME_AOE) ||
                enchantment.is(ModTags.Enchantments.TOME_ARMOR) ||
                enchantment.is(ModTags.Enchantments.TOME_DASH) ||
                enchantment.is(ModTags.Enchantments.TOME_DEBUFF) ||
                enchantment.is(ModTags.Enchantments.TOME_PULL) ||
                enchantment.is(ModTags.Enchantments.TOME_STEALTH) ||
                enchantment.is(ModTags.Enchantments.WAND_AOE) ||
                enchantment.is(ModTags.Enchantments.WAND_ARMOR) ||
                enchantment.is(ModTags.Enchantments.WAND_DAMAGE) ||
                enchantment.is(ModTags.Enchantments.WAND_LURE) ||
                enchantment.is(ModTags.Enchantments.WAND_RANGE) ||
                enchantment.is(ModTags.Enchantments.WAND_SMITE) ||
                enchantment.is(ModTags.Enchantments.WAND_SPIDER) ||
                enchantment.is(ModTags.Enchantments.WAND_THWACK);
    }
}
