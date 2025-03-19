package net.trashelemental.enchanted_wands_tomes.entity.client.models;

import net.minecraft.resources.ResourceLocation;
import net.trashelemental.enchanted_wands_tomes.EnchantedWandsTomes;
import net.trashelemental.enchanted_wands_tomes.entity.custom.WandProjectileEntity;
import software.bernie.geckolib.model.GeoModel;

public class WandProjectileModel extends GeoModel<WandProjectileEntity> {
    @Override
    public ResourceLocation getModelResource(WandProjectileEntity animatable) {
        return EnchantedWandsTomes.prefix("geo/models/wand_projectile.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WandProjectileEntity animatable) {

        return EnchantedWandsTomes.prefix("textures/entity/wand_projectile.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WandProjectileEntity animatable) {
        return EnchantedWandsTomes.prefix("animations/wand_projectile.animation.json");
    }

}
