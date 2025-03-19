package net.trashelemental.enchanted_wands_tomes.entity;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.trashelemental.enchanted_wands_tomes.EnchantedWandsTomes;

@EventBusSubscriber(modid = EnchantedWandsTomes.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEntityClientEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {

    }


    //Layers



    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {



    }


}
