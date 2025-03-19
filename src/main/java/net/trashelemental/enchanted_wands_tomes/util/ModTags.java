package net.trashelemental.enchanted_wands_tomes.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.trashelemental.enchanted_wands_tomes.EnchantedWandsTomes;

public class ModTags {

    public static class Enchantments {

        public static final TagKey<Enchantment> FIRE =
                TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("enchanted_wands_tomes","fire"));
        public static final TagKey<Enchantment> CHANNELING =
                TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("enchanted_wands_tomes","channeling"));
        public static final TagKey<Enchantment> COOLDOWN_REDUCE =
                TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("enchanted_wands_tomes","cooldown_reduce"));
        public static final TagKey<Enchantment> FREEZE =
                TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("enchanted_wands_tomes","freeze"));
        public static final TagKey<Enchantment> HEAL =
                TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("enchanted_wands_tomes","heal"));
        public static final TagKey<Enchantment> KNOCKBACK =
                TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("enchanted_wands_tomes","knockback"));
        public static final TagKey<Enchantment> LAUNCH =
                TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("enchanted_wands_tomes","launch"));
        public static final TagKey<Enchantment> LUCK =
                TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("enchanted_wands_tomes","luck"));
        public static final TagKey<Enchantment> MULTISHOT =
                TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("enchanted_wands_tomes","multishot"));
        public static final TagKey<Enchantment> SILK_TOUCH =
                TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("enchanted_wands_tomes","silk_touch"));
        public static final TagKey<Enchantment> WATER =
                TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("enchanted_wands_tomes","water"));

        public static final TagKey<Enchantment> TOME_AOE =
                TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("enchanted_wands_tomes","tome_aoe"));
        public static final TagKey<Enchantment> TOME_ARMOR =
                TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("enchanted_wands_tomes","tome_armor"));
        public static final TagKey<Enchantment> TOME_DASH =
                TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("enchanted_wands_tomes","tome_dash"));
        public static final TagKey<Enchantment> TOME_DEBUFF =
                TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("enchanted_wands_tomes","tome_debuff"));
        public static final TagKey<Enchantment> TOME_PULL =
                TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("enchanted_wands_tomes","tome_pull"));
        public static final TagKey<Enchantment> TOME_STEALTH =
                TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("enchanted_wands_tomes","tome_stealth"));

        public static final TagKey<Enchantment> WAND_AOE =
                TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("enchanted_wands_tomes","wand_aoe"));
        public static final TagKey<Enchantment> WAND_ARMOR =
                TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("enchanted_wands_tomes","wand_armor"));
        public static final TagKey<Enchantment> WAND_DAMAGE =
                TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("enchanted_wands_tomes","wand_damage"));
        public static final TagKey<Enchantment> WAND_LURE =
                TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("enchanted_wands_tomes","wand_lure"));
        public static final TagKey<Enchantment> WAND_RANGE =
                TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("enchanted_wands_tomes","wand_range"));
        public static final TagKey<Enchantment> WAND_SMITE =
                TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("enchanted_wands_tomes","wand_smite"));
        public static final TagKey<Enchantment> WAND_SPIDER =
                TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("enchanted_wands_tomes","wand_spider"));
        public static final TagKey<Enchantment> WAND_THWACK =
                TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("enchanted_wands_tomes","wand_thwack"));
    }

    public static class Blocks {




        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(EnchantedWandsTomes.MOD_ID, name));
        }
    }


    public static class Items {


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(EnchantedWandsTomes.MOD_ID, name));
        }
    }

}
