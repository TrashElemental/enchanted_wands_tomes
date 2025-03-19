package net.trashelemental.enchanted_wands_tomes.magic.brewing;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.trashelemental.enchanted_wands_tomes.EnchantedWandsTomes;

@EventBusSubscriber
public class ModAlchemy {
    public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, EnchantedWandsTomes.MOD_ID);







    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }


    @SubscribeEvent
    public static void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {


        //Potions



        //Non-Potions






    }
}
