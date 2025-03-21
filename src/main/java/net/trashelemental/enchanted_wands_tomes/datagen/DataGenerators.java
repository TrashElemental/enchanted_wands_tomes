package net.trashelemental.enchanted_wands_tomes.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trashelemental.enchanted_wands_tomes.EnchantedWandsTomes;
import net.trashelemental.enchanted_wands_tomes.compat.BetterCombat.BetterCombatWeaponPresetProvider;
import net.trashelemental.enchanted_wands_tomes.compat.EnchantmentCompatProvider;
import net.trashelemental.enchanted_wands_tomes.datagen.loot.ModLootTableProvider;
import net.trashelemental.enchanted_wands_tomes.datagen.tags.ModBlockTagGenerator;
import net.trashelemental.enchanted_wands_tomes.datagen.tags.ModEntityTagGenerator;
import net.trashelemental.enchanted_wands_tomes.datagen.tags.ModItemTagGenerator;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = EnchantedWandsTomes.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {

        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput));

        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));

        ModBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new ModBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new ModEntityTagGenerator(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeServer(), new ModGlobalLootModifiersProvider(packOutput));

        generator.addProvider(event.includeServer(), new ModAdvancementProvider(packOutput, lookupProvider, existingFileHelper));

        //Better Combat
        generator.addProvider(event.includeServer(), new BetterCombatWeaponPresetProvider(packOutput));

        generator.addProvider(event.includeServer(), new EnchantmentCompatProvider(packOutput, event.getLookupProvider(), "enchanted_wands_tomes", existingFileHelper));

    }
}
