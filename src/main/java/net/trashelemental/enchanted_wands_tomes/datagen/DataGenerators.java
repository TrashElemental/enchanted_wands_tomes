package net.trashelemental.enchanted_wands_tomes.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.trashelemental.enchanted_wands_tomes.compat.BetterCombat.BetterCombatWeaponPresetProvider;
import net.trashelemental.enchanted_wands_tomes.datagen.loot.ModLootTableProvider;
import net.trashelemental.enchanted_wands_tomes.datagen.tags.ModBlockTagGenerator;
import net.trashelemental.enchanted_wands_tomes.datagen.tags.ModEntityTagGenerator;
import net.trashelemental.enchanted_wands_tomes.datagen.tags.ModItemTagGenerator;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = "enchanted_wands_tomes")
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {

        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();


        generator.addProvider(event.includeServer(), new ModRecipeProvider(output, lookupProvider));
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(output, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(output, existingFileHelper));
        ModBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new ModBlockTagGenerator(output, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModItemTagGenerator(output, lookupProvider, blockTagGenerator.contentsGetter()));
        generator.addProvider(event.includeServer(), new ModEntityTagGenerator(output, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModAdvancementProvider(output, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeServer(), (DataProvider.Factory<ModLootTableProvider>) providerOutput ->
                new ModLootTableProvider(providerOutput, lookupProvider)
        );

        //Better Combat
        generator.addProvider(event.includeServer(), new BetterCombatWeaponPresetProvider(output));

    }
}
