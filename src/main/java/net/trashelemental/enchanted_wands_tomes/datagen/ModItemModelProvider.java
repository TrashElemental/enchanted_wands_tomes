package net.trashelemental.enchanted_wands_tomes.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.trashelemental.enchanted_wands_tomes.EnchantedWandsTomes;
import net.trashelemental.enchanted_wands_tomes.item.ModItems;


public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EnchantedWandsTomes.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        handheldItem(ModItems.WOOD_WAND);
        handheldItem(ModItems.STONE_WAND);
        handheldItem(ModItems.IRON_WAND);
        handheldItem(ModItems.GOLD_WAND);
        handheldItem(ModItems.DIAMOND_WAND);
        handheldItem(ModItems.NETHERITE_WAND);

        handheldItem(ModItems.ADAMANTITE_WAND);
        handheldItem(ModItems.CORINTHIUM_WAND);
        handheldItem(ModItems.BOTANIST_WAND);
        handheldItem(ModItems.DARK_METAL_WAND);
        handheldItem(ModItems.DEPTH_WAND);
        handheldItem(ModItems.DRACO_ARCANUS_WAND);
        handheldItem(ModItems.ELECTRUM_WAND);
        handheldItem(ModItems.ELEMENTIUM_WAND);
        handheldItem(ModItems.ETHER_WAND);
        handheldItem(ModItems.FIERY_WAND);
        handheldItem(ModItems.FLESH_WAND);
        handheldItem(ModItems.GRAVITITE_WAND);
        handheldItem(ModItems.HOLYSTONE_WAND);
        handheldItem(ModItems.HONEY_CRYSTAL_WAND);
        handheldItem(ModItems.IRONWOOD_WAND);
        handheldItem(ModItems.KNIGHTMETAL_WAND);
        handheldItem(ModItems.NECROMIUM_WAND);
        handheldItem(ModItems.NEPTUNIUM_WAND);
        handheldItem(ModItems.PUMPKIN_WAND);
        handheldItem(ModItems.SINFUL_WAND);
        handheldItem(ModItems.SKYROOT_WAND);
        handheldItem(ModItems.STEELEAF_WAND);
        handheldItem(ModItems.SILVER_WAND);
        handheldItem(ModItems.MANASTEEL_WAND);
        handheldItem(ModItems.TERRASTEEL_WAND);
        handheldItem(ModItems.WARDEN_WAND);
        handheldItem(ModItems.ZANITE_WAND);

        simpleItem(ModItems.LEATHER_TOME);
        simpleItem(ModItems.STONE_TOME);
        simpleItem(ModItems.IRON_TOME);
        simpleItem(ModItems.GOLD_TOME);
        simpleItem(ModItems.DIAMOND_TOME);
        simpleItem(ModItems.NETHERITE_TOME);

//        simpleItem(ModItems.ADAMANTITE_TOME);
//        simpleItem(ModItems.CORINTHIUM_TOME);
//        simpleItem(ModItems.BOTANIST_TOME);
//        simpleItem(ModItems.DARK_METAL_TOME);
//        simpleItem(ModItems.DEPTH_TOME);
//        simpleItem(ModItems.DRACO_ARCANUS_TOME);
//        simpleItem(ModItems.ELECTRUM_TOME);
//        simpleItem(ModItems.ELEMENTIUM_TOME);
//        simpleItem(ModItems.ETHER_TOME);
//        simpleItem(ModItems.FIERY_TOME);
//        simpleItem(ModItems.FLESH_TOME);
//        simpleItem(ModItems.GRAVITITE_TOME);
//        simpleItem(ModItems.HOLYSTONE_TOME);
//        simpleItem(ModItems.HONEY_CRYSTAL_TOME);
//        simpleItem(ModItems.IRONWOOD_TOME);
//        simpleItem(ModItems.KNIGHTMETAL_TOME);
//        simpleItem(ModItems.NECROMIUM_TOME);
//        simpleItem(ModItems.NEPTUNIUM_TOME);
//        simpleItem(ModItems.PUMPKIN_TOME);
//        simpleItem(ModItems.SINFUL_TOME);
//        simpleItem(ModItems.SKYROOT_TOME);
//        simpleItem(ModItems.STEELEAF_TOME);
//        simpleItem(ModItems.SILVER_TOME);
//        simpleItem(ModItems.MANASTEEL_TOME);
//        simpleItem(ModItems.TERRASTEEL_TOME);
//        simpleItem(ModItems.WARDEN_TOME);
//        simpleItem(ModItems.ZANITE_TOME);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(EnchantedWandsTomes.MOD_ID, "item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(EnchantedWandsTomes.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseblock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(EnchantedWandsTomes.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseblock.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(EnchantedWandsTomes.MOD_ID, "item/" + item.getId().getPath()));
    }
}
