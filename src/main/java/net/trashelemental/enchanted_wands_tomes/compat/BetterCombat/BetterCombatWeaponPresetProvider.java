package net.trashelemental.enchanted_wands_tomes.compat.BetterCombat;

import com.google.gson.JsonObject;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.trashelemental.enchanted_wands_tomes.EnchantedWandsTomes;
import net.trashelemental.enchanted_wands_tomes.item.ModItems;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BetterCombatWeaponPresetProvider implements DataProvider {
    private final PackOutput output;
    private final List<CompletableFuture<?>> futures = new ArrayList<>();
    private CachedOutput cache;
    private Path outputFolder;

    public BetterCombatWeaponPresetProvider(PackOutput packOutput) {
        this.output = packOutput;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        this.cache = cache;
        this.outputFolder = output.getOutputFolder();

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

        return CompletableFuture.allOf(futures.toArray(new CompletableFuture<?>[0]));
    }

    private void registerWeapon(DeferredItem<Item> item, String preset) {
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
