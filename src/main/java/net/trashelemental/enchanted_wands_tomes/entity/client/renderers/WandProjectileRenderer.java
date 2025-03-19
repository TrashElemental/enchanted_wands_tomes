package net.trashelemental.enchanted_wands_tomes.entity.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.trashelemental.enchanted_wands_tomes.entity.client.models.WandProjectileModel;
import net.trashelemental.enchanted_wands_tomes.entity.custom.WandProjectileEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WandProjectileRenderer extends GeoEntityRenderer<WandProjectileEntity> {
    public WandProjectileRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new WandProjectileModel());
    }

    @Override
    public ResourceLocation getTextureLocation(WandProjectileEntity animatable) {
        return new ResourceLocation("enchanted_wands_tomes","textures/entity/wand_projectile.png");
    }

    @Override
    public void render(WandProjectileEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();

        float scale = 0.7f;
        poseStack.scale(scale, scale, scale);

        Vec3 velocity = entity.getDeltaMovement();
        if (velocity.lengthSqr() > 0.001) {
            double motionX = velocity.x;
            double motionY = velocity.y;
            double motionZ = velocity.z;

            float yaw = (float) (Math.toDegrees(Math.atan2(motionZ, motionX))) - 90.0F;
            float pitch = (float) (Math.toDegrees(Math.atan2(motionY, Math.sqrt(motionX * motionX + motionZ * motionZ))));

            poseStack.mulPose(Axis.YP.rotationDegrees(-yaw));
            poseStack.mulPose(Axis.XP.rotationDegrees(pitch));
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);

        poseStack.popPose();
    }
}
