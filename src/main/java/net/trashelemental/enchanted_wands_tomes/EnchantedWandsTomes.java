package net.trashelemental.enchanted_wands_tomes;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.trashelemental.enchanted_wands_tomes.armor.ModArmorMaterials;
import net.trashelemental.enchanted_wands_tomes.block.ModBlocks;
import net.trashelemental.enchanted_wands_tomes.components.ModComponents;
import net.trashelemental.enchanted_wands_tomes.entity.ModEntities;
import net.trashelemental.enchanted_wands_tomes.entity.client.renderers.WandProjectileRenderer;
import net.trashelemental.enchanted_wands_tomes.item.ModCreativeModeTabs;
import net.trashelemental.enchanted_wands_tomes.item.ModItems;
import net.trashelemental.enchanted_wands_tomes.magic.brewing.ModAlchemy;
import net.trashelemental.enchanted_wands_tomes.magic.effects.ModMobEffects;
import net.trashelemental.enchanted_wands_tomes.magic.enchantments.ModEnchantmentEffects;
import org.slf4j.Logger;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@Mod(EnchantedWandsTomes.MOD_ID)
public class EnchantedWandsTomes
{

    public static final String MOD_ID = "enchanted_wands_tomes";
    private static final Logger LOGGER = LogUtils.getLogger();

    public EnchantedWandsTomes(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModAlchemy.register(modEventBus);
        ModMobEffects.register(modEventBus);
        ModEntities.register(modEventBus);
        ModArmorMaterials.register(modEventBus);
        ModComponents.register(modEventBus);
        ModEnchantmentEffects.register(modEventBus);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {



    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {



    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {



    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            EntityRenderers.register(ModEntities.WAND_PROJECTILE_ENTITY.get(), WandProjectileRenderer::new);

        }
    }



    private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

    public static void queueServerWork(int tickDelay, Runnable action) {
        workQueue.add(new AbstractMap.SimpleEntry<>(action, tickDelay));
    }

    @SubscribeEvent
    public void onServerTick(ServerTickEvent.Post event) {
        List<AbstractMap.SimpleEntry<Runnable, Integer>> actionsToRun = new ArrayList<>();
        workQueue.forEach(work -> {
            work.setValue(work.getValue() - 1);
            if (work.getValue() <= 0) {
                actionsToRun.add(work);
            }
        });
        actionsToRun.forEach(work -> work.getKey().run());
        workQueue.removeAll(actionsToRun);
    }

    public static ResourceLocation prefix(String string) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, string);
    }

}
