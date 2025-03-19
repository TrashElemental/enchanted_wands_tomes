package net.trashelemental.enchanted_wands_tomes.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.trashelemental.enchanted_wands_tomes.EnchantedWandsTomes;

public class ModTags {

    public static class Enchantments {

        public static final TagKey<Enchantment> FIRE =
                TagKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix("fire"));
        public static final TagKey<Enchantment> CHANNELING =
                TagKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix("channeling"));
        public static final TagKey<Enchantment> COOLDOWN_REDUCE =
                TagKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix("cooldown_reduce"));
        public static final TagKey<Enchantment> FREEZE =
                TagKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix("freeze"));
        public static final TagKey<Enchantment> HEAL =
                TagKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix("heal"));
        public static final TagKey<Enchantment> KNOCKBACK =
                TagKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix("knockback"));
        public static final TagKey<Enchantment> LAUNCH =
                TagKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix("launch"));
        public static final TagKey<Enchantment> LUCK =
                TagKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix("luck"));
        public static final TagKey<Enchantment> MULTISHOT =
                TagKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix("multishot"));
        public static final TagKey<Enchantment> SILK_TOUCH =
                TagKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix("silk_touch"));
        public static final TagKey<Enchantment> WATER =
                TagKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix("water"));

        public static final TagKey<Enchantment> TOME_AOE =
                TagKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix("tome_aoe"));
        public static final TagKey<Enchantment> TOME_ARMOR =
                TagKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix("tome_armor"));
        public static final TagKey<Enchantment> TOME_DASH =
                TagKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix("tome_dash"));
        public static final TagKey<Enchantment> TOME_DEBUFF =
                TagKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix("tome_debuff"));
        public static final TagKey<Enchantment> TOME_PULL =
                TagKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix("tome_pull"));
        public static final TagKey<Enchantment> TOME_STEALTH =
                TagKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix("tome_stealth"));

        public static final TagKey<Enchantment> WAND_AOE =
                TagKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix("wand_aoe"));
        public static final TagKey<Enchantment> WAND_ARMOR =
                TagKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix("wand_armor"));
        public static final TagKey<Enchantment> WAND_DAMAGE =
                TagKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix("wand_damage"));
        public static final TagKey<Enchantment> WAND_LURE =
                TagKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix("wand_lure"));
        public static final TagKey<Enchantment> WAND_RANGE =
                TagKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix("wand_range"));
        public static final TagKey<Enchantment> WAND_SMITE =
                TagKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix("wand_smite"));
        public static final TagKey<Enchantment> WAND_SPIDER =
                TagKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix("wand_spider"));
        public static final TagKey<Enchantment> WAND_THWACK =
                TagKey.create(Registries.ENCHANTMENT, EnchantedWandsTomes.prefix("wand_thwack"));
    }


    public static class Items {


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(EnchantedWandsTomes.MOD_ID, name));
        }
    }

    public static class EntityTags {



    }

}
