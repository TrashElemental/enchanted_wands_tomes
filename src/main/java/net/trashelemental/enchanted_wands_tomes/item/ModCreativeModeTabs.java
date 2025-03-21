package net.trashelemental.enchanted_wands_tomes.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.trashelemental.enchanted_wands_tomes.EnchantedWandsTomes;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EnchantedWandsTomes.MOD_ID);

    public static final Supplier<CreativeModeTab> ENCHANTED_WANDS_TOMES_TAB = CREATIVE_MODE_TAB.register("enchanted_wands_tomes_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.LEATHER_TOME.get()))
                    .title(Component.translatable("creativetab.enchanted_wands_tomes.enchanted"))
                    .displayItems(((itemDisplayParameters, output) -> {

                        output.accept(ModItems.WOOD_WAND.get());
                        output.accept(ModItems.STONE_WAND.get());
                        output.accept(ModItems.IRON_WAND.get());
                        output.accept(ModItems.GOLD_WAND.get());
                        output.accept(ModItems.DIAMOND_WAND.get());
                        output.accept(ModItems.NETHERITE_WAND.get());

                        output.accept(ModItems.LEATHER_TOME.get());
                        output.accept(ModItems.STONE_TOME.get());
                        output.accept(ModItems.IRON_TOME.get());
                        output.accept(ModItems.GOLD_TOME.get());
                        output.accept(ModItems.DIAMOND_TOME.get());
                        output.accept(ModItems.NETHERITE_TOME.get());

                        if (ModList.get().isLoaded("naturesaura")) {
                            output.accept(ModItems.BOTANIST_WAND.get());
                            output.accept(ModItems.BOTANIST_TOME.get());
                        }

                        if (ModList.get().isLoaded("simplecorinthium")) {
                            output.accept(ModItems.CORINTHIUM_WAND.get());
                            output.accept(ModItems.CORINTHIUM_TOME.get());
                        }

                        if (ModList.get().isLoaded("enlightened_end")) {
                            output.accept(ModItems.ADAMANTITE_WAND.get());
                            output.accept(ModItems.ADAMANTITE_TOME.get());
                        }

                        if (ModList.get().isLoaded("born_in_chaos_v1")) {
                            output.accept(ModItems.DARK_METAL_WAND.get());
                            output.accept(ModItems.DARK_METAL_TOME.get());
                        }

                        if (ModList.get().isLoaded("seadwellers")) {
                            output.accept(ModItems.DEPTH_WAND.get());
                            output.accept(ModItems.DEPTH_TOME.get());
                        }

                        if (ModList.get().isLoaded("forbidden_arcanus")) {
                            output.accept(ModItems.DRACO_ARCANUS_WAND.get());
                            output.accept(ModItems.DRACO_ARCANUS_TOME.get());
                        }

                        if (ModList.get().isLoaded("oreganized")) {
                            output.accept(ModItems.ELECTRUM_WAND.get());
                            output.accept(ModItems.ELECTRUM_TOME.get());
                        }

                        if (ModList.get().isLoaded("botania")) {
                            output.accept(ModItems.MANASTEEL_WAND.get());
                            output.accept(ModItems.MANASTEEL_TOME.get());
                            output.accept(ModItems.ELEMENTIUM_WAND.get());
                            output.accept(ModItems.ELEMENTIUM_TOME.get());
                            output.accept(ModItems.TERRASTEEL_WAND.get());
                            output.accept(ModItems.TERRASTEEL_TOME.get());
                        }

                        if (ModList.get().isLoaded("sons_of_sins")) {
                            output.accept(ModItems.ETHER_WAND.get());
                            output.accept(ModItems.ETHER_TOME.get());
                            output.accept(ModItems.FLESH_WAND.get());
                            output.accept(ModItems.FLESH_TOME.get());
                            output.accept(ModItems.SINFUL_WAND.get());
                            output.accept(ModItems.SINFUL_TOME.get());
                        }

                        if (ModList.get().isLoaded("twilightforest")) {
                            output.accept(ModItems.FIERY_WAND.get());
                            output.accept(ModItems.FIERY_TOME.get());
                            output.accept(ModItems.KNIGHTMETAL_WAND.get());
                            output.accept(ModItems.KNIGHTMETAL_TOME.get());
                            output.accept(ModItems.STEELEAF_WAND.get());
                            output.accept(ModItems.STEELEAF_TOME.get());
                            output.accept(ModItems.IRONWOOD_WAND.get());
                            output.accept(ModItems.IRONWOOD_TOME.get());
                        }

                        if (ModList.get().isLoaded("aether")) {
                            output.accept(ModItems.SKYROOT_WAND.get());
                            output.accept(ModItems.SKYROOT_TOME.get());
                            output.accept(ModItems.HOLYSTONE_WAND.get());
                            output.accept(ModItems.HOLYSTONE_TOME.get());
                            output.accept(ModItems.GRAVITITE_WAND.get());
                            output.accept(ModItems.GRAVITITE_TOME.get());
                            output.accept(ModItems.ZANITE_WAND.get());
                            output.accept(ModItems.ZANITE_TOME.get());
                        }

                        if (ModList.get().isLoaded("the_bumblezone")) {
                            output.accept(ModItems.HONEY_CRYSTAL_WAND.get());
                            output.accept(ModItems.HONEY_CRYSTAL_TOME.get());
                        }

                        if (ModList.get().isLoaded("caverns_and_chasms")) {
                            output.accept(ModItems.NECROMIUM_WAND.get());
                            output.accept(ModItems.NECROMIUM_TOME.get());
                        }

                        if (ModList.get().isLoaded("aquaculture")) {
                            output.accept(ModItems.NEPTUNIUM_WAND.get());
                            output.accept(ModItems.NEPTUNIUM_TOME.get());
                        }

                        if (ModList.get().isLoaded("realmrpg_creep")) {
                            output.accept(ModItems.PUMPKIN_WAND.get());
                            output.accept(ModItems.PUMPKIN_TOME.get());
                        }

                        if (ModList.get().isLoaded("deeperdarker")) {
                            output.accept(ModItems.WARDEN_WAND.get());
                            output.accept(ModItems.WARDEN_TOME.get());
                        }

                        //Modded materials wave 2

                        if (ModList.get().isLoaded("allthemodium")) {
                            output.accept(ModItems.ALLTHEMODIUM_WAND.get());
                            output.accept(ModItems.ALLTHEMODIUM_TOME.get());
                            output.accept(ModItems.VIBRANIUM_WAND.get());
                            output.accept(ModItems.VIBRANIUM_TOME.get());
                            output.accept(ModItems.UNOBTAINIUM_WAND.get());
                            output.accept(ModItems.UNOBTAINIUM_TOME.get());
                        }

                        if (ModList.get().isLoaded("mysticalagriculture")) {
                            output.accept(ModItems.INFERIUM_WAND.get());
                            output.accept(ModItems.INFERIUM_TOME.get());
                            output.accept(ModItems.PRUDENTIUM_WAND.get());
                            output.accept(ModItems.PRUDENTIUM_TOME.get());
                            output.accept(ModItems.TERTIUM_WAND.get());
                            output.accept(ModItems.TERTIUM_TOME.get());
                            output.accept(ModItems.IMPERIUM_WAND.get());
                            output.accept(ModItems.IMPERIUM_TOME.get());
                            output.accept(ModItems.SUPREMIUM_WAND.get());
                            output.accept(ModItems.SUPREMIUM_TOME.get());
                        }

                        if (ModList.get().isLoaded("iceandfire")) {
                            output.accept(ModItems.DRAGONBONE_WAND.get());
                            output.accept(ModItems.DRAGONBONE_TOME.get());
                            output.accept(ModItems.DRAGONBONE_FIRE_WAND.get());
                            output.accept(ModItems.DRAGONBONE_FIRE_TOME.get());
                            output.accept(ModItems.DRAGONBONE_ICE_WAND.get());
                            output.accept(ModItems.DRAGONBONE_ICE_TOME.get());
                            output.accept(ModItems.DRAGONBONE_LIGHTNING_WAND.get());
                            output.accept(ModItems.DRAGONBONE_LIGHTNING_TOME.get());
                            output.accept(ModItems.DRAGONSTEEL_FIRE_WAND.get());
                            output.accept(ModItems.DRAGONSTEEL_FIRE_TOME.get());
                            output.accept(ModItems.DRAGONSTEEL_ICE_WAND.get());
                            output.accept(ModItems.DRAGONSTEEL_ICE_TOME.get());
                            output.accept(ModItems.DRAGONSTEEL_LIGHTNING_WAND.get());
                            output.accept(ModItems.DRAGONSTEEL_LIGHTNING_TOME.get());
                            output.accept(ModItems.DESERT_MYRMEX_CHITIN_WAND.get());
                            output.accept(ModItems.DESERT_MYRMEX_CHITIN_TOME.get());
                            output.accept(ModItems.JUNGLE_MYRMEX_CHITIN_WAND.get());
                            output.accept(ModItems.JUNGLE_MYRMEX_CHITIN_TOME.get());
                        }

                        if (ModList.get().isLoaded("mythicbotany")) {
                            output.accept(ModItems.ALFSTEEL_WAND.get());
                            output.accept(ModItems.ALFSTEEL_TOME.get());
                        }

                        if (ModList.get().isLoaded("organics")) {
                            output.accept(ModItems.KUKO_WAND.get());
                            output.accept(ModItems.KUKO_TOME.get());
                            output.accept(ModItems.VENOMITE_WAND.get());
                            output.accept(ModItems.VENOMITE_TOME.get());
                            output.accept(ModItems.IRIDITE_WAND.get());
                            output.accept(ModItems.IRIDITE_TOME.get());
                            output.accept(ModItems.ENDIUM_WAND.get());
                            output.accept(ModItems.ENDIUM_TOME.get());
                        }

                        if (ModList.get().isLoaded("seeds")) {
                            output.accept(ModItems.SHARPLEAF_WAND.get());
                            output.accept(ModItems.SHARPLEAF_TOME.get());
                        }

                        if (ModList.get().isLoaded("blazegear")) {
                            output.accept(ModItems.BRIMSTEEL_WAND.get());
                            output.accept(ModItems.BRIMSTEEL_TOME.get());
                        }

                        if (ModList.get().isLoaded("rats")) {
                            output.accept(ModItems.RATLANTIS_WAND.get());
                            output.accept(ModItems.RATLANTIS_TOME.get());
                        }

                        if (ModList.get().isLoaded("biomemakeover")) {
                            output.accept(ModItems.ILLUNITE_WAND.get());
                            output.accept(ModItems.ILLUNITE_TOME.get());
                        }

                        //Various
                        output.accept(ModItems.SILVER_WAND.get());
                        output.accept(ModItems.SILVER_TOME.get());

                    })).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

    @SubscribeEvent
    public static void onBuildCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == ENCHANTED_WANDS_TOMES_TAB) {



        }
    }

}
