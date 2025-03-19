package net.trashelemental.junkyard_lib.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

/**
 * A basic tamed mob that can be tamed if wild, and can be interacted with to cycle its
 * behavior between follow, stay, and wander, sending an action bar message.
 *
 */

@SuppressWarnings("Deprecated")
public class TamableEntity extends TamableAnimal {

    /**
     * The item that can be used to tame the mob if it is not tamed.
     */
    private final Item tameItem;
    /**
     * The food/breed item for the mob. Pass in 'null' if you don't want it to
     * be able to breed, and override the breed offspring to be null as well just in case.
     */
    private final Item breedItem;

    public TamableEntity(EntityType<? extends TamableAnimal> entityType, Level level, Item tameItem, Item breedItem) {
        super(entityType, level);
        this.tameItem = tameItem;
        this.breedItem = breedItem;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        {
            this.goalSelector.addGoal(1, new OwnerHurtByTargetGoal(this) {
                @Override
                public boolean canUse() {
                    return super.canUse() && !stay(TamableEntity.this);
                }
            });
            this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this) {
                @Override
                public boolean canUse() {
                    return super.canUse() && follow(TamableEntity.this);
                }
            });
            this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false));
            this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
            this.goalSelector.addGoal(5, new FollowOwnerGoal(this, 1, 10, 2, false) {
                @Override
                public boolean canUse() {
                    return super.canUse() && wander(TamableEntity.this);
                }
            });

            this.goalSelector.addGoal(6, new TemptGoal(this, 1, Ingredient.of(tameItem), false) {
                @Override
                public boolean canUse() {
                    return super.canUse() && !isTame(TamableEntity.this);
                }
            });
            this.goalSelector.addGoal(7, new TemptGoal(this, 1, Ingredient.of(breedItem), false) {
                @Override
                public boolean canUse() {
                    return super.canUse() && !stay(TamableEntity.this);
                }
            });
            this.goalSelector.addGoal(8, new BreedGoal(this, 1) {
                @Override
                public boolean canUse() {
                    return super.canUse() && !stay(TamableEntity.this);
                }
            });
            this.goalSelector.addGoal(9, new RandomStrollGoal(this, 1) {
                @Override
                public boolean canUse() {
                    return super.canUse() && wander(TamableEntity.this);
                }
            });
            this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, (float) 6));
            this.goalSelector.addGoal(11, new RandomLookAroundGoal(this));
        }
    }

    public static boolean follow(TamableEntity entity) {
        if (entity == null)
            return false;
        return entity.isFollowing();
    }

    public static boolean wander(TamableEntity entity) {
        if (entity == null)
            return false;
        return entity.isWandering();
    }

    public static boolean stay(TamableEntity entity) {
        return !follow(entity) && !wander(entity);
    }

    public static boolean isTame(TamableEntity entity) {
        return entity.isTame();
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()

                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.ATTACK_DAMAGE, 5)
                .add(Attributes.FOLLOW_RANGE, 16)
                .add(Attributes.ATTACK_KNOCKBACK, 0);

    }

    /**
     * Sound Events.
     */
    @Override
    public SoundEvent getAmbientSound() {
        return SoundEvents.AXOLOTL_IDLE_AIR;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return SoundEvents.AXOLOTL_HURT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.AXOLOTL_DEATH;
    }


    /**
     * Item that can be used to breed it.
     */
    @Override
    public boolean isFood(ItemStack itemStack) {
        return itemStack.is(breedItem);
    }

    /**
     * Make this null and remove breed goals if you don't want your entity to breed.
     */
    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return this;
    }


    /**
     * Mob interact behavior.
     */
    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);

        //Tries to tame the mob if it isn't already tamed.
        if (itemstack.is(tameItem)) {
            this.usePlayerItem(pPlayer, pHand, itemstack);
            if (!this.isTame()) {
                if (this.random.nextInt(5) == 0) {
                    this.tame(pPlayer);
                    this.BEHAVIOR = "FOLLOW";
                    this.level().broadcastEntityEvent(this, (byte) 7);
                } else {
                    this.level().broadcastEntityEvent(this, (byte) 6);
                }
                this.setPersistenceRequired();
                return InteractionResult.SUCCESS;
            }
        } else {
            InteractionResult retval = super.mobInteract(pPlayer, pHand);
            if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME) {
                this.setPersistenceRequired();
            }

            //Cycles behavior if it's owned by the player who interacted with it
            if (this.isOwnedBy(pPlayer)) {
                cycleBehavior(pPlayer);
                return InteractionResult.SUCCESS;
            }


            return retval;
        }
        return InteractionResult.PASS;
    }


    /**
     * Behavior NBT and cycling method.
     */
    public String BEHAVIOR = "WANDER";

    private void setBehaviorInPersistentData(String behavior) {
        CompoundTag tag = this.getPersistentData();
        tag.putString("Behavior", behavior);
    }

    public boolean isFollowing() {
        return this.BEHAVIOR.equals("FOLLOW");
    }

    public boolean isWandering() {
        return this.BEHAVIOR.equals("WANDER");
    }

    private void cycleBehavior(Player pPlayer) {
        switch (this.BEHAVIOR) {
            case "FOLLOW":
                this.BEHAVIOR = "WANDER";
                pPlayer.displayClientMessage(Component.literal(entityName + " will wander"), true);
                break;
            case "STAY":
                this.BEHAVIOR = "FOLLOW";
                pPlayer.displayClientMessage(Component.literal(entityName + " will follow"), true);
                break;
            case "WANDER":
                this.BEHAVIOR = "STAY";
                pPlayer.displayClientMessage(Component.literal(entityName + " will stay"), true);
                break;
        }
        this.setBehaviorInPersistentData(this.BEHAVIOR);
    }

    /**
     * Gets the entity's custom name if it has one, or defaults to its lang entry.
     * Useful for unique skins for custom names.
     */
    public String getEntityName() {
        if (this.hasCustomName()) {
            return this.getCustomName().getString();
        }
        return this.getType().getDescription().getString();
    }

    String entityName = this.getEntityName();

    /**
     * NBT data.
     */
    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putString("Behavior", this.BEHAVIOR);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Behavior")) {
            this.BEHAVIOR = compound.getString("Behavior");
        }
    }


}
