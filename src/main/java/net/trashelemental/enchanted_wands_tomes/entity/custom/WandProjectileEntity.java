package net.trashelemental.enchanted_wands_tomes.entity.custom;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.trashelemental.enchanted_wands_tomes.entity.ModEntities;
import net.trashelemental.enchanted_wands_tomes.util.Wand.WandEffects;
import net.trashelemental.junkyard_lib.visual.particle.ParticleMethods;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import java.util.List;

public class WandProjectileEntity extends AbstractHurtingProjectile implements GeoEntity {
    private float damage;
    private int lifetime;
    private int maxLifetime;

    /**
     * Projectile Modifiers
     **/
    private boolean fireEffect;
    private int burnTicks;
    private boolean channelingEffect;
    private double lightningChance;
    private boolean waterEffect;
    private int waterDamage;
    private int breathReduction;
    private boolean spiderEffect;
    private double poisonChance;
    private int poisonEffectTime;
    private boolean smiteEffect;
    private int smiteEffectTime;
    private boolean freezeEffect;
    private int freezeTicks;
    private boolean thwackEffect;
    private double instantDespawnChance;
    private boolean luckEffect;
    private double dropChance;
    private boolean healEffect;
    private int healAmount;
    private boolean silkTouchEffect;
    private boolean AOEEffect;
    private double AOEArea;
    private boolean collectEffect;
    private double collectArea;
    private boolean armorEffect;
    private float armorHealAmount;
    private boolean launchEffect;
    private int launchEffectTime;
    private boolean knockbackEffect;
    private double knockbackStrength;

    public WandProjectileEntity(EntityType<? extends WandProjectileEntity> entityType, Level level) {
        super(entityType, level);
        this.lifetime = 0;
        this.maxLifetime = 50;
        this.damage = 4.0F;

        this.fireEffect = false;
        this.burnTicks = 80;
        this.channelingEffect = false;
        this.lightningChance = 0;
        this.waterEffect = false;
        this.waterDamage = 0;
        this.breathReduction = 2;
        this.spiderEffect = false;
        this.poisonChance = 0;
        this.poisonEffectTime = 0;
        this.smiteEffect = false;
        this.smiteEffectTime = 0;
        this.freezeEffect = false;
        this.freezeTicks = 0;
        this.thwackEffect = false;
        this.instantDespawnChance = 0;
        this.luckEffect = false;
        this.dropChance = 0;
        this.healEffect = false;
        this.healAmount = 0;
        this.silkTouchEffect = false;
        this.AOEEffect = false;
        this.AOEArea = 0;
        this.collectEffect = false;
        this.collectArea = 0;
        this.armorEffect = false;
        this.armorHealAmount = 0;
        this.launchEffect = false;
        this.launchEffectTime = 0;
        this.knockbackEffect = false;
        this.knockbackStrength = 0;
    }

    public WandProjectileEntity(Level level, LivingEntity owner, Vec3 direction, double speed, float damage) {
        this(ModEntities.WAND_PROJECTILE_ENTITY.get(), level);
        this.setOwner(owner);
        this.setPos(owner.getX(), owner.getEyeY() - 0.5, owner.getZ());
        this.setDeltaMovement(direction.scale(speed));

        this.damage = damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public void setLifetime(int lifetime) {
        this.maxLifetime = lifetime;
    }

    public void setFireEffect(boolean fireEffect) {
        this.fireEffect = fireEffect;
    }

    public void setBurnTicks(int burnTicks) {
        this.burnTicks = burnTicks;
    }

    public void setChannelingEffect(boolean channelingEffect) {
        this.channelingEffect = channelingEffect;
    }

    public void setLightningChance(double lightningChance) {
        this.lightningChance = lightningChance;
    }

    public void setWaterEffect(boolean waterEffect) {
        this.waterEffect = waterEffect;
    }

    public void setWaterDamage(int waterDamage) {
        this.waterDamage = waterDamage;
    }

    public void setBreathReduction(int breathReduction) {
        this.breathReduction = breathReduction;
    }

    public void setSpiderEffect(boolean spiderEffect) {
        this.spiderEffect = spiderEffect;
    }

    public void setPoisonChance(double poisonChance) {
        this.poisonChance = poisonChance;
    }

    public void setPoisonEffectTime(int poisonEffectTime) {
        this.poisonEffectTime = poisonEffectTime;
    }

    public void setSmiteEffect(boolean smiteEffect) {
        this.smiteEffect = smiteEffect;
    }

    public void setSmiteEffectTime(int smiteEffectTime) {
        this.smiteEffectTime = smiteEffectTime;
    }

    public void setFreezeEffect(boolean freezeEffect) {
        this.freezeEffect = freezeEffect;
    }

    public void setFreezeTicks(int freezeTicks) {
        this.freezeTicks = freezeTicks;
    }

    public void setThwackEffect(boolean thwackEffect) {
        this.thwackEffect = thwackEffect;
    }

    public void setInstantDespawnChance(double instantDespawnChance) {
        this.instantDespawnChance = instantDespawnChance;
    }

    public void setLuckEffect(boolean luckEffect) {
        this.luckEffect = luckEffect;
    }

    public void setDropChance(double dropChance) {
        this.dropChance = dropChance;
    }

    public void setHealEffect(boolean healEffect) {
        this.healEffect = healEffect;
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }

    public void setSilkTouchEffect(boolean silkTouchEffect) {
        this.silkTouchEffect = silkTouchEffect;
    }

    public void setAOEEffect(boolean AOEEffect) {
        this.AOEEffect = AOEEffect;
    }

    public void setAOEArea(double AOEArea) { this.AOEArea = AOEArea; }

    public void setCollectEffect(boolean collectEffect) { this.collectEffect = collectEffect; }

    public void setCollectArea(double collectArea) { this.collectArea = collectArea; }

    public void setArmorEffect(boolean armorEffect) { this.armorEffect = armorEffect; }

    public void setArmorHealAmount(float armorHealAmount) { this.armorHealAmount = armorHealAmount; }

    public void setLaunchEffect(boolean launchEffect) { this.launchEffect = launchEffect; }

    public void setLaunchEffectTime(int launchEffectTime) { this.launchEffectTime = launchEffectTime; }

    public void setKnockbackEffect(boolean knockbackEffect) { this.knockbackEffect = knockbackEffect; }

    public void setKnockbackStrength(double knockbackStrength) { this.knockbackStrength = knockbackStrength; }

    @Override
    public void tick() {
        super.tick();
        lifetime++;

        if (!level().isClientSide) {
            if (lifetime >= maxLifetime) {
                ParticleMethods.ParticlesBurst(this.level(), ParticleTypes.ENCHANT,
                        this.getX(), this.getY() + 1, this.getZ(), 5, 0.5);
                this.discard();
            }
        }

        if (this.level().isClientSide) {
            ParticleOptions particleoptions = this.getFollowingParticle();
            if (particleoptions != null) {
                double d0 = this.getX();
                double d1 = this.getY();
                double d2 = this.getZ();

                this.level().addParticle(particleoptions, d0, d1 + 0.25, d2, 0.0, 0.0, 0.0);
            }
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);

        Level level = this.level();

        if (!level.isClientSide) {
            Entity entity = result.getEntity();
            Entity owner = this.getOwner();
            DamageSource damageSource = this.damageSources().indirectMagic(this, owner);

            if (entity instanceof LivingEntity target) {
                if (AOEEffect) {
                    AABB aoeArea = new AABB(
                            target.getX() - AOEArea, target.getY() - AOEArea, target.getZ() - AOEArea,
                            target.getX() + AOEArea, target.getY() + AOEArea, target.getZ() + AOEArea
                    );

                    List<LivingEntity> affectedEntities = level.getEntitiesOfClass(LivingEntity.class, aoeArea,
                            e -> e != owner);

                    for (LivingEntity affected : affectedEntities) {
                        applyEffect(affected, damageSource);
                        ParticleMethods.ParticlesBurst(this.level(), ParticleTypes.ENCHANTED_HIT,
                                affected.getX(), affected.getY()+1, affected.getZ(), 10, 0.5);
                    }
                } else {
                    applyEffect(target, damageSource);
                    ParticleMethods.ParticlesBurst(this.level(), ParticleTypes.ENCHANTED_HIT,
                            this.getX(), this.getY(), this.getZ(), 20, 0.5);
                }


                level.playSound(null, this.getX(), this.getY(), this.getZ(),
                        SoundEvents.AMETHYST_CLUSTER_BREAK, SoundSource.PLAYERS, 0.5F, 1F);
            }

            this.discard();
        }
    }

    private void applyEffect(LivingEntity target, DamageSource damageSource) {
        if (healEffect) {
            WandEffects.HealEffect(target, healAmount);
        } else if (silkTouchEffect) {
            float maxDamage = target.getHealth() - 1;
            float finalDamage = Math.min(damage, maxDamage);
            target.hurt(damageSource, finalDamage);
        } else {
            target.hurt(damageSource, damage);
        }

        addProjectileModifiers(target, level(), this.getOwner());
    }

    protected void addProjectileModifiers(LivingEntity target, Level level, Entity owner) {

        if (fireEffect) {
            WandEffects.FireEffect(target, burnTicks);
        }

        if (channelingEffect) {
            WandEffects.ChannelingEffect(level, target, owner, lightningChance);
        }

        if (waterEffect) {
            WandEffects.WaterEffect(target, breathReduction, waterDamage);
        }

        if (spiderEffect) {
            WandEffects.SpiderEffect(target, poisonChance, poisonEffectTime);
        }

        if (smiteEffect) {
            WandEffects.SmiteEffect(target, smiteEffectTime);
        }

        if (freezeEffect) {
            WandEffects.FreezeEffect(target, freezeTicks);
        }

        if (thwackEffect) {
            WandEffects.ThwackEffect(target, instantDespawnChance);
        }

        if (luckEffect) {
            WandEffects.LuckEffect(target, dropChance);
        }

        if (collectEffect) {
            WandEffects.LoyaltyEffect(level, owner, target.position(), collectArea);
        }

        if (armorEffect) {
            WandEffects.ArmorEffect(owner, armorHealAmount);
        }

        if (launchEffect) {
            WandEffects.LaunchEffect(target, launchEffectTime);
        }

        if (knockbackEffect) {
            WandEffects.KnockbackEffect(target, this, knockbackStrength);
        }

    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if (!this.level().isClientSide) {
            ParticleMethods.ParticlesBurst(this.level(), ParticleTypes.ENCHANTED_HIT,
                    this.getX(), this.getY(), this.getZ(), 10, 0.5);
            level().playSound(null, this.getX(), this.getY(), this.getZ(),
                    SoundEvents.AMETHYST_CLUSTER_BREAK, SoundSource.PLAYERS, 0.3F, 1F);

            if (collectEffect) {
                WandEffects.LoyaltyEffect(this.level(), this.getOwner(), this.position(), collectArea);
            }
        }
        this.discard();
    }

    protected ParticleOptions getFollowingParticle() {
        return ParticleTypes.ENCHANT;
    }

    @Override
    protected ParticleOptions getTrailParticle() {
        return new SimpleParticleType(false);
    }

    @Override
    protected boolean canHitEntity(Entity target) {
        return !(target instanceof WandProjectileEntity) && !(target == this.getOwner()) && super.canHitEntity(target);
    }

    @Override
    public boolean canCollideWith(Entity entity) {
        return !(entity instanceof WandProjectileEntity) && !(entity == this.getOwner()) && super.canCollideWith(entity);
    }

    @Override
    protected float getInertia() {
        return 1.0F;
    }

    @Override
    protected boolean shouldBurn() {
        return false;
    }

    //GeckoLib
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<GeoAnimatable>(this, "controller", 4, this::predicate));
    }

    private PlayState predicate(AnimationState<GeoAnimatable> state) {

        state.getController().setAnimation(RawAnimation.begin().then("fly", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;

    }

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}