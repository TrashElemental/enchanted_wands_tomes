package net.trashelemental.enchanted_wands_tomes.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.trashelemental.enchanted_wands_tomes.EnchantedWandsTomes;
import net.trashelemental.enchanted_wands_tomes.item.custom.TomeItem;
import net.trashelemental.enchanted_wands_tomes.item.custom.UniqueTomes.*;
import net.trashelemental.enchanted_wands_tomes.item.custom.UniqueWands.*;
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
            () -> new DracoArcanusWandItem(new Item.Properties().durability(2300), 10, 20, 8, 30));
    public static final DeferredItem<Item> DRACO_ARCANUS_TOME = ITEMS.register("tome_draco_arcanus",
            () -> new DracoArcanusTomeItem(new Item.Properties().durability(2300), 60, 30, 8));
    public static final DeferredItem<Item> ELECTRUM_WAND = ITEMS.register("wand_electrum",
            () -> new ElectrumWandItem(new Item.Properties().durability(1460), 6, 10, 6, 25));
    public static final DeferredItem<Item> ELECTRUM_TOME = ITEMS.register("tome_electrum",
            () -> new ElectrumTomeItem(new Item.Properties().durability(1460), 20, 25, 6));
    public static final DeferredItem<Item> ETHER_WAND = ITEMS.register("wand_ether",
            () -> new EtherWandItem(new Item.Properties().durability(1560), 4, 20, 4, 15));
    public static final DeferredItem<Item> ETHER_TOME = ITEMS.register("tome_ether",
            () -> new EtherTomeItem(new Item.Properties().durability(1560), 40, 15, 4));
    public static final DeferredItem<Item> FIERY_WAND = ITEMS.register("wand_fiery",
            () -> new FieryWandItem(new Item.Properties().durability(960), 7, 20, 7, 20));
    public static final DeferredItem<Item> FIERY_TOME = ITEMS.register("tome_fiery",
            () -> new FieryTomeItem(new Item.Properties().durability(960), 40, 20, 7));
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
            () -> new HoneyCrystalWandItem(new Item.Properties().durability(45), 10, 20, 6, 30));
    public static final DeferredItem<Item> HONEY_CRYSTAL_TOME = ITEMS.register("tome_honey_crystal",
            () -> new HoneyCrystalTomeItem(new Item.Properties().durability(45), 40, 30, 6));
    public static final DeferredItem<Item> IRONWOOD_WAND = ITEMS.register("wand_ironwood",
            () -> new KnockbackWandItem(new Item.Properties().durability(450), 5, 20, 4, 15));
    public static final DeferredItem<Item> IRONWOOD_TOME = ITEMS.register("tome_ironwood",
            () -> new KnockbackTomeItem(new Item.Properties().durability(450), 60, 15, 4));
    public static final DeferredItem<Item> KNIGHTMETAL_WAND = ITEMS.register("wand_knightmetal",
            () -> new KnockbackWandItem(new Item.Properties().durability(450), 6, 20, 5, 15));
    public static final DeferredItem<Item> KNIGHTMETAL_TOME = ITEMS.register("tome_knightmetal",
            () -> new KnockbackTomeItem(new Item.Properties().durability(450), 60, 15, 5));
    public static final DeferredItem<Item> NECROMIUM_WAND = ITEMS.register("wand_necromium",
            () -> new NecromiumWandItem(new Item.Properties().durability(1960), 6, 20, 6, 30));
    public static final DeferredItem<Item> NECROMIUM_TOME = ITEMS.register("tome_necromium",
            () -> new NecromiumTomeItem(new Item.Properties().durability(1960), 40, 30, 6));
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



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
