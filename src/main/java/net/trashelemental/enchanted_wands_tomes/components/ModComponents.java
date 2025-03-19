package net.trashelemental.enchanted_wands_tomes.components;

import net.minecraft.core.component.DataComponentType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.trashelemental.enchanted_wands_tomes.EnchantedWandsTomes;

import java.util.function.UnaryOperator;

public class ModComponents {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES = DeferredRegister.createDataComponents(EnchantedWandsTomes.MOD_ID);




    private static <T>DeferredHolder<DataComponentType<?>, DataComponentType<T>> register
            (String name, UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return DATA_COMPONENT_TYPES.register(name, () -> builderOperator.apply(DataComponentType.builder()).build());
    }

    public static void register(IEventBus eventBus) {
        DATA_COMPONENT_TYPES.register(eventBus);
    }


    //Example:
//    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> POINTS = register(
//            "tool_points", builder -> builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT));
}
