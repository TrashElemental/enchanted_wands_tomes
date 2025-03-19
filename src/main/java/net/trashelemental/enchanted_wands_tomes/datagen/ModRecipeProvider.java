package net.trashelemental.enchanted_wands_tomes.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.trashelemental.enchanted_wands_tomes.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {

        //Items

        //Functional Items

        //Shaped
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WOOD_WAND.get())
                .pattern("  a")
                .pattern(" s ")
                .pattern("s  ")
                .define('a', Items.AMETHYST_SHARD)
                .define('s', Items.STICK)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(output, ResourceLocation.fromNamespaceAndPath("enchanted_wands_tomes", "wood_wand"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STONE_WAND.get())
                .pattern("  a")
                .pattern(" r ")
                .pattern("s  ")
                .define('a', Items.AMETHYST_SHARD)
                .define('s', Items.STICK)
                .define('r', Items.COBBLESTONE)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(output, ResourceLocation.fromNamespaceAndPath("enchanted_wands_tomes", "stone_wand"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IRON_WAND.get())
                .pattern("  a")
                .pattern(" r ")
                .pattern("s  ")
                .define('a', Items.AMETHYST_SHARD)
                .define('s', Items.STICK)
                .define('r', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(output, ResourceLocation.fromNamespaceAndPath("enchanted_wands_tomes", "iron_wand"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GOLD_WAND.get())
                .pattern("  a")
                .pattern(" r ")
                .pattern("s  ")
                .define('a', Items.AMETHYST_SHARD)
                .define('s', Items.STICK)
                .define('r', Items.GOLD_INGOT)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(output, ResourceLocation.fromNamespaceAndPath("enchanted_wands_tomes", "gold_wand"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_WAND.get())
                .pattern("  a")
                .pattern(" r ")
                .pattern("s  ")
                .define('a', Items.AMETHYST_SHARD)
                .define('s', Items.STICK)
                .define('r', Items.DIAMOND)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(output, ResourceLocation.fromNamespaceAndPath("enchanted_wands_tomes", "diamond_wand"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LEATHER_TOME.get())
                .pattern(" a ")
                .pattern("rbr")
                .pattern(" r ")
                .define('a', Items.AMETHYST_SHARD)
                .define('b', Items.BOOK)
                .define('r', Items.LEATHER)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(output, ResourceLocation.fromNamespaceAndPath("enchanted_wands_tomes", "leather_tome"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STONE_TOME.get())
                .pattern(" a ")
                .pattern("rbr")
                .pattern(" r ")
                .define('a', Items.AMETHYST_SHARD)
                .define('b', Items.BOOK)
                .define('r', Items.COBBLESTONE)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(output, ResourceLocation.fromNamespaceAndPath("enchanted_wands_tomes", "stone_tome"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IRON_TOME.get())
                .pattern(" a ")
                .pattern("rbr")
                .pattern(" r ")
                .define('a', Items.AMETHYST_SHARD)
                .define('b', Items.BOOK)
                .define('r', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(output, ResourceLocation.fromNamespaceAndPath("enchanted_wands_tomes", "iron_tome"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GOLD_TOME.get())
                .pattern(" a ")
                .pattern("rbr")
                .pattern(" r ")
                .define('a', Items.AMETHYST_SHARD)
                .define('b', Items.BOOK)
                .define('r', Items.GOLD_INGOT)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(output, ResourceLocation.fromNamespaceAndPath("enchanted_wands_tomes", "gold_tome"));

    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_TOME.get())
                .pattern(" a ")
                .pattern("rbr")
                .pattern(" r ")
                .define('a', Items.AMETHYST_SHARD)
                .define('b', Items.BOOK)
                .define('r', Items.DIAMOND)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(output, ResourceLocation.fromNamespaceAndPath("enchanted_wands_tomes", "diamond_tome"));


        //Smithing
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(ModItems.DIAMOND_WAND.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.MISC,
                        ModItems.NETHERITE_WAND.get()
                )
                .unlocks("has_diamond_wand", has(ModItems.DIAMOND_WAND.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("enchanted_wands_tomes", "netherite_wand"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(ModItems.DIAMOND_TOME.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.MISC,
                        ModItems.NETHERITE_TOME.get()
                )
                .unlocks("has_diamond_tome", has(ModItems.DIAMOND_TOME.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath("enchanted_wands_tomes", "netherite_tome"));



        //Armor Items


        
    }
}
