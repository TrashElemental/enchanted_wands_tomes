package net.trashelemental.enchanted_wands_tomes.compat.BetterCombat;

import com.google.gson.JsonObject;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import net.trashelemental.enchanted_wands_tomes.EnchantedWandsTomes;
import net.trashelemental.enchanted_wands_tomes.item.ModItems;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BetterCombatWeaponPresetProvider implements DataProvider {
    private final PackOutput packOutput;
    private final List<CompletableFuture<?>> futures = new ArrayList<>();
    private CachedOutput cache;
    private Path outputFolder;

    public BetterCombatWeaponPresetProvider(PackOutput packOutput) {
        this.packOutput = packOutput;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        this.cache = cache;
        this.outputFolder = packOutput.getOutputFolder();

        registerWeapon(ModItems.WOOD_WAND, "wand");
        registerWeapon(ModItems.STONE_WAND, "wand");
        registerWeapon(ModItems.IRON_WAND, "wand");
        registerWeapon(ModItems.GOLD_WAND, "wand");
        registerWeapon(ModItems.DIAMOND_WAND, "wand");
        registerWeapon(ModItems.NETHERITE_WAND, "wand");

        registerWeapon(ModItems.ADAMANTITE_WAND, "wand");
        registerWeapon(ModItems.BOTANIST_WAND, "wand");
        registerWeapon(ModItems.CORINTHIUM_WAND, "wand");
        registerWeapon(ModItems.DARK_METAL_WAND, "wand");
        registerWeapon(ModItems.DEPTH_WAND, "wand");
        registerWeapon(ModItems.DRACO_ARCANUS_WAND, "wand");
        registerWeapon(ModItems.ELECTRUM_WAND, "wand");
        registerWeapon(ModItems.ELEMENTIUM_WAND, "wand");
        registerWeapon(ModItems.ETHER_WAND, "wand");
        registerWeapon(ModItems.FIERY_WAND, "wand");
        registerWeapon(ModItems.FLESH_WAND, "wand");
        registerWeapon(ModItems.GRAVITITE_WAND, "wand");
        registerWeapon(ModItems.HOLYSTONE_WAND, "wand");
        registerWeapon(ModItems.HONEY_CRYSTAL_WAND, "wand");
        registerWeapon(ModItems.KNIGHTMETAL_WAND, "wand");
        registerWeapon(ModItems.IRONWOOD_WAND, "wand");
        registerWeapon(ModItems.MANASTEEL_WAND, "wand");
        registerWeapon(ModItems.NECROMIUM_WAND, "wand");
        registerWeapon(ModItems.NEPTUNIUM_WAND, "wand");
        registerWeapon(ModItems.PUMPKIN_WAND, "wand");
        registerWeapon(ModItems.SINFUL_WAND, "wand");
        registerWeapon(ModItems.SILVER_WAND, "wand");
        registerWeapon(ModItems.SKYROOT_WAND, "wand");
        registerWeapon(ModItems.STEELEAF_WAND, "wand");
        registerWeapon(ModItems.TERRASTEEL_WAND, "wand");
        registerWeapon(ModItems.WARDEN_WAND, "wand");
        registerWeapon(ModItems.ZANITE_WAND, "wand");

        registerWeapon(ModItems.ILLUNITE_WAND, "wand");
        registerWeapon(ModItems.BRIMSTEEL_WAND, "wand");
        registerWeapon(ModItems.SHARPLEAF_WAND, "wand");
        registerWeapon(ModItems.ALFSTEEL_WAND, "wand");
        registerWeapon(ModItems.RATLANTIS_WAND, "wand");
        registerWeapon(ModItems.DRAGONBONE_WAND, "wand");
        registerWeapon(ModItems.DRAGONBONE_FIRE_WAND, "wand");
        registerWeapon(ModItems.DRAGONBONE_ICE_WAND, "wand");
        registerWeapon(ModItems.DRAGONBONE_LIGHTNING_WAND, "wand");
        registerWeapon(ModItems.DRAGONSTEEL_FIRE_WAND, "wand");
        registerWeapon(ModItems.DRAGONSTEEL_ICE_WAND, "wand");
        registerWeapon(ModItems.DRAGONSTEEL_LIGHTNING_WAND, "wand");
        registerWeapon(ModItems.DESERT_MYRMEX_CHITIN_WAND, "wand");
        registerWeapon(ModItems.JUNGLE_MYRMEX_CHITIN_WAND, "wand");
        registerWeapon(ModItems.KUKO_WAND, "wand");
        registerWeapon(ModItems.VENOMITE_WAND, "wand");
        registerWeapon(ModItems.IRIDITE_WAND, "wand");
        registerWeapon(ModItems.ENDIUM_WAND, "wand");
        registerWeapon(ModItems.ALLTHEMODIUM_WAND, "wand");
        registerWeapon(ModItems.VIBRANIUM_WAND, "wand");
        registerWeapon(ModItems.UNOBTAINIUM_WAND, "wand");
        registerWeapon(ModItems.INFERIUM_WAND, "wand");
        registerWeapon(ModItems.PRUDENTIUM_WAND, "wand");
        registerWeapon(ModItems.TERTIUM_WAND, "wand");
        registerWeapon(ModItems.IMPERIUM_WAND, "wand");
        registerWeapon(ModItems.SUPREMIUM_WAND, "wand");

        return CompletableFuture.allOf(futures.toArray(new CompletableFuture<?>[0]));
    }

    private void registerWeapon(RegistryObject<Item> item, String preset) {
        JsonObject json = new JsonObject();
        json.addProperty("parent", "bettercombat:" + preset);

        Path path = outputFolder.resolve("data/" + EnchantedWandsTomes.MOD_ID + "/weapon_attributes/" + item.getId().getPath() + ".json");

        futures.add(DataProvider.saveStable(cache, json, path));
    }

    @Override
    public String getName() {
        return "Better Combat Weapon Attributes";
    }
}
