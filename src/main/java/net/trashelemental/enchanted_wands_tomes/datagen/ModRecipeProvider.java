package net.trashelemental.enchanted_wands_tomes.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.trashelemental.enchanted_wands_tomes.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        //Functional Items

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WOOD_WAND.get())
                .pattern("  a")
                .pattern(" s ")
                .pattern("s  ")
                .define('a', Items.AMETHYST_SHARD)
                .define('s', Items.STICK)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STONE_WAND.get())
                .pattern("  a")
                .pattern(" r ")
                .pattern("s  ")
                .define('a', Items.AMETHYST_SHARD)
                .define('s', Items.STICK)
                .define('r', Items.COBBLESTONE)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IRON_WAND.get())
                .pattern("  a")
                .pattern(" r ")
                .pattern("s  ")
                .define('a', Items.AMETHYST_SHARD)
                .define('s', Items.STICK)
                .define('r', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GOLD_WAND.get())
                .pattern("  a")
                .pattern(" r ")
                .pattern("s  ")
                .define('a', Items.AMETHYST_SHARD)
                .define('s', Items.STICK)
                .define('r', Items.GOLD_INGOT)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_WAND.get())
                .pattern("  a")
                .pattern(" r ")
                .pattern("s  ")
                .define('a', Items.AMETHYST_SHARD)
                .define('s', Items.STICK)
                .define('r', Items.DIAMOND)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LEATHER_TOME.get())
                .pattern(" a ")
                .pattern("rbr")
                .pattern(" r ")
                .define('a', Items.AMETHYST_SHARD)
                .define('b', Items.BOOK)
                .define('r', Items.LEATHER)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STONE_TOME.get())
                .pattern(" a ")
                .pattern("rbr")
                .pattern(" r ")
                .define('a', Items.AMETHYST_SHARD)
                .define('b', Items.BOOK)
                .define('r', Items.COBBLESTONE)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IRON_TOME.get())
                .pattern(" a ")
                .pattern("rbr")
                .pattern(" r ")
                .define('a', Items.AMETHYST_SHARD)
                .define('b', Items.BOOK)
                .define('r', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GOLD_TOME.get())
                .pattern(" a ")
                .pattern("rbr")
                .pattern(" r ")
                .define('a', Items.AMETHYST_SHARD)
                .define('b', Items.BOOK)
                .define('r', Items.GOLD_INGOT)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_TOME.get())
                .pattern(" a ")
                .pattern("rbr")
                .pattern(" r ")
                .define('a', Items.AMETHYST_SHARD)
                .define('b', Items.BOOK)
                .define('r', Items.DIAMOND)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(pWriter);

        //Smithing
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(ModItems.DIAMOND_WAND.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.MISC,
                        ModItems.NETHERITE_WAND.get()
                )
                .unlocks("has_diamond_wand", has(ModItems.DIAMOND_WAND.get()))
                .save(pWriter, new ResourceLocation("enchanted_wands_tomes", "netherite_wand"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(ModItems.DIAMOND_TOME.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.MISC,
                        ModItems.NETHERITE_TOME.get()
                )
                .unlocks("has_diamond_tome", has(ModItems.DIAMOND_TOME.get()))
                .save(pWriter, new ResourceLocation("enchanted_wands_tomes", "netherite_tome"));

        //Armors


    }

}



