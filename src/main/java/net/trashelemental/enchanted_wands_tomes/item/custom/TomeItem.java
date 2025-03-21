package net.trashelemental.enchanted_wands_tomes.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
import net.trashelemental.enchanted_wands_tomes.util.CheckEnchantForCompatibility;
import net.trashelemental.enchanted_wands_tomes.util.EnchantmentChecker;
import net.trashelemental.enchanted_wands_tomes.util.ModTags;
import net.trashelemental.enchanted_wands_tomes.util.NumberConverter;
import net.trashelemental.enchanted_wands_tomes.util.Tome.TomeUseItem;

import java.util.List;

public class TomeItem extends Item {
    private final int baseCooldown;
    private final int enchantmentValue;
    private final int maxEnchantments;
    protected int durabilityLoss = 1;

    protected int fireLevel = 0;
    protected int channelingLevel = 0;
    protected int freezeLevel = 0;
    protected int knockbackLevel = 0;
    protected int launchLevel = 0;
    protected int luckLevel = 0;
    protected int waterLevel = 0;
    protected int healLevel = 0;
    protected int silkTouchLevel = 0;
    protected int AOELevel = 0;
    protected int collectLevel = 0;
    protected int armorLevel = 0;
    protected int multishotLevel = 0;
    protected int cooldownLevel = 0;
    protected int stealthLevel = 0;
    protected int debuffLevel = 0;
    protected int dashLevel = 0;

    public TomeItem(Properties properties, int baseCooldown, int enchantmentValue, int maxEnchantments) {
        super(properties);
        this.baseCooldown = baseCooldown;
        this.enchantmentValue = enchantmentValue;
        this.maxEnchantments = maxEnchantments;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

        EnchantmentChecker check = new EnchantmentChecker();
        int fireLevel = getFireLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.FIRE);
        int channelingLevel = getChannelingLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.CHANNELING);
        int freezeLevel = getFreezeLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.FREEZE);
        int knockbackLevel = getKnockbackLevel(stack) + check.checkEnchantmentLevel(stack, ModTags.Enchantments.KNOCKBACK);
        int launchLevel = getLaunchLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.LAUNCH);
        int luckLevel = getLuckLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.LUCK);
        int waterLevel = getWaterLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.WATER);
        int healLevel = getHealLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.HEAL);
        int silkTouchLevel = getSilkTouchLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.SILK_TOUCH);
        int AOELevel = getAOELevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.TOME_AOE);
        int collectLevel = getCollectLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.TOME_PULL);
        int armorLevel = getArmorLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.TOME_ARMOR);
        int multishotLevel = getMultishotLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.MULTISHOT);
        int cooldownLevel = getCooldownLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.COOLDOWN_REDUCE);
        int stealthLevel = getStealthLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.TOME_STEALTH);
        int debuffLevel = getDebuffLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.TOME_DEBUFF);
        int dashLevel = getDashLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.TOME_DASH);

        int combinedCooldownLevel = (cooldownLevel + multishotLevel);

        tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.enchantment_levels",
                getCurrentEnchantments(stack), maxEnchantments).withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.DARK_GRAY));

        if (getCurrentEnchantments(stack) >= 1) {
            if (stealthLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(stealthLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_stealth")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (debuffLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(debuffLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_debuff")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (dashLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(dashLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_dash")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (fireLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(fireLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_fire")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (channelingLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(channelingLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_channeling")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (freezeLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(freezeLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_freeze")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (knockbackLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(knockbackLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_knockback")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (launchLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(launchLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_launch")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (luckLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(luckLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_luck")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (waterLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(waterLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_water")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (healLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(healLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_heal")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (silkTouchLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(silkTouchLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_silk_touch")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (AOELevel > 0) {
                String romanFireLevel = NumberConverter.numberToRomanNum(AOELevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_aoe")
                        .append(Component.literal(" " + romanFireLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (collectLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(collectLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_gather")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (armorLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(armorLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_armor")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (combinedCooldownLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(combinedCooldownLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_cooldown")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (Screen.hasShiftDown()) {
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.modifier_effects").
                        withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.DARK_GRAY));
                if (stealthLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_stealth_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (debuffLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_debuff_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (dashLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_dash_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (fireLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_fire_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (channelingLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_channeling_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (freezeLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_freeze_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (knockbackLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_knockback_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (launchLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_launch_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (luckLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_luck_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (waterLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_water_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (healLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_heal_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (silkTouchLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_silk_touch_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (AOELevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_aoe_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (collectLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_gather_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (armorLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_armor_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (cooldownLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_cooldown_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (dashLevel > 0 && stealthLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.tome_teleport_damage_desc")
                            .withStyle(ChatFormatting.YELLOW));
                }
            } else {
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.hold_shift").
                        withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.DARK_GRAY));
            }
            tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.blank_space"));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    public boolean supportsEnchantment(ItemStack stack, Holder<Enchantment> enchantment) {
        return CheckEnchantForCompatibility.isEnchantmentInTags(enchantment);
    }

    @Override
    public int getEnchantmentValue(ItemStack stack) {
        return this.enchantmentValue;
    }

    public int getMaxEnchantments(ItemStack stack) {
        return this.maxEnchantments;
    }

    public int getCurrentEnchantments(ItemStack stack) {
        ItemEnchantments enchantments = stack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);

        return enchantments.size();
    }

    public int getAdjustedCooldown(ItemStack stack) {

        EnchantmentChecker check = new EnchantmentChecker();
        int cooldown = check.checkEnchantmentLevel(stack, ModTags.Enchantments.COOLDOWN_REDUCE);
        int multishot = check.checkEnchantmentLevel(stack, ModTags.Enchantments.MULTISHOT);
        int cooldownLevels = (cooldown + multishot);
        float reductionFactor = Math.max(0.1f, 1.0f - (0.1f * cooldownLevels));

        int cooldownAddition = ((getCurrentEnchantments(stack) - cooldownLevels) * 40);

        return Math.max(5, Math.round((baseCooldown + cooldownAddition) * reductionFactor));
    }

    public int getAdjustedDurabilityLoss(ItemStack stack) {
        return durabilityLoss + getCurrentEnchantments(stack);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack stack = player.getItemInHand(usedHand);

        TomeUseItem use = new TomeUseItem();
        use.useTomeItem(player, stack, level);

        if (!level.isClientSide) {
            stack.hurtAndBreak(getAdjustedDurabilityLoss(stack), player, EquipmentSlot.MAINHAND);
            player.getCooldowns().addCooldown(this, getAdjustedCooldown(stack));
        }

        int numParticles = 60;
        double radius = 3.0;
        double angleStep = Math.PI * 2 / numParticles;

        for (int i = 0; i < numParticles; i++) {
            double angle = angleStep * i;
            double xOffset = Math.cos(angle) * radius;
            double zOffset = Math.sin(angle) * radius;
            double yOffset = 1.2;

            level.addParticle(ParticleTypes.ENCHANT,
                    player.getX() + xOffset,
                    player.getY() + yOffset,
                    player.getZ() + zOffset,
                    0, 0, 0);
        }

        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.EVOKER_CAST_SPELL, SoundSource.PLAYERS, 0.5F, 2F);

        player.swing(usedHand);

        return InteractionResultHolder.consume(stack);
    }

    public int getFireLevel() { return fireLevel; }
    public int getChannelingLevel() { return channelingLevel; }
    public int getFreezeLevel() { return freezeLevel; }
    public int getKnockbackLevel(ItemStack stack) { return knockbackLevel; }
    public int getLaunchLevel() { return launchLevel; }
    public int getLuckLevel() { return luckLevel; }
    public int getHealLevel() { return healLevel; }
    public int getSilkTouchLevel() { return silkTouchLevel; }
    public int getAOELevel() { return AOELevel; }
    public int getArmorLevel() { return armorLevel; }
    public int getMultishotLevel() { return multishotLevel; }
    public int getCooldownLevel() { return cooldownLevel; }
    public int getWaterLevel() { return waterLevel; }
    public int getCollectLevel() { return collectLevel; }
    public int getStealthLevel() { return stealthLevel; }
    public int getDebuffLevel() { return debuffLevel; }
    public int getDashLevel() { return dashLevel; }
}
