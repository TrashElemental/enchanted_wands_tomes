package net.trashelemental.enchanted_wands_tomes.magic.brewing;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.trashelemental.enchanted_wands_tomes.EnchantedWandsTomes;

public class ModPotions {
    public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, EnchantedWandsTomes.MOD_ID);





    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }
}
