package net.trashelemental.enchanted_wands_tomes.item.custom;

import com.google.common.collect.ImmutableMultimap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.trashelemental.enchanted_wands_tomes.util.EnchantmentChecker;
import net.trashelemental.enchanted_wands_tomes.util.ModTags;
import net.trashelemental.enchanted_wands_tomes.util.NumberConverter;
import net.trashelemental.enchanted_wands_tomes.util.Wand.WandFireProjectile;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class WandItem extends Item {
    private final int baseDamage;
    private final int baseCooldown;
    private final double baseSpeed = 0.4;
    private final int maxEnchantments;
    private final int enchantmentValue;

    protected int fireLevel = 0;
    protected int channelingLevel = 0;
    protected int freezeLevel = 0;
    protected int knockbackLevel = 0;
    protected int launchLevel = 0;
    protected int luckLevel = 0;
    protected int waterLevel = 0;
    protected int smiteLevel = 0;
    protected int spiderLevel = 0;
    protected int thwackLevel = 0;
    protected int healLevel = 0;
    protected int silkTouchLevel = 0;
    protected int AOELevel = 0;
    protected int collectLevel = 0;
    protected int armorLevel = 0;
    protected int rangeLevel = 0;
    protected int multishotLevel = 0;
    protected int damageLevel = 0;
    protected int cooldownLevel = 0;

    public WandItem(Properties properties, int baseDamage, int baseCooldown, int maxEnchantments, int enchantmentValue) {
        super(properties);
        this.baseDamage = baseDamage;
        this.baseCooldown = baseCooldown;
        this.maxEnchantments = maxEnchantments;
        this.enchantmentValue = enchantmentValue;
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 1.0D, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", (double)-1.5F, AttributeModifier.Operation.ADDITION));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level pLevel, List<Component> tooltipComponents, TooltipFlag pIsAdvanced) {

        EnchantmentChecker check = new EnchantmentChecker();
        int fireLevel = getFireLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.FIRE);
        int channelingLevel = getChannelingLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.CHANNELING);
        int freezeLevel = getFreezeLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.FREEZE);
        int knockbackLevel = getKnockbackLevel(stack) + check.checkEnchantmentLevel(stack, ModTags.Enchantments.KNOCKBACK);
        int launchLevel = getLaunchLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.LAUNCH);
        int luckLevel = getLuckLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.LUCK);
        int waterLevel = getWaterLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.WATER);
        int smiteLevel = getSmiteLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.WAND_SMITE);
        int spiderLevel = getSpiderLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.WAND_SPIDER);
        int thwackLevel = getThwackLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.WAND_THWACK);
        int healLevel = getHealLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.HEAL);
        int silkTouchLevel = getSilkTouchLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.SILK_TOUCH);
        int AOELevel = getAOELevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.WAND_AOE);
        int collectLevel = getCollectLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.WAND_LURE);
        int armorLevel = getArmorLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.WAND_ARMOR);
        int rangeLevel = getRangeLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.WAND_RANGE);
        int multishotLevel = getMultishotLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.MULTISHOT);
        int damageLevel = getDamageLevel(stack) + check.checkEnchantmentLevel(stack, ModTags.Enchantments.WAND_DAMAGE);
        int cooldownLevel = getCooldownLevel() + check.checkEnchantmentLevel(stack, ModTags.Enchantments.COOLDOWN_REDUCE);

        tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.enchantment_levels",
                getCurrentEnchantments(stack), maxEnchantments).withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.DARK_GRAY));

        if (getCurrentEnchantments(stack) >= 1) {
            if (fireLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(fireLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_fire")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (channelingLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(channelingLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_channeling")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (freezeLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(freezeLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_freeze")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (knockbackLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(knockbackLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_knockback")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (launchLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(launchLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_launch")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (luckLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(luckLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_luck")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (waterLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(waterLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_water")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (spiderLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(spiderLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_spider")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (smiteLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(smiteLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_smite")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (thwackLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(thwackLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_thwack")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (healLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(healLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_heal")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (silkTouchLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(silkTouchLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_silk_touch")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (AOELevel > 0) {
                String romanFireLevel = NumberConverter.numberToRomanNum(AOELevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_aoe")
                        .append(Component.literal(" " + romanFireLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (collectLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(collectLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_collect")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (armorLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(armorLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_armor")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (rangeLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(rangeLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_range")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (damageLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(damageLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_damage")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (cooldownLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(cooldownLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_cooldown")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (multishotLevel > 0) {
                String romanLevel = NumberConverter.numberToRomanNum(multishotLevel);
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_multishot")
                        .append(Component.literal(" " + romanLevel))
                        .withStyle(ChatFormatting.BLUE));
            }
            if (Screen.hasShiftDown()) {
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.modifier_effects").
                        withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.DARK_GRAY));
                if (fireLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_fire_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (channelingLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_channeling_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (freezeLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_freeze_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (knockbackLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_knockback_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (launchLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_launch_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (luckLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_luck_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (waterLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_water_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (spiderLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_spider_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (smiteLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_smite_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (thwackLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_thwack_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (healLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_heal_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (silkTouchLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_silk_touch_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (AOELevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_aoe_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (collectLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_collect_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (armorLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_armor_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (rangeLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_range_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (damageLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_damage_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (cooldownLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_cooldown_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
                if (multishotLevel > 0) {
                    tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.wand_multishot_desc")
                            .withStyle(ChatFormatting.BLUE));
                }
            } else {
                tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.hold_shift").
                        withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.DARK_GRAY));
            }
            tooltipComponents.add(Component.translatable("tooltip.enchanted_wands_tomes.blank_space"));
        }

        super.appendHoverText(stack, pLevel, tooltipComponents, pIsAdvanced);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return true;
    }

    @Override
    public boolean isEnchantable(ItemStack pStack) {
        return true;
    }

    @Override
    public int getEnchantmentValue(ItemStack stack) {
        return this.enchantmentValue;
    }

    public int getAdjustedDamage(ItemStack stack) {
        EnchantmentChecker check = new EnchantmentChecker();
        int damageBonus = check.checkEnchantmentLevel(stack, ModTags.Enchantments.WAND_DAMAGE);

        return baseDamage + damageBonus;
    }

    public int getAdjustedCooldown(ItemStack stack) {
        EnchantmentChecker check = new EnchantmentChecker();
        int cooldownReduction = check.checkEnchantmentLevel(stack, ModTags.Enchantments.COOLDOWN_REDUCE);
        float reductionFactor = 1.0f - (0.1f * cooldownReduction);

        return Math.max(1, Math.round(baseCooldown * reductionFactor));
    }

    public double getAdjustedSpeed(ItemStack stack) {
        EnchantmentChecker check = new EnchantmentChecker();
        int bonusSpeed = check.checkEnchantmentLevel(stack, ModTags.Enchantments.WAND_RANGE);

        double speedModifier = (0.2 * bonusSpeed);

        return (baseSpeed + speedModifier);
    }

    public int getMaxEnchantments(ItemStack stack) {
        return this.maxEnchantments;
    }

    public int getCurrentEnchantments(ItemStack stack) {
        Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(stack);

        return enchantments.size();
    }

    public int getAdjustedDurabilityLoss(ItemStack stack) {
        return 1;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, (e) -> e.broadcastBreakEvent(attacker.getUsedItemHand()));
        return true;
    }

    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        return !player.isCreative();
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            WandFireProjectile fireProjectile = new WandFireProjectile();

            fireProjectile.performProjectileAttack(player, level,
                    getAdjustedSpeed(stack), getAdjustedDamage(stack), stack);
            stack.hurtAndBreak(getAdjustedDurabilityLoss(stack), player, (e) -> e.broadcastBreakEvent(player.getUsedItemHand()));
            player.getCooldowns().addCooldown(this, getAdjustedCooldown(stack));
        }

        player.swing(hand);

        return InteractionResultHolder.consume(stack);
    }

    public int getFireLevel() { return fireLevel; }
    public int getChannelingLevel() { return channelingLevel; }
    public int getFreezeLevel() { return freezeLevel; }
    public int getKnockbackLevel(ItemStack stack) { return knockbackLevel; }
    public int getLaunchLevel() { return launchLevel; }
    public int getLuckLevel() { return luckLevel; }
    public int getWaterLevel() { return waterLevel; }
    public int getSmiteLevel() { return smiteLevel; }
    public int getSpiderLevel() { return spiderLevel; }
    public int getThwackLevel() { return thwackLevel; }
    public int getHealLevel() { return healLevel; }
    public int getSilkTouchLevel() { return silkTouchLevel; }
    public int getAOELevel() { return AOELevel; }
    public int getCollectLevel() { return collectLevel; }
    public int getArmorLevel() { return armorLevel; }
    public int getRangeLevel() { return rangeLevel; }
    public int getMultishotLevel() { return multishotLevel; }
    public int getDamageLevel(ItemStack stack) { return damageLevel; }
    public int getCooldownLevel() { return cooldownLevel; }
}
