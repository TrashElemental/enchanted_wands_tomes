package net.trashelemental.enchanted_wands_tomes.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.trashelemental.enchanted_wands_tomes.EnchantedWandsTomes;
import net.trashelemental.enchanted_wands_tomes.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends AdvancementProvider {
    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, existingFileHelper, List.of(new ModAdvancementGenerator()));
    }

    private static final class ModAdvancementGenerator implements AdvancementProvider.AdvancementGenerator {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> saver, ExistingFileHelper existingFileHelper) {

            Advancement.Builder WandGet = Advancement.Builder.advancement();
            WandGet.parent(AdvancementSubProvider.createPlaceholder("minecraft:adventure/kill_a_mob"));
            WandGet.display(
                    new ItemStack(ModItems.WOOD_WAND.get()), //Icon
                    Component.translatable("advancements.wand_get.title"),        //Title
                    Component.translatable("advancements.wand_get.description"),  //Description
                    null, //Should be null unless this is a root advancement
                    AdvancementType.GOAL,
                    true,
                    true,
                    false
            );
            WandGet.addCriterion("has_wood_wand", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.WOOD_WAND.get()));
            WandGet.requirements(AdvancementRequirements.allOf(List.of("has_wood_wand")));
            WandGet.save(saver, EnchantedWandsTomes.prefix( "wand_get"), existingFileHelper);

            Advancement.Builder TomeGet = Advancement.Builder.advancement();
            TomeGet.parent(AdvancementSubProvider.createPlaceholder("minecraft:adventure/kill_a_mob"));
            TomeGet.display(
                    new ItemStack(ModItems.LEATHER_TOME.get()), //Icon
                    Component.translatable("advancements.tome_get.title"),        //Title
                    Component.translatable("advancements.tome_get.description"),  //Description
                    null, //Should be null unless this is a root advancement
                    AdvancementType.GOAL,
                    true,
                    true,
                    false
            );
            TomeGet.addCriterion("has_leather_tome", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LEATHER_TOME.get()));
            TomeGet.requirements(AdvancementRequirements.allOf(List.of("has_leather_tome")));
            TomeGet.save(saver, EnchantedWandsTomes.prefix( "tome_get"), existingFileHelper);

            Advancement.Builder IronTomeGet = Advancement.Builder.advancement();
            IronTomeGet.parent(AdvancementSubProvider.createPlaceholder(EnchantedWandsTomes.prefix("tome_get").toString()));
            IronTomeGet.display(
                    new ItemStack(ModItems.IRON_TOME.get()), //Icon
                    Component.translatable("advancements.iron_tome_get.title"),        //Title
                    Component.translatable("advancements.iron_tome_get.description"),  //Description
                    null, //Should be null unless this is a root advancement
                    AdvancementType.GOAL,
                    true,
                    true,
                    true
            );
            IronTomeGet.addCriterion("has_iron_tome", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_TOME.get()));
            IronTomeGet.requirements(AdvancementRequirements.allOf(List.of("has_iron_tome")));
            IronTomeGet.save(saver, EnchantedWandsTomes.prefix( "iron_tome_get"), existingFileHelper);

            Advancement.Builder NetheriteWandGet = Advancement.Builder.advancement();
            NetheriteWandGet.parent(AdvancementSubProvider.createPlaceholder(EnchantedWandsTomes.prefix("wand_get").toString()));
            NetheriteWandGet.display(
                    new ItemStack(ModItems.NETHERITE_WAND.get()), //Icon
                    Component.translatable("advancements.netherite_wand_get.title"),        //Title
                    Component.translatable("advancements.netherite_wand_get.description"),  //Description
                    null, //Should be null unless this is a root advancement
                    AdvancementType.GOAL,
                    true,
                    true,
                    false
            );
            NetheriteWandGet.addCriterion("has_netherite_wand", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_WAND.get()));
            NetheriteWandGet.requirements(AdvancementRequirements.allOf(List.of("has_netherite_wand")));
            NetheriteWandGet.save(saver, EnchantedWandsTomes.prefix( "netherite_wand_get"), existingFileHelper);

            Advancement.Builder NetheriteTomeGet = Advancement.Builder.advancement();
            NetheriteTomeGet.parent(AdvancementSubProvider.createPlaceholder(EnchantedWandsTomes.prefix("tome_get").toString()));
            NetheriteTomeGet.display(
                    new ItemStack(ModItems.NETHERITE_TOME.get()), //Icon
                    Component.translatable("advancements.netherite_tome_get.title"),        //Title
                    Component.translatable("advancements.netherite_tome_get.description"),  //Description
                    null, //Should be null unless this is a root advancement
                    AdvancementType.GOAL,
                    true,
                    true,
                    false
            );
            NetheriteTomeGet.addCriterion("has_netherite_tome", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_TOME.get()));
            NetheriteTomeGet.requirements(AdvancementRequirements.allOf(List.of("has_netherite_tome")));
            NetheriteTomeGet.save(saver, EnchantedWandsTomes.prefix( "netherite_tome_get"), existingFileHelper);

        }
    }
}
