package net.trashelemental.enchanted_wands_tomes.entity.client.models;

import net.minecraft.resources.ResourceLocation;
import net.trashelemental.enchanted_wands_tomes.entity.custom.WandProjectileEntity;
import software.bernie.geckolib.model.GeoModel;

public class WandProjectileModel extends GeoModel<WandProjectileEntity> {
    @Override
    public ResourceLocation getModelResource(WandProjectileEntity animatable) {
        return new ResourceLocation("enchanted_wands_tomes","geo/models/wand_projectile.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WandProjectileEntity animatable) {

        return new ResourceLocation("enchanted_wands_tomes","textures/entity/wand_projectile.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WandProjectileEntity animatable) {
        return new ResourceLocation("enchanted_wands_tomes","animations/wand_projectile.animation.json");
    }

}
