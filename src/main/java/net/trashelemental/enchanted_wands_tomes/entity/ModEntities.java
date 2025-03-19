package net.trashelemental.enchanted_wands_tomes.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.trashelemental.enchanted_wands_tomes.EnchantedWandsTomes;
import net.trashelemental.enchanted_wands_tomes.entity.custom.WandProjectileEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, EnchantedWandsTomes.MOD_ID);


    //Projectiles
    public static final RegistryObject<EntityType<WandProjectileEntity>> WAND_PROJECTILE_ENTITY =
            ENTITY_TYPES.register("wand_projectile",
                    () -> EntityType.Builder.<WandProjectileEntity>of(WandProjectileEntity::new, MobCategory.MISC)
                            .sized(0.3f, 0.3f).build("wand_projectile"));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
