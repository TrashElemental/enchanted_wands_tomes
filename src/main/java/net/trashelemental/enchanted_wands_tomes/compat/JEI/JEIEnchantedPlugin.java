package net.trashelemental.enchanted_wands_tomes.compat.JEI;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.trashelemental.enchanted_wands_tomes.EnchantedWandsTomes;
import net.trashelemental.enchanted_wands_tomes.item.ModItems;

import java.util.List;

@JeiPlugin
public class JEIEnchantedPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(EnchantedWandsTomes.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {

        registration.addIngredientInfo(List.of(
                        new ItemStack(ModItems.WOOD_WAND.get()),
                        new ItemStack(ModItems.STONE_WAND.get()),
                        new ItemStack(ModItems.IRON_WAND.get()),
                        new ItemStack(ModItems.GOLD_WAND.get()),
                        new ItemStack(ModItems.DIAMOND_WAND.get()),
                        new ItemStack(ModItems.NETHERITE_WAND.get())),
                VanillaTypes.ITEM_STACK, Component.translatable("jei.enchanted_wands_tomes.wand_info"));

        registration.addIngredientInfo(List.of(
                        new ItemStack(ModItems.LEATHER_TOME.get()),
                        new ItemStack(ModItems.STONE_TOME.get()),
                        new ItemStack(ModItems.IRON_TOME.get()),
                        new ItemStack(ModItems.GOLD_TOME.get()),
                        new ItemStack(ModItems.DIAMOND_TOME.get()),
                        new ItemStack(ModItems.NETHERITE_TOME.get())),
                VanillaTypes.ITEM_STACK, Component.translatable("jei.enchanted_wands_tomes.tome_info"));



    }

}
