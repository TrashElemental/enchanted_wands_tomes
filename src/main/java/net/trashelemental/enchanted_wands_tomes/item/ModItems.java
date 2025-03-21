package net.trashelemental.enchanted_wands_tomes.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.trashelemental.enchanted_wands_tomes.EnchantedWandsTomes;
import net.trashelemental.enchanted_wands_tomes.item.custom.TomeItem;
import net.trashelemental.enchanted_wands_tomes.item.custom.UniqueTomes.*;
import net.trashelemental.enchanted_wands_tomes.item.custom.UniqueWands.*;
import net.trashelemental.enchanted_wands_tomes.item.custom.UniqueWands.FireWandItem;
import net.trashelemental.enchanted_wands_tomes.item.custom.WandItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EnchantedWandsTomes.MOD_ID);

    //Functional Items
    public static final DeferredItem<Item> WOOD_WAND = ITEMS.register("wand_wood",
            () -> new WandItem(new Item.Properties().durability(45), 3, 20, 1, 10));
    public static final DeferredItem<Item> STONE_WAND = ITEMS.register("wand_stone",
            () -> new WandItem(new Item.Properties().durability(100), 4, 20, 2, 10));
    public static final DeferredItem<Item> IRON_WAND = ITEMS.register("wand_iron",
            () -> new WandItem(new Item.Properties().durability(190), 5, 20, 3, 15));
    public static final DeferredItem<Item> GOLD_WAND = ITEMS.register("wand_gold",
            () -> new WandItem(new Item.Properties().durability(30), 4, 10, 5, 30));
    public static final DeferredItem<Item> DIAMOND_WAND = ITEMS.register("wand_diamond",
            () -> new WandItem(new Item.Properties().durability(1200), 6, 20, 5, 20));
    public static final DeferredItem<Item> NETHERITE_WAND = ITEMS.register("wand_netherite",
            () -> new WandItem(new Item.Properties().durability(1560), 7, 20, 6, 25));

    public static final DeferredItem<Item> LEATHER_TOME = ITEMS.register("tome_leather",
            () -> new TomeItem(new Item.Properties().durability(45), 40, 10, 1));
    public static final DeferredItem<Item> STONE_TOME = ITEMS.register("tome_stone",
            () -> new TomeItem(new Item.Properties().durability(100), 40, 10, 2));
    public static final DeferredItem<Item> IRON_TOME = ITEMS.register("tome_iron",
            () -> new TomeItem(new Item.Properties().durability(190), 40, 15, 3));
    public static final DeferredItem<Item> GOLD_TOME = ITEMS.register("tome_gold",
            () -> new TomeItem(new Item.Properties().durability(40), 20, 30, 5));
    public static final DeferredItem<Item> DIAMOND_TOME = ITEMS.register("tome_diamond",
            () -> new TomeItem(new Item.Properties().durability(1200), 40, 20, 5));
    public static final DeferredItem<Item> NETHERITE_TOME = ITEMS.register("tome_netherite",
            () -> new TomeItem(new Item.Properties().durability(1560), 40, 25, 6));


    //Armor Items



    //Compat Items
    public static final DeferredItem<Item> ADAMANTITE_WAND = ITEMS.register("wand_adamantite",
            () -> new WandItem(new Item.Properties().durability(1560), 8, 30, 7, 30));
    public static final DeferredItem<Item> ADAMANTITE_TOME = ITEMS.register("tome_adamantite",
            () -> new TomeItem(new Item.Properties().durability(1560), 50, 30, 7));
    public static final DeferredItem<Item> CORINTHIUM_WAND = ITEMS.register("wand_corinthium",
            () -> new WandItem(new Item.Properties().durability(790), 5, 20, 3, 17));
    public static final DeferredItem<Item> CORINTHIUM_TOME = ITEMS.register("tome_corinthium",
            () -> new TomeItem(new Item.Properties().durability(790), 40, 17, 3));
    public static final DeferredItem<Item> DARK_METAL_WAND = ITEMS.register("wand_dark_metal",
            () -> new DarkMetalWandItem(new Item.Properties().durability(1000), 6, 20, 5, 25));
    public static final DeferredItem<Item> DARK_METAL_TOME = ITEMS.register("tome_dark_metal",
            () -> new DarkMetalTomeItem(new Item.Properties().durability(1000), 40, 25, 5));
    public static final DeferredItem<Item> DEPTH_WAND = ITEMS.register("wand_depth",
            () -> new DepthWandItem(new Item.Properties().durability(1100), 6, 20, 5, 20));
    public static final DeferredItem<Item> DEPTH_TOME = ITEMS.register("tome_depth",
            () -> new DepthTomeItem(new Item.Properties().durability(1100), 40, 20, 5));
    public static final DeferredItem<Item> DRACO_ARCANUS_WAND = ITEMS.register("wand_draco_arcanus",
            () -> new LightningWandItem(new Item.Properties().durability(2300), 10, 20, 8, 30));
    public static final DeferredItem<Item> DRACO_ARCANUS_TOME = ITEMS.register("tome_draco_arcanus",
            () -> new LightningTomeItem(new Item.Properties().durability(2300), 60, 30, 8));
    public static final DeferredItem<Item> ELECTRUM_WAND = ITEMS.register("wand_electrum",
            () -> new FastWandItem(new Item.Properties().durability(1460), 6, 10, 6, 25));
    public static final DeferredItem<Item> ELECTRUM_TOME = ITEMS.register("tome_electrum",
            () -> new FastTomeItem(new Item.Properties().durability(1460), 20, 25, 6));
    public static final DeferredItem<Item> ETHER_WAND = ITEMS.register("wand_ether",
            () -> new EtherWandItem(new Item.Properties().durability(1560), 4, 20, 4, 15));
    public static final DeferredItem<Item> ETHER_TOME = ITEMS.register("tome_ether",
            () -> new EtherTomeItem(new Item.Properties().durability(1560), 40, 15, 4));
    public static final DeferredItem<Item> FIERY_WAND = ITEMS.register("wand_fiery",
            () -> new FireWandItem(new Item.Properties().durability(960), 7, 20, 7, 20));
    public static final DeferredItem<Item> FIERY_TOME = ITEMS.register("tome_fiery",
            () -> new FireTomeItem(new Item.Properties().durability(960), 40, 20, 7));
    public static final DeferredItem<Item> FLESH_WAND = ITEMS.register("wand_flesh",
            () -> new FleshWandItem(new Item.Properties().durability(90), 7, 20, 5, 25));
    public static final DeferredItem<Item> FLESH_TOME = ITEMS.register("tome_flesh",
            () -> new FleshTomeItem(new Item.Properties().durability(90), 40, 25, 5));
    public static final DeferredItem<Item> GRAVITITE_WAND = ITEMS.register("wand_gravitite",
            () -> new GravititeWandItem(new Item.Properties().durability(1450), 6, 20, 6, 20));
    public static final DeferredItem<Item> GRAVITITE_TOME = ITEMS.register("tome_gravitite",
            () -> new GravititeTomeItem(new Item.Properties().durability(1450), 40, 20, 6));
    public static final DeferredItem<Item> HOLYSTONE_WAND = ITEMS.register("wand_holystone",
            () -> new LuckWandItem(new Item.Properties().durability(100), 4, 20, 3, 15));
    public static final DeferredItem<Item> HOLYSTONE_TOME = ITEMS.register("tome_holystone",
            () -> new LuckTomeItem(new Item.Properties().durability(100), 40, 15, 3));
    public static final DeferredItem<Item> HONEY_CRYSTAL_WAND = ITEMS.register("wand_honey_crystal",
            () -> new PoisonWandItem(new Item.Properties().durability(45), 10, 20, 6, 30));
    public static final DeferredItem<Item> HONEY_CRYSTAL_TOME = ITEMS.register("tome_honey_crystal",
            () -> new DebuffTomeItem(new Item.Properties().durability(45), 40, 30, 6));
    public static final DeferredItem<Item> IRONWOOD_WAND = ITEMS.register("wand_ironwood",
            () -> new KnockbackWandItem(new Item.Properties().durability(450), 5, 20, 4, 15));
    public static final DeferredItem<Item> IRONWOOD_TOME = ITEMS.register("tome_ironwood",
            () -> new KnockbackTomeItem(new Item.Properties().durability(450), 60, 15, 4));
    public static final DeferredItem<Item> KNIGHTMETAL_WAND = ITEMS.register("wand_knightmetal",
            () -> new KnockbackWandItem(new Item.Properties().durability(450), 6, 20, 5, 15));
    public static final DeferredItem<Item> KNIGHTMETAL_TOME = ITEMS.register("tome_knightmetal",
            () -> new KnockbackTomeItem(new Item.Properties().durability(450), 60, 15, 5));
    public static final DeferredItem<Item> NECROMIUM_WAND = ITEMS.register("wand_necromium",
            () -> new FreezeWandItem(new Item.Properties().durability(1960), 6, 20, 6, 30));
    public static final DeferredItem<Item> NECROMIUM_TOME = ITEMS.register("tome_necromium",
            () -> new DebuffTomeItem(new Item.Properties().durability(1960), 40, 30, 6));
    public static final DeferredItem<Item> NEPTUNIUM_WAND = ITEMS.register("wand_neptunium",
            () -> new NeptuniumWandItem(new Item.Properties().durability(1700), 7, 20, 7, 30));
    public static final DeferredItem<Item> NEPTUNIUM_TOME = ITEMS.register("tome_neptunium",
            () -> new NeptuniumTomeItem(new Item.Properties().durability(1700), 40, 30, 7));
    public static final DeferredItem<Item> PUMPKIN_WAND = ITEMS.register("wand_pumpkin",
            () -> new WandItem(new Item.Properties().durability(170), 5, 20, 3, 15));
    public static final DeferredItem<Item> PUMPKIN_TOME = ITEMS.register("tome_pumpkin",
            () -> new TomeItem(new Item.Properties().durability(170), 40, 15, 3));
    public static final DeferredItem<Item> SILVER_WAND = ITEMS.register("wand_silver",
            () -> new WandItem(new Item.Properties().durability(30), 4, 20, 7, 30));
    public static final DeferredItem<Item> SILVER_TOME = ITEMS.register("tome_silver",
            () -> new TomeItem(new Item.Properties().durability(30), 40, 30, 7));
    public static final DeferredItem<Item> SINFUL_WAND = ITEMS.register("wand_sinful",
            () -> new UnbreakableWandItem(new Item.Properties().durability(999), 6, 20, 7, 25));
    public static final DeferredItem<Item> SINFUL_TOME = ITEMS.register("tome_sinful",
            () -> new UnbreakableTomeItem(new Item.Properties().durability(999), 40, 25, 7));
    public static final DeferredItem<Item> SKYROOT_WAND = ITEMS.register("wand_skyroot",
            () -> new LuckWandItem(new Item.Properties().durability(40), 3, 20, 2, 15));
    public static final DeferredItem<Item> SKYROOT_TOME = ITEMS.register("tome_skyroot",
            () -> new LuckTomeItem(new Item.Properties().durability(40), 40, 15, 2));
    public static final DeferredItem<Item> STEELEAF_WAND = ITEMS.register("wand_steeleaf",
            () -> new LuckWandItem(new Item.Properties().durability(90), 6, 20, 3, 15));
    public static final DeferredItem<Item> STEELEAF_TOME = ITEMS.register("tome_steeleaf",
            () -> new LuckTomeItem(new Item.Properties().durability(90), 60, 15, 3));
    public static final DeferredItem<Item> WARDEN_WAND = ITEMS.register("wand_warden",
            () -> new WardenWandItem(new Item.Properties().durability(2300), 8, 20, 7, 25));
    public static final DeferredItem<Item> WARDEN_TOME = ITEMS.register("tome_warden",
            () -> new WardenTomeItem(new Item.Properties().durability(2300), 60, 25, 7));
    public static final DeferredItem<Item> ZANITE_WAND = ITEMS.register("wand_zanite",
            () -> new ZaniteWandItem(new Item.Properties().durability(190), 5, 20, 4, 20));
    public static final DeferredItem<Item> ZANITE_TOME = ITEMS.register("tome_zanite",
            () -> new ZaniteTomeItem(new Item.Properties().durability(45), 60, 20, 4));
    public static final DeferredItem<Item> TERRASTEEL_WAND = ITEMS.register("wand_terrasteel",
            () -> new SlowRepairWandItem(new Item.Properties().durability(2200), 7, 20, 8, 30));
    public static final DeferredItem<Item> TERRASTEEL_TOME = ITEMS.register("tome_terrasteel",
            () -> new SlowRepairTomeItem(new Item.Properties().durability(2200), 60, 30, 8));
    public static final DeferredItem<Item> MANASTEEL_WAND = ITEMS.register("wand_manasteel",
            () -> new SlowRepairWandItem(new Item.Properties().durability(250), 5, 20, 4, 25));
    public static final DeferredItem<Item> MANASTEEL_TOME = ITEMS.register("tome_manasteel",
            () -> new SlowRepairTomeItem(new Item.Properties().durability(250), 40, 25, 4));
    public static final DeferredItem<Item> ELEMENTIUM_WAND = ITEMS.register("wand_elementium",
            () -> new SlowRepairWandItem(new Item.Properties().durability(690), 5, 20, 5, 30));
    public static final DeferredItem<Item> ELEMENTIUM_TOME = ITEMS.register("tome_elementium",
            () -> new SlowRepairTomeItem(new Item.Properties().durability(690), 40, 30, 5));
    public static final DeferredItem<Item> BOTANIST_WAND = ITEMS.register("wand_botanist",
            () -> new SlowRepairWandItem(new Item.Properties().durability(190), 5, 20, 4, 20));
    public static final DeferredItem<Item> BOTANIST_TOME = ITEMS.register("tome_botanist",
            () -> new SlowRepairTomeItem(new Item.Properties().durability(190), 40, 20, 4));

    //Compat Wave 2
    public static final DeferredItem<Item> ILLUNITE_WAND = ITEMS.register("wand_illunite",
            () -> new IlluniteWandItem(new Item.Properties().durability(190), 5, 20, 4, 25));
    public static final DeferredItem<Item> ILLUNITE_TOME = ITEMS.register("tome_illunite",
            () -> new IlluniteTomeItem(new Item.Properties().durability(190), 40, 25, 4));
    public static final DeferredItem<Item> KUKO_WAND = ITEMS.register("wand_kuko",
            () -> new WandItem(new Item.Properties().durability(2300), 7, 20, 7, 20));
    public static final DeferredItem<Item> KUKO_TOME = ITEMS.register("tome_kuko",
            () -> new TomeItem(new Item.Properties().durability(2300), 40, 20, 7));
    public static final DeferredItem<Item> VENOMITE_WAND = ITEMS.register("wand_venomite",
            () -> new PoisonWandItem(new Item.Properties().durability(2900), 9, 20, 7, 20));
    public static final DeferredItem<Item> VENOMITE_TOME = ITEMS.register("tome_venomite",
            () -> new DebuffTomeItem(new Item.Properties().durability(2900), 40, 20, 7));
    public static final DeferredItem<Item> IRIDITE_WAND = ITEMS.register("wand_iridite",
            () -> new WandItem(new Item.Properties().durability(2200), 7, 10, 7, 30));
    public static final DeferredItem<Item> IRIDITE_TOME = ITEMS.register("tome_iridite",
            () -> new TomeItem(new Item.Properties().durability(2200), 20, 30, 7));
    public static final DeferredItem<Item> ENDIUM_WAND = ITEMS.register("wand_endium",
            () -> new WandItem(new Item.Properties().durability(3000), 11, 20, 8, 30));
    public static final DeferredItem<Item> ENDIUM_TOME = ITEMS.register("tome_endium",
            () -> new TomeItem(new Item.Properties().durability(3000), 40, 30, 8));
    public static final DeferredItem<Item> SHARPLEAF_WAND = ITEMS.register("wand_sharpleaf",
            () -> new WandItem(new Item.Properties().durability(10), 7, 20, 8, 30));
    public static final DeferredItem<Item> SHARPLEAF_TOME = ITEMS.register("tome_sharpleaf",
            () -> new TomeItem(new Item.Properties().durability(10), 40, 30, 8));
    public static final DeferredItem<Item> BRIMSTEEL_WAND = ITEMS.register("wand_brimsteel",
            () -> new FireWandItem(new Item.Properties().durability(1550), 6, 20, 6, 25));
    public static final DeferredItem<Item> BRIMSTEEL_TOME = ITEMS.register("tome_brimsteel",
            () -> new FireTomeItem(new Item.Properties().durability(1550), 40, 25, 6));
    public static final DeferredItem<Item> ALFSTEEL_WAND = ITEMS.register("wand_alfsteel",
            () -> new SlowRepairWandItem(new Item.Properties().durability(4400), 12, 20, 10, 30));
    public static final DeferredItem<Item> ALFSTEEL_TOME = ITEMS.register("tome_alfsteel",
            () -> new SlowRepairTomeItem(new Item.Properties().durability(4400), 40, 30, 10));
    public static final DeferredItem<Item> DRAGONBONE_WAND = ITEMS.register("wand_dragonbone",
            () -> new WandItem(new Item.Properties().durability(1500), 7, 20, 5, 25));
    public static final DeferredItem<Item> DRAGONBONE_TOME = ITEMS.register("tome_dragonbone",
            () -> new TomeItem(new Item.Properties().durability(1500), 40, 25, 5));
    public static final DeferredItem<Item> DRAGONBONE_FIRE_WAND = ITEMS.register("wand_dragonbone_fire",
            () -> new FireWandItem(new Item.Properties().durability(1900), 8, 20, 5, 25));
    public static final DeferredItem<Item> DRAGONBONE_FIRE_TOME = ITEMS.register("tome_dragonbone_fire",
            () -> new FireTomeItem(new Item.Properties().durability(1900), 40, 25, 5));
    public static final DeferredItem<Item> DRAGONBONE_ICE_WAND = ITEMS.register("wand_dragonbone_ice",
            () -> new FreezeWandItem(new Item.Properties().durability(1900), 8, 20, 5, 25));
    public static final DeferredItem<Item> DRAGONBONE_ICE_TOME = ITEMS.register("tome_dragonbone_ice",
            () -> new FreezeTomeItem(new Item.Properties().durability(1900), 40, 25, 5));
    public static final DeferredItem<Item> DRAGONBONE_LIGHTNING_WAND = ITEMS.register("wand_dragonbone_lightning",
            () -> new LightningWandItem(new Item.Properties().durability(1900), 8, 20, 5, 25));
    public static final DeferredItem<Item> DRAGONBONE_LIGHTNING_TOME = ITEMS.register("tome_dragonbone_lightning",
            () -> new LightningTomeItem(new Item.Properties().durability(1900), 40, 25, 5));
    public static final DeferredItem<Item> DRAGONSTEEL_FIRE_WAND = ITEMS.register("wand_dragonsteel_fire",
            () -> new FireWandItem(new Item.Properties().durability(7500), 24, 20, 4, 20));
    public static final DeferredItem<Item> DRAGONSTEEL_FIRE_TOME = ITEMS.register("tome_dragonsteel_fire",
            () -> new FireTomeItem(new Item.Properties().durability(7500), 40, 20, 4));
    public static final DeferredItem<Item> DRAGONSTEEL_ICE_WAND = ITEMS.register("wand_dragonsteel_ice",
            () -> new FreezeWandItem(new Item.Properties().durability(7500), 24, 20, 4, 20));
    public static final DeferredItem<Item> DRAGONSTEEL_ICE_TOME = ITEMS.register("tome_dragonsteel_ice",
            () -> new FreezeTomeItem(new Item.Properties().durability(7500), 40, 20, 4));
    public static final DeferredItem<Item> DRAGONSTEEL_LIGHTNING_WAND = ITEMS.register("wand_dragonsteel_lightning",
            () -> new LightningWandItem(new Item.Properties().durability(7500), 24, 20, 4, 20));
    public static final DeferredItem<Item> DRAGONSTEEL_LIGHTNING_TOME = ITEMS.register("tome_dragonsteel_lightning",
            () -> new LightningTomeItem(new Item.Properties().durability(7500), 40, 20, 4));
    public static final DeferredItem<Item> DESERT_MYRMEX_CHITIN_WAND = ITEMS.register("wand_desert_myrmex_chitin",
            () -> new PoisonWandItem(new Item.Properties().durability(550), 4, 20, 4, 20));
    public static final DeferredItem<Item> DESERT_MYRMEX_CHITIN_TOME = ITEMS.register("tome_desert_myrmex_chitin",
            () -> new DebuffTomeItem(new Item.Properties().durability(550), 40, 20, 4));
    public static final DeferredItem<Item> JUNGLE_MYRMEX_CHITIN_WAND = ITEMS.register("wand_jungle_myrmex_chitin",
            () -> new PoisonWandItem(new Item.Properties().durability(550), 4, 20, 4, 20));
    public static final DeferredItem<Item> JUNGLE_MYRMEX_CHITIN_TOME = ITEMS.register("tome_jungle_myrmex_chitin",
            () -> new DebuffTomeItem(new Item.Properties().durability(550), 40, 20, 4));
    public static final DeferredItem<Item> RATLANTIS_WAND = ITEMS.register("wand_of_ratlantis",
            () -> new FastWandItem(new Item.Properties().durability(3300), 10, 20, 7, 30));
    public static final DeferredItem<Item> RATLANTIS_TOME = ITEMS.register("tome_of_ratlantis",
            () -> new FastTomeItem(new Item.Properties().durability(3300), 40, 30, 7));
    public static final DeferredItem<Item> INFERIUM_WAND = ITEMS.register("wand_inferium",
            () -> new WandItem(new Item.Properties().durability(1800), 7, 20, 6, 20));
    public static final DeferredItem<Item> INFERIUM_TOME = ITEMS.register("tome_inferium",
            () -> new TomeItem(new Item.Properties().durability(1800), 40, 20, 6));
    public static final DeferredItem<Item> PRUDENTIUM_WAND = ITEMS.register("wand_prudentium",
            () -> new WandItem(new Item.Properties().durability(2600), 9, 20, 7, 20));
    public static final DeferredItem<Item> PRUDENTIUM_TOME = ITEMS.register("tome_prudentium",
            () -> new TomeItem(new Item.Properties().durability(2600), 40, 20, 7));
    public static final DeferredItem<Item> TERTIUM_WAND = ITEMS.register("wand_tertium",
            () -> new WandItem(new Item.Properties().durability(3600), 12, 20, 8, 25));
    public static final DeferredItem<Item> TERTIUM_TOME = ITEMS.register("tome_tertium",
            () -> new TomeItem(new Item.Properties().durability(3600), 40, 25, 8));
    public static final DeferredItem<Item> IMPERIUM_WAND = ITEMS.register("wand_imperium",
            () -> new WandItem(new Item.Properties().durability(5500), 16, 20, 9, 25));
    public static final DeferredItem<Item> IMPERIUM_TOME = ITEMS.register("tome_imperium",
            () -> new TomeItem(new Item.Properties().durability(5500), 40, 25, 9));
    public static final DeferredItem<Item> SUPREMIUM_WAND = ITEMS.register("wand_supremium",
            () -> new UnbreakableWandItem(new Item.Properties().durability(10000), 23, 20, 10, 30));
    public static final DeferredItem<Item> SUPREMIUM_TOME = ITEMS.register("tome_supremium",
            () -> new UnbreakableTomeItem(new Item.Properties().durability(10000), 40, 30, 10));
    public static final DeferredItem<Item> ALLTHEMODIUM_WAND = ITEMS.register("wand_allthemodium",
            () -> new UnbreakableWandItem(new Item.Properties().durability(10000), 15, 10, 6, 20));
    public static final DeferredItem<Item> ALLTHEMODIUM_TOME = ITEMS.register("tome_allthemodium",
            () -> new UnbreakableTomeItem(new Item.Properties().durability(10000), 30, 20, 6));
    public static final DeferredItem<Item> VIBRANIUM_WAND = ITEMS.register("wand_vibranium",
            () -> new UnbreakableWandItem(new Item.Properties().durability(10000), 21, 10, 8, 25));
    public static final DeferredItem<Item> VIBRANIUM_TOME = ITEMS.register("tome_vibranium",
            () -> new UnbreakableTomeItem(new Item.Properties().durability(10000), 20, 25, 8));
    public static final DeferredItem<Item> UNOBTAINIUM_WAND = ITEMS.register("wand_unobtainium",
            () -> new UnbreakableWandItem(new Item.Properties().durability(10000), 27, 5, 10, 30));
    public static final DeferredItem<Item> UNOBTAINIUM_TOME = ITEMS.register("tome_unobtainium",
            () -> new UnbreakableTomeItem(new Item.Properties().durability(10000), 10, 30, 10));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
