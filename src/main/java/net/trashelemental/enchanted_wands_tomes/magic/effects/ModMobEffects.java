package net.trashelemental.enchanted_wands_tomes.magic.effects;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.trashelemental.enchanted_wands_tomes.EnchantedWandsTomes;

public class ModMobEffects {
    public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, EnchantedWandsTomes.MOD_ID);





    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }
}
