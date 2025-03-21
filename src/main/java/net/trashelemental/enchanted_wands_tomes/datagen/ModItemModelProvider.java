package net.trashelemental.enchanted_wands_tomes.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
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

        simpleItem(ModItems.ADAMANTITE_TOME);
        simpleItem(ModItems.CORINTHIUM_TOME);
        simpleItem(ModItems.BOTANIST_TOME);
        simpleItem(ModItems.DARK_METAL_TOME);
        simpleItem(ModItems.DEPTH_TOME);
        simpleItem(ModItems.DRACO_ARCANUS_TOME);
        simpleItem(ModItems.ELECTRUM_TOME);
        simpleItem(ModItems.ELEMENTIUM_TOME);
        simpleItem(ModItems.ETHER_TOME);
        simpleItem(ModItems.FIERY_TOME);
        simpleItem(ModItems.FLESH_TOME);
        simpleItem(ModItems.GRAVITITE_TOME);
        simpleItem(ModItems.HOLYSTONE_TOME);
        simpleItem(ModItems.HONEY_CRYSTAL_TOME);
        simpleItem(ModItems.IRONWOOD_TOME);
        simpleItem(ModItems.KNIGHTMETAL_TOME);
        simpleItem(ModItems.NECROMIUM_TOME);
        simpleItem(ModItems.NEPTUNIUM_TOME);
        simpleItem(ModItems.PUMPKIN_TOME);
        simpleItem(ModItems.SINFUL_TOME);
        simpleItem(ModItems.SKYROOT_TOME);
        simpleItem(ModItems.STEELEAF_TOME);
        simpleItem(ModItems.SILVER_TOME);
        simpleItem(ModItems.MANASTEEL_TOME);
        simpleItem(ModItems.TERRASTEEL_TOME);
        simpleItem(ModItems.WARDEN_TOME);
        simpleItem(ModItems.ZANITE_TOME);

        handheldItem(ModItems.ILLUNITE_WAND);
        simpleItem(ModItems.ILLUNITE_TOME);
        handheldItem(ModItems.KUKO_WAND);
        simpleItem(ModItems.KUKO_TOME);
        handheldItem(ModItems.VENOMITE_WAND);
        simpleItem(ModItems.VENOMITE_TOME);
        handheldItem(ModItems.IRIDITE_WAND);
        simpleItem(ModItems.IRIDITE_TOME);
        handheldItem(ModItems.ENDIUM_WAND);
        simpleItem(ModItems.ENDIUM_TOME);
        handheldItem(ModItems.BRIMSTEEL_WAND);
        simpleItem(ModItems.BRIMSTEEL_TOME);
        handheldItem(ModItems.ALFSTEEL_WAND);
        simpleItem(ModItems.ALFSTEEL_TOME);
        handheldItem(ModItems.SHARPLEAF_WAND);
        simpleItem(ModItems.SHARPLEAF_TOME);
        handheldItem(ModItems.DRAGONBONE_WAND);
        simpleItem(ModItems.DRAGONBONE_TOME);
        handheldItem(ModItems.DRAGONBONE_FIRE_WAND);
        simpleItem(ModItems.DRAGONBONE_FIRE_TOME);
        handheldItem(ModItems.DRAGONBONE_ICE_WAND);
        simpleItem(ModItems.DRAGONBONE_ICE_TOME);
        handheldItem(ModItems.DRAGONBONE_LIGHTNING_WAND);
        simpleItem(ModItems.DRAGONBONE_LIGHTNING_TOME);
        handheldItem(ModItems.DRAGONSTEEL_FIRE_WAND);
        simpleItem(ModItems.DRAGONSTEEL_FIRE_TOME);
        handheldItem(ModItems.DRAGONSTEEL_ICE_WAND);
        simpleItem(ModItems.DRAGONSTEEL_ICE_TOME);
        handheldItem(ModItems.DRAGONSTEEL_LIGHTNING_WAND);
        simpleItem(ModItems.DRAGONSTEEL_LIGHTNING_TOME);
        handheldItem(ModItems.JUNGLE_MYRMEX_CHITIN_WAND);
        simpleItem(ModItems.JUNGLE_MYRMEX_CHITIN_TOME);
        handheldItem(ModItems.DESERT_MYRMEX_CHITIN_WAND);
        simpleItem(ModItems.DESERT_MYRMEX_CHITIN_TOME);
        handheldItem(ModItems.INFERIUM_WAND);
        simpleItem(ModItems.INFERIUM_TOME);
        handheldItem(ModItems.PRUDENTIUM_WAND);
        simpleItem(ModItems.PRUDENTIUM_TOME);
        handheldItem(ModItems.TERTIUM_WAND);
        simpleItem(ModItems.TERTIUM_TOME);
        handheldItem(ModItems.IMPERIUM_WAND);
        simpleItem(ModItems.IMPERIUM_TOME);
        handheldItem(ModItems.SUPREMIUM_WAND);
        simpleItem(ModItems.SUPREMIUM_TOME);
        handheldItem(ModItems.ALLTHEMODIUM_WAND);
        simpleItem(ModItems.ALLTHEMODIUM_TOME);
        handheldItem(ModItems.VIBRANIUM_WAND);
        simpleItem(ModItems.VIBRANIUM_TOME);
        handheldItem(ModItems.UNOBTAINIUM_WAND);
        simpleItem(ModItems.UNOBTAINIUM_TOME);
        handheldItem(ModItems.RATLANTIS_WAND);
        simpleItem(ModItems.RATLANTIS_TOME);

    }


    private ItemModelBuilder simpleItem(DeferredItem<Item> item) {
        return getBuilder(item.getId().getPath())
                .parent(new ModelFile.UncheckedModelFile(mcLoc("item/generated")))
                .texture("layer0", modLoc("item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(DeferredBlock<Block> block) {
        ResourceLocation blockId = block.getId();
        withExistingParent(blockId.getPath(), modLoc("block/" + blockId.getPath()));
    }

    public void wallItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        ResourceLocation blockId = block.getId();
        ResourceLocation baseBlockId = baseBlock.getId();

        withExistingParent(blockId.getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", modLoc("block/" + baseBlockId.getPath()));
    }

    private void SpawnEggItem(String entityName) {
        withExistingParent(entityName + "_spawn_egg", "item/template_spawn_egg");
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(EnchantedWandsTomes.MOD_ID, "item/" + item.getId().getPath()));
    }

}
