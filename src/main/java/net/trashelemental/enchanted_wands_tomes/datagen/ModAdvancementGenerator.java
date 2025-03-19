package net.trashelemental.enchanted_wands_tomes.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.trashelemental.enchanted_wands_tomes.EnchantedWandsTomes;
import net.trashelemental.enchanted_wands_tomes.item.ModItems;

import java.util.function.Consumer;

public class ModAdvancementGenerator implements ForgeAdvancementProvider.AdvancementGenerator {

    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> writer, ExistingFileHelper existingFileHelper) {

        Advancement WandGet = Advancement.Builder.advancement()
                .display(
                        ModItems.WOOD_WAND.get(), // Icon
                        Component.translatable("advancements.wand_get.title"), // Title
                        Component.translatable("advancements.wand_get.description"), // Description
                        new ResourceLocation("textures/gui/advancements/backgrounds/stone.png"), // Background
                        FrameType.GOAL, // Frame Type
                        true, // Show Toast
                        true, // Announce to Chat
                        false // Hidden
                )
                .parent(new ResourceLocation("minecraft:adventure/kill_a_mob"))
                .addCriterion("has_wood_wand", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.WOOD_WAND.get()))
                .save(writer, new ResourceLocation(EnchantedWandsTomes.MOD_ID, "wand_get"), existingFileHelper);

        Advancement TomeGet = Advancement.Builder.advancement()
                .display(
                        ModItems.LEATHER_TOME.get(), // Icon
                        Component.translatable("advancements.tome_get.title"), // Title
                        Component.translatable("advancements.tome_get.description"), // Description
                        new ResourceLocation("textures/gui/advancements/backgrounds/stone.png"), // Background
                        FrameType.GOAL, // Frame Type
                        true, // Show Toast
                        true, // Announce to Chat
                        false // Hidden
                )
                .parent(new ResourceLocation("minecraft:adventure/kill_a_mob"))
                .addCriterion("has_leather_tome", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LEATHER_TOME.get()))
                .save(writer, new ResourceLocation(EnchantedWandsTomes.MOD_ID, "tome_get"), existingFileHelper);

        Advancement IronTomeGet = Advancement.Builder.advancement()
                .display(
                        ModItems.IRON_TOME.get(), // Icon
                        Component.translatable("advancements.iron_tome_get.title"), // Title
                        Component.translatable("advancements.iron_tome_get.description"), // Description
                        new ResourceLocation("textures/gui/advancements/backgrounds/stone.png"), // Background
                        FrameType.GOAL, // Frame Type
                        true, // Show Toast
                        true, // Announce to Chat
                        true // Hidden
                )
                .parent(TomeGet)
                .addCriterion("has_iron_tome", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_TOME.get()))
                .save(writer, new ResourceLocation(EnchantedWandsTomes.MOD_ID, "iron_tome_get"), existingFileHelper);

        Advancement NetheriteWandGet = Advancement.Builder.advancement()
                .display(
                        ModItems.NETHERITE_WAND.get(), // Icon
                        Component.translatable("advancements.netherite_wand_get.title"), // Title
                        Component.translatable("advancements.netherite_wand_get.description"), // Description
                        new ResourceLocation("textures/gui/advancements/backgrounds/stone.png"), // Background
                        FrameType.GOAL, // Frame Type
                        true, // Show Toast
                        true, // Announce to Chat
                        true // Hidden
                )
                .parent(WandGet)
                .addCriterion("has_netherite_wand", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_WAND.get()))
                .save(writer, new ResourceLocation(EnchantedWandsTomes.MOD_ID, "netherite_wand_get"), existingFileHelper);

        Advancement NetheriteTomeGet = Advancement.Builder.advancement()
                .display(
                        ModItems.NETHERITE_TOME.get(), // Icon
                        Component.translatable("advancements.netherite_tome_get.title"), // Title
                        Component.translatable("advancements.netherite_tome_get.description"), // Description
                        new ResourceLocation("textures/gui/advancements/backgrounds/stone.png"), // Background
                        FrameType.GOAL, // Frame Type
                        true, // Show Toast
                        true, // Announce to Chat
                        true // Hidden
                )
                .parent(TomeGet)
                .addCriterion("has_netherite_tome", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_TOME.get()))
                .save(writer, new ResourceLocation(EnchantedWandsTomes.MOD_ID, "netherite_tome_get"), existingFileHelper);

    }
}
