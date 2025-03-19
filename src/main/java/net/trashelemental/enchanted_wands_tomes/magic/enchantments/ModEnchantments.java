package net.trashelemental.enchanted_wands_tomes.magic.enchantments;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.trashelemental.enchanted_wands_tomes.EnchantedWandsTomes;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(Registries.ENCHANTMENT, EnchantedWandsTomes.MOD_ID);




    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }
}
