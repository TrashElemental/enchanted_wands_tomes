package net.trashelemental.enchanted_wands_tomes.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.trashelemental.enchanted_wands_tomes.EnchantedWandsTomes;
import net.trashelemental.enchanted_wands_tomes.entity.custom.WandProjectileEntity;


public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, EnchantedWandsTomes.MOD_ID);


    public static final DeferredHolder<EntityType<?>, EntityType<WandProjectileEntity>> WAND_PROJECTILE_ENTITY =
            ENTITY_TYPES.register("wand_projectile",
                    () -> EntityType.Builder.<WandProjectileEntity>of(WandProjectileEntity::new, MobCategory.MISC)
                            .sized(0.3f, 0.3f).build("wand_projectile"));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
