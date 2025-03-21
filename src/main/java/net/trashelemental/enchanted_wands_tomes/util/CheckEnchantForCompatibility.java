package net.trashelemental.enchanted_wands_tomes.util;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.enchantment.Enchantment;

public class CheckEnchantForCompatibility {

    public static boolean isEnchantmentInTags(Enchantment enchantment) {
        Holder<Enchantment> holder = BuiltInRegistries.ENCHANTMENT.wrapAsHolder(enchantment);

        return holder.is(ModTags.Enchantments.FIRE) ||
                holder.is(ModTags.Enchantments.CHANNELING) ||
                holder.is(ModTags.Enchantments.COOLDOWN_REDUCE) ||
                holder.is(ModTags.Enchantments.FREEZE) ||
                holder.is(ModTags.Enchantments.HEAL) ||
                holder.is(ModTags.Enchantments.KNOCKBACK) ||
                holder.is(ModTags.Enchantments.LAUNCH) ||
                holder.is(ModTags.Enchantments.LUCK) ||
                holder.is(ModTags.Enchantments.MULTISHOT) ||
                holder.is(ModTags.Enchantments.SILK_TOUCH) ||
                holder.is(ModTags.Enchantments.WATER) ||
                holder.is(ModTags.Enchantments.TOME_AOE) ||
                holder.is(ModTags.Enchantments.TOME_ARMOR) ||
                holder.is(ModTags.Enchantments.TOME_DASH) ||
                holder.is(ModTags.Enchantments.TOME_DEBUFF) ||
                holder.is(ModTags.Enchantments.TOME_PULL) ||
                holder.is(ModTags.Enchantments.TOME_STEALTH) ||
                holder.is(ModTags.Enchantments.WAND_AOE) ||
                holder.is(ModTags.Enchantments.WAND_ARMOR) ||
                holder.is(ModTags.Enchantments.WAND_DAMAGE) ||
                holder.is(ModTags.Enchantments.WAND_LURE) ||
                holder.is(ModTags.Enchantments.WAND_RANGE) ||
                holder.is(ModTags.Enchantments.WAND_SMITE) ||
                holder.is(ModTags.Enchantments.WAND_SPIDER) ||
                holder.is(ModTags.Enchantments.WAND_THWACK);
    }

}
