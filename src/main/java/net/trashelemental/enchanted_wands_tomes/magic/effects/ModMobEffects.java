package net.trashelemental.enchanted_wands_tomes.magic.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.trashelemental.enchanted_wands_tomes.EnchantedWandsTomes;

public class ModMobEffects {

    public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, EnchantedWandsTomes.MOD_ID);




    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }
}
