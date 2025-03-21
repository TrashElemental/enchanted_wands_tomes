package net.trashelemental.enchanted_wands_tomes.compat;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.trashelemental.enchanted_wands_tomes.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class EnchantmentCompatProvider extends TagsProvider<Enchantment> {

    public EnchantmentCompatProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, ResourceKey.createRegistryKey(Registries.ENCHANTMENT.location()), lookupProvider, CompletableFuture.completedFuture(TagLookup.empty()), modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        addEnchantmentToTag("minecraft:channeling", ModTags.Enchantments.CHANNELING);
        addEnchantmentToTag("dungeonsenchantments:thundering", ModTags.Enchantments.CHANNELING);
        addEnchantmentToTag("enchantments_plus:chaining", ModTags.Enchantments.CHANNELING);

        addEnchantmentToTag("minecraft:flame", ModTags.Enchantments.FIRE);
        addEnchantmentToTag("minecraft:fire_aspect", ModTags.Enchantments.FIRE);
        addEnchantmentToTag("minecraft:fire_protection", ModTags.Enchantments.FIRE);
        addEnchantmentToTag("enchantments_plus:auto_smelting", ModTags.Enchantments.FIRE);
        addEnchantmentToTag("enchantments_plus:lava_walker", ModTags.Enchantments.FIRE);
        addEnchantmentToTag("enchantments_plus:blaze_guard", ModTags.Enchantments.FIRE);
        addEnchantmentToTag("mocurses:curseof_flammability", ModTags.Enchantments.FIRE);
        addEnchantmentToTag("alexsmobs:lavawax", ModTags.Enchantments.FIRE);
        addEnchantmentToTag("alexsmobs:serpentfriend", ModTags.Enchantments.FIRE);

        addEnchantmentToTag("minecraft:efficiency", ModTags.Enchantments.COOLDOWN_REDUCE);
        addEnchantmentToTag("minecraft:quick_charge", ModTags.Enchantments.COOLDOWN_REDUCE);
        addEnchantmentToTag("hasteenchantment:haste", ModTags.Enchantments.COOLDOWN_REDUCE);
        addEnchantmentToTag("magiccombatwands:cooldown", ModTags.Enchantments.COOLDOWN_REDUCE);
        addEnchantmentToTag("enchantments_plus:agility", ModTags.Enchantments.COOLDOWN_REDUCE);
        addEnchantmentToTag("enchantments_plus:boosting", ModTags.Enchantments.COOLDOWN_REDUCE);
        addEnchantmentToTag("enchantments_plus:lightness", ModTags.Enchantments.COOLDOWN_REDUCE);
        addEnchantmentToTag("mocurses:curseof_golden_touch", ModTags.Enchantments.COOLDOWN_REDUCE);

        addEnchantmentToTag("minecraft:binding_curse", ModTags.Enchantments.FREEZE);
        addEnchantmentToTag("minecraft:frost_walker", ModTags.Enchantments.FREEZE);
        addEnchantmentToTag("dungeonsenchantments:freezing", ModTags.Enchantments.FREEZE);
        addEnchantmentToTag("enchantments_plus:ice_aspect", ModTags.Enchantments.FREEZE);
        addEnchantmentToTag("enchantments_plus:chill_guard", ModTags.Enchantments.FREEZE);
        addEnchantmentToTag("enchantments_plus:frostbite", ModTags.Enchantments.FREEZE);
        addEnchantmentToTag("mocurses:curseof_frost_imprisonment", ModTags.Enchantments.FREEZE);
        addEnchantmentToTag("enlightened_end:permafrost_curse", ModTags.Enchantments.FREEZE);

        addEnchantmentToTag("minecraft:unbreaking", ModTags.Enchantments.HEAL);
        addEnchantmentToTag("minecraft:mending", ModTags.Enchantments.HEAL);
        addEnchantmentToTag("life_steal_enchantment:life_steal", ModTags.Enchantments.HEAL);
        addEnchantmentToTag("magiccombatwands:magic_protection", ModTags.Enchantments.HEAL);
        addEnchantmentToTag("dungeonsenchantments:leeching", ModTags.Enchantments.HEAL);
        addEnchantmentToTag("dungeonsenchantments:recycler", ModTags.Enchantments.HEAL);
        addEnchantmentToTag("enchantments_plus:rebirth", ModTags.Enchantments.HEAL);
        addEnchantmentToTag("enchantments_plus:sunlights_blessing", ModTags.Enchantments.HEAL);
        addEnchantmentToTag("enchantments_plus:blood_blade", ModTags.Enchantments.HEAL);

        addEnchantmentToTag("minecraft:knockback", ModTags.Enchantments.KNOCKBACK);
        addEnchantmentToTag("minecraft:punch", ModTags.Enchantments.KNOCKBACK);
        addEnchantmentToTag("dungeonsenchantments:cowardice", ModTags.Enchantments.KNOCKBACK);
        addEnchantmentToTag("dungeonsenchantments:deflect", ModTags.Enchantments.KNOCKBACK);
        addEnchantmentToTag("enchantments_plus:stunning", ModTags.Enchantments.KNOCKBACK);
        addEnchantmentToTag("enchantments_plus:lenght", ModTags.Enchantments.KNOCKBACK);
        addEnchantmentToTag("enchantments_plus:blocking", ModTags.Enchantments.KNOCKBACK);
        addEnchantmentToTag("enchantments_plus:reflection", ModTags.Enchantments.KNOCKBACK);
        addEnchantmentToTag("enchantments_plus:shove", ModTags.Enchantments.KNOCKBACK);

        addEnchantmentToTag("minecraft:feather_falling", ModTags.Enchantments.LAUNCH);
        addEnchantmentToTag("minecraft:density", ModTags.Enchantments.LAUNCH);
        addEnchantmentToTag("minecraft:wind_burst", ModTags.Enchantments.LAUNCH);
        addEnchantmentToTag("enchantments_plus:jumper", ModTags.Enchantments.LAUNCH);
        addEnchantmentToTag("enchantments_plus:floating", ModTags.Enchantments.LAUNCH);
        addEnchantmentToTag("enchantments_plus:soaring", ModTags.Enchantments.LAUNCH);
        addEnchantmentToTag("enchantments_plus:turbulence", ModTags.Enchantments.LAUNCH);
        addEnchantmentToTag("mocurses:curseof_floating", ModTags.Enchantments.LAUNCH);
        addEnchantmentToTag("finsandtails:uppercutting", ModTags.Enchantments.LAUNCH);
        addEnchantmentToTag("alexsmobs:straddle_jump", ModTags.Enchantments.LAUNCH);

        addEnchantmentToTag("minecraft:fortune", ModTags.Enchantments.LUCK);
        addEnchantmentToTag("minecraft:luck_of_the_sea", ModTags.Enchantments.LUCK);
        addEnchantmentToTag("minecraft:looting", ModTags.Enchantments.LUCK);
        addEnchantmentToTag("enchantments_plus:bait", ModTags.Enchantments.LUCK);
        addEnchantmentToTag("reliquary:severing", ModTags.Enchantments.LUCK);
        addEnchantmentToTag("mysticalagriculture:soul_siphoner", ModTags.Enchantments.LUCK);
        addEnchantmentToTag("mysticalagriculture:mystical_enlightenment", ModTags.Enchantments.LUCK);
        addEnchantmentToTag("finsandtails:crabs_favor", ModTags.Enchantments.LUCK);

        addEnchantmentToTag("minecraft:multishot", ModTags.Enchantments.MULTISHOT);
        addEnchantmentToTag("minecraft:infinity", ModTags.Enchantments.MULTISHOT);
        addEnchantmentToTag("magiccombatwands:thrifty", ModTags.Enchantments.MULTISHOT);
        addEnchantmentToTag("enchantments_plus:replanting", ModTags.Enchantments.MULTISHOT);

        addEnchantmentToTag("minecraft:silk_touch", ModTags.Enchantments.SILK_TOUCH);
        addEnchantmentToTag("dungeonsenchantments:radiance", ModTags.Enchantments.SILK_TOUCH);
        addEnchantmentToTag("dungeonsenchantments:radiance_shot", ModTags.Enchantments.SILK_TOUCH);

        addEnchantmentToTag("minecraft:blast_protection", ModTags.Enchantments.TOME_AOE);
        addEnchantmentToTag("minecraft:sweeping_edge", ModTags.Enchantments.TOME_AOE);
        addEnchantmentToTag("minecraft:thorns", ModTags.Enchantments.TOME_AOE);
        addEnchantmentToTag("minecraft:sharpness", ModTags.Enchantments.TOME_AOE);
        addEnchantmentToTag("minecraft:power", ModTags.Enchantments.TOME_AOE);
        addEnchantmentToTag("minecraft:breach", ModTags.Enchantments.TOME_AOE);
        addEnchantmentToTag("magiccombatwands:skillful", ModTags.Enchantments.TOME_AOE);
        addEnchantmentToTag("dungeonsenchantments:pain_cycle", ModTags.Enchantments.TOME_AOE);
        addEnchantmentToTag("dungeonsenchantments:exploding", ModTags.Enchantments.TOME_AOE);
        addEnchantmentToTag("enchantments_plus:pain_power", ModTags.Enchantments.TOME_AOE);
        addEnchantmentToTag("enchantments_plus:spikes", ModTags.Enchantments.TOME_AOE);
        addEnchantmentToTag("enchantments_plus:execution", ModTags.Enchantments.TOME_AOE);
        addEnchantmentToTag("mocurses:curseof_disorder", ModTags.Enchantments.TOME_AOE);
        addEnchantmentToTag("mocurses:curseof_betrayal", ModTags.Enchantments.TOME_AOE);
        addEnchantmentToTag("mocurses:curseof_zone", ModTags.Enchantments.TOME_AOE);
        addEnchantmentToTag("mocurses:curseof_hordes", ModTags.Enchantments.TOME_AOE);

        addEnchantmentToTag("minecraft:protection", ModTags.Enchantments.TOME_ARMOR);
        addEnchantmentToTag("minecraft:projectile_protection", ModTags.Enchantments.TOME_ARMOR);
        addEnchantmentToTag("dungeonsenchantments:guarding_strike", ModTags.Enchantments.TOME_ARMOR);
        addEnchantmentToTag("enchantments_plus:enhancement", ModTags.Enchantments.TOME_ARMOR);
        addEnchantmentToTag("enchantments_plus:armor", ModTags.Enchantments.TOME_ARMOR);
        addEnchantmentToTag("ars_nouveau:mirror_shield", ModTags.Enchantments.TOME_ARMOR);

        addEnchantmentToTag("minecraft:riptide", ModTags.Enchantments.TOME_DASH);
        addEnchantmentToTag("minecraft:piercing", ModTags.Enchantments.TOME_DASH);
        addEnchantmentToTag("mocurses:curseof_movement", ModTags.Enchantments.TOME_DASH);
        addEnchantmentToTag("finsandtails:fluked_edge", ModTags.Enchantments.TOME_DASH);

        addEnchantmentToTag("minecraft:smite", ModTags.Enchantments.TOME_DEBUFF);
        addEnchantmentToTag("minecraft:bane_of_arthropods", ModTags.Enchantments.TOME_DEBUFF);
        addEnchantmentToTag("dungeonsenchantments:illagers_bane", ModTags.Enchantments.TOME_DEBUFF);
        addEnchantmentToTag("dungeonsenchantments:weakening", ModTags.Enchantments.TOME_DEBUFF);
        addEnchantmentToTag("enchantments_plus:poison_cloud", ModTags.Enchantments.TOME_DEBUFF);
        addEnchantmentToTag("enchantments_plus:sensing", ModTags.Enchantments.TOME_DEBUFF);
        addEnchantmentToTag("mocurses:curseof_notice", ModTags.Enchantments.TOME_DEBUFF);
        addEnchantmentToTag("mocurses:curseof_deterioration", ModTags.Enchantments.TOME_DEBUFF);
        addEnchantmentToTag("mocurses:curseof_withering", ModTags.Enchantments.TOME_DEBUFF);

        addEnchantmentToTag("minecraft:lure", ModTags.Enchantments.TOME_PULL);
        addEnchantmentToTag("minecraft:loyalty", ModTags.Enchantments.TOME_PULL);
        addEnchantmentToTag("soulbound:soulbound", ModTags.Enchantments.TOME_PULL);
        addEnchantmentToTag("mocurses:curseof_voiding", ModTags.Enchantments.TOME_PULL);
        addEnchantmentToTag("ars_nouveau:soulbound", ModTags.Enchantments.TOME_PULL);
        addEnchantmentToTag("alexsmobs:board_return", ModTags.Enchantments.TOME_PULL);

        addEnchantmentToTag("minecraft:swift_sneak", ModTags.Enchantments.TOME_STEALTH);
        addEnchantmentToTag("minecraft:vanishing_curse", ModTags.Enchantments.TOME_STEALTH);
        addEnchantmentToTag("minecraft:soul_speed", ModTags.Enchantments.TOME_STEALTH);
        addEnchantmentToTag("speed_enchantment:speed", ModTags.Enchantments.TOME_STEALTH);
        addEnchantmentToTag("magiccombatwands:magic_wind", ModTags.Enchantments.TOME_STEALTH);
        addEnchantmentToTag("dungeonsenchantments:ambush", ModTags.Enchantments.TOME_STEALTH);
        addEnchantmentToTag("dungeonsenchantments:rush", ModTags.Enchantments.TOME_STEALTH);
        addEnchantmentToTag("enchantments_plus:acceleration", ModTags.Enchantments.TOME_STEALTH);
        addEnchantmentToTag("enchantments_plus:reach", ModTags.Enchantments.TOME_STEALTH);
        addEnchantmentToTag("enchantments_plus:fleetfoot", ModTags.Enchantments.TOME_STEALTH);
        addEnchantmentToTag("mocurses:curseof_station", ModTags.Enchantments.TOME_STEALTH);
        addEnchantmentToTag("mocurses:curseof_teleportation", ModTags.Enchantments.TOME_STEALTH);

        addEnchantmentToTag("minecraft:blast_protection", ModTags.Enchantments.WAND_AOE);
        addEnchantmentToTag("minecraft:sweeping_edge", ModTags.Enchantments.WAND_AOE);
        addEnchantmentToTag("dungeonsenchantments:pain_cycle", ModTags.Enchantments.WAND_AOE);
        addEnchantmentToTag("dungeonsenchantments:exploding", ModTags.Enchantments.WAND_AOE);
        addEnchantmentToTag("dungeonsenchantments:void_strike", ModTags.Enchantments.WAND_AOE);
        addEnchantmentToTag("mocurses:curseof_zone", ModTags.Enchantments.WAND_AOE);
        addEnchantmentToTag("mocurses:curseof_hordes", ModTags.Enchantments.WAND_AOE);

        addEnchantmentToTag("minecraft:protection", ModTags.Enchantments.WAND_ARMOR);
        addEnchantmentToTag("minecraft:breach", ModTags.Enchantments.WAND_ARMOR);
        addEnchantmentToTag("dungeonsenchantments:guarding_strike", ModTags.Enchantments.WAND_ARMOR);
        addEnchantmentToTag("enchantments_plus:enhancement", ModTags.Enchantments.WAND_ARMOR);
        addEnchantmentToTag("enchantments_plus:padding", ModTags.Enchantments.WAND_ARMOR);
        addEnchantmentToTag("ars_nouveau:mirror_shield", ModTags.Enchantments.WAND_ARMOR);

        addEnchantmentToTag("minecraft:thorns", ModTags.Enchantments.WAND_DAMAGE);
        addEnchantmentToTag("minecraft:sharpness", ModTags.Enchantments.WAND_DAMAGE);
        addEnchantmentToTag("minecraft:power", ModTags.Enchantments.WAND_DAMAGE);
        addEnchantmentToTag("dungeonsenchantments:void_strike", ModTags.Enchantments.WAND_DAMAGE);
        addEnchantmentToTag("enchantments_plus:pain_power", ModTags.Enchantments.WAND_DAMAGE);
        addEnchantmentToTag("enchantments_plus:spikes", ModTags.Enchantments.WAND_DAMAGE);
        addEnchantmentToTag("mocurses:curseof_disorder", ModTags.Enchantments.WAND_DAMAGE);
        addEnchantmentToTag("mocurses:curseof_deterioration", ModTags.Enchantments.WAND_DAMAGE);
        addEnchantmentToTag("mocurses:curseof_betrayal", ModTags.Enchantments.WAND_DAMAGE);

        addEnchantmentToTag("minecraft:lure", ModTags.Enchantments.WAND_LURE);
        addEnchantmentToTag("minecraft:loyalty", ModTags.Enchantments.WAND_LURE);
        addEnchantmentToTag("soulbound:soulbound", ModTags.Enchantments.WAND_LURE);
        addEnchantmentToTag("mocurses:curseof_voiding", ModTags.Enchantments.WAND_LURE);
        addEnchantmentToTag("ars_nouveau:soulbound", ModTags.Enchantments.WAND_LURE);
        addEnchantmentToTag("alexsmobs:board_return", ModTags.Enchantments.WAND_LURE);

        addEnchantmentToTag("minecraft:soul_speed", ModTags.Enchantments.WAND_RANGE);
        addEnchantmentToTag("minecraft:swift_sneak", ModTags.Enchantments.WAND_RANGE);
        addEnchantmentToTag("minecraft:projectile_protection", ModTags.Enchantments.WAND_RANGE);
        addEnchantmentToTag("minecraft:piercing", ModTags.Enchantments.WAND_RANGE);
        addEnchantmentToTag("minecraft:riptide", ModTags.Enchantments.WAND_RANGE);
        addEnchantmentToTag("speed_enchantment:speed", ModTags.Enchantments.WAND_RANGE);
        addEnchantmentToTag("magiccombatwands:magic_wind", ModTags.Enchantments.WAND_RANGE);
        addEnchantmentToTag("magiccombatwands:skillful", ModTags.Enchantments.WAND_RANGE);
        addEnchantmentToTag("dungeonsenchantments:ambush", ModTags.Enchantments.WAND_RANGE);
        addEnchantmentToTag("dungeonsenchantments:rush", ModTags.Enchantments.WAND_RANGE);
        addEnchantmentToTag("enchantments_plus:acceleration", ModTags.Enchantments.WAND_RANGE);
        addEnchantmentToTag("enchantments_plus:reach", ModTags.Enchantments.WAND_RANGE);
        addEnchantmentToTag("enchantments_plus:fleetfoot", ModTags.Enchantments.WAND_RANGE);
        addEnchantmentToTag("mocurses:curseof_notice", ModTags.Enchantments.WAND_RANGE);
        addEnchantmentToTag("mocurses:curseof_station", ModTags.Enchantments.WAND_RANGE);
        addEnchantmentToTag("mocurses:curseof_teleportation", ModTags.Enchantments.WAND_RANGE);
        addEnchantmentToTag("mocurses:curseof_movement", ModTags.Enchantments.WAND_RANGE);
        addEnchantmentToTag("finsandtails:fluked_edge", ModTags.Enchantments.WAND_RANGE);

        addEnchantmentToTag("minecraft:smite", ModTags.Enchantments.WAND_SMITE);
        addEnchantmentToTag("dungeonsenchantments:illagers_bane", ModTags.Enchantments.WAND_SMITE);
        addEnchantmentToTag("dungeonsenchantments:weakening", ModTags.Enchantments.WAND_SMITE);
        addEnchantmentToTag("enchantments_plus:sensing", ModTags.Enchantments.WAND_SMITE);
        addEnchantmentToTag("enchantments_plus:oath_of_the_nose", ModTags.Enchantments.WAND_SMITE);
        addEnchantmentToTag("mocurses:curseof_withering", ModTags.Enchantments.WAND_SMITE);

        addEnchantmentToTag("minecraft:bane_of_arthropods", ModTags.Enchantments.WAND_SPIDER);
        addEnchantmentToTag("enchantments_plus:poison_cloud", ModTags.Enchantments.WAND_SPIDER);

        addEnchantmentToTag("minecraft:vanishing_curse", ModTags.Enchantments.WAND_THWACK);
        addEnchantmentToTag("enchantments_plus:execution", ModTags.Enchantments.WAND_THWACK);

        addEnchantmentToTag("minecraft:depth_strider", ModTags.Enchantments.WATER);
        addEnchantmentToTag("minecraft:aqua_affinity", ModTags.Enchantments.WATER);
        addEnchantmentToTag("minecraft:respiration", ModTags.Enchantments.WATER);
        addEnchantmentToTag("minecraft:impaling", ModTags.Enchantments.WATER);
        addEnchantmentToTag("enchantments_plus:wave", ModTags.Enchantments.WATER);
        addEnchantmentToTag("enchantments_plus:anti_water_bane", ModTags.Enchantments.WATER);
        addEnchantmentToTag("mocurses:curseof_apnea", ModTags.Enchantments.WATER);

        //Apotheosis
        addEnchantmentToTag("apotheosis:bane_of_illagers", ModTags.Enchantments.WAND_SMITE);
        addEnchantmentToTag("apotheosis:bane_of_illagers", ModTags.Enchantments.TOME_DEBUFF);
        addEnchantmentToTag("apotheosis:berserkers_fury", ModTags.Enchantments.WAND_DAMAGE);
        addEnchantmentToTag("apotheosis:berserkers_fury", ModTags.Enchantments.TOME_AOE);
        addEnchantmentToTag("apotheosis:capturing", ModTags.Enchantments.LUCK);
        addEnchantmentToTag("apotheosis:chainsaw", ModTags.Enchantments.COOLDOWN_REDUCE);
        addEnchantmentToTag("apotheosis:chromatic", ModTags.Enchantments.LUCK);
        addEnchantmentToTag("apotheosis:crescendo", ModTags.Enchantments.MULTISHOT);
        addEnchantmentToTag("apotheosis:earths_boon", ModTags.Enchantments.LUCK);
        addEnchantmentToTag("apotheosis:endless_quiver", ModTags.Enchantments.MULTISHOT);
        addEnchantmentToTag("apotheosis:exploitation", ModTags.Enchantments.LUCK);
        addEnchantmentToTag("apotheosis:growth_serum", ModTags.Enchantments.LUCK);
        addEnchantmentToTag("apotheosis:icy_thorns", ModTags.Enchantments.FREEZE);
        addEnchantmentToTag("apotheosis:infusion", ModTags.Enchantments.COOLDOWN_REDUCE);
        addEnchantmentToTag("apotheosis:knowledge", ModTags.Enchantments.LUCK);
        addEnchantmentToTag("apotheosis:life_mending", ModTags.Enchantments.HEAL);
        addEnchantmentToTag("apotheosis:miners_fervor", ModTags.Enchantments.LUCK);
        addEnchantmentToTag("apotheosis:natures_blessing", ModTags.Enchantments.LUCK);
        addEnchantmentToTag("apotheosis:obliteration", ModTags.Enchantments.WAND_THWACK);
        addEnchantmentToTag("apotheosis:obliteration", ModTags.Enchantments.TOME_AOE);
        addEnchantmentToTag("apotheosis:rebounding", ModTags.Enchantments.KNOCKBACK);
        addEnchantmentToTag("apotheosis:reflective", ModTags.Enchantments.KNOCKBACK);
        addEnchantmentToTag("apotheosis:scavenger", ModTags.Enchantments.LUCK);
        addEnchantmentToTag("apotheosis:shield_bash", ModTags.Enchantments.KNOCKBACK);
        addEnchantmentToTag("apotheosis:spearfishing", ModTags.Enchantments.WAND_RANGE);
        addEnchantmentToTag("apotheosis:spearfishing", ModTags.Enchantments.TOME_DASH);
        addEnchantmentToTag("apotheosis:splitting", ModTags.Enchantments.MULTISHOT);
        addEnchantmentToTag("apotheosis:stable_footing", ModTags.Enchantments.LAUNCH);
        addEnchantmentToTag("apotheosis:tempting", ModTags.Enchantments.LUCK);

        //Majrusz's Enchantments
        addEnchantmentToTag("majruszsenchantments:death_wish", ModTags.Enchantments.WAND_DAMAGE);
        addEnchantmentToTag("majruszsenchantments:death_wish", ModTags.Enchantments.TOME_AOE);
        addEnchantmentToTag("majruszsenchantments:leech", ModTags.Enchantments.HEAL);
        addEnchantmentToTag("majruszsenchantments:misanthropy", ModTags.Enchantments.WAND_SMITE);
        addEnchantmentToTag("majruszsenchantments:misanthropy", ModTags.Enchantments.TOME_DEBUFF);
        addEnchantmentToTag("majruszsenchantments:telekinesis", ModTags.Enchantments.WAND_LURE);
        addEnchantmentToTag("majruszsenchantments:telekinesis", ModTags.Enchantments.TOME_PULL);
        addEnchantmentToTag("majruszsenchantments:hunter", ModTags.Enchantments.LUCK);
        addEnchantmentToTag("majruszsenchantments:gold_fueled", ModTags.Enchantments.COOLDOWN_REDUCE);
        addEnchantmentToTag("majruszsenchantments:harvester", ModTags.Enchantments.LUCK);
        addEnchantmentToTag("majruszsenchantments:smelter", ModTags.Enchantments.FIRE);
        addEnchantmentToTag("majruszsenchantments:fishing_fanatic", ModTags.Enchantments.WATER);
        addEnchantmentToTag("majruszsenchantments:dodge", ModTags.Enchantments.WAND_RANGE);
        addEnchantmentToTag("majruszsenchantments:dodge", ModTags.Enchantments.TOME_STEALTH);
        addEnchantmentToTag("majruszsenchantments:enlightenment", ModTags.Enchantments.LUCK);
        addEnchantmentToTag("majruszsenchantments:magic_protection", ModTags.Enchantments.WAND_ARMOR);
        addEnchantmentToTag("majruszsenchantments:magic_protection", ModTags.Enchantments.TOME_ARMOR);
        addEnchantmentToTag("majruszsenchantments:sixth_sense", ModTags.Enchantments.WAND_SMITE);
        addEnchantmentToTag("majruszsenchantments:sixth_sense", ModTags.Enchantments.TOME_DEBUFF);
        addEnchantmentToTag("majruszsenchantments:fuse_cutter", ModTags.Enchantments.WAND_AOE);
        addEnchantmentToTag("majruszsenchantments:fuse_cutter", ModTags.Enchantments.TOME_AOE);
        addEnchantmentToTag("majruszsenchantments:immortality", ModTags.Enchantments.HEAL);
        addEnchantmentToTag("majruszsenchantments:repulsion", ModTags.Enchantments.KNOCKBACK);
        addEnchantmentToTag("majruszsenchantments:horse_protection", ModTags.Enchantments.WAND_ARMOR);
        addEnchantmentToTag("majruszsenchantments:horse_protection", ModTags.Enchantments.TOME_ARMOR);
        addEnchantmentToTag("majruszsenchantments:horse_frost_walker", ModTags.Enchantments.FREEZE);
        addEnchantmentToTag("majruszsenchantments:horse_swiftness", ModTags.Enchantments.WAND_RANGE);
        addEnchantmentToTag("majruszsenchantments:horse_swiftness", ModTags.Enchantments.TOME_STEALTH);
        addEnchantmentToTag("majruszsenchantments:breaking_curse", ModTags.Enchantments.WAND_DAMAGE);
        addEnchantmentToTag("majruszsenchantments:breaking_curse", ModTags.Enchantments.TOME_AOE);
        addEnchantmentToTag("majruszsenchantments:corrosion_curse", ModTags.Enchantments.WAND_DAMAGE);
        addEnchantmentToTag("majruszsenchantments:corrosion_curse", ModTags.Enchantments.TOME_AOE);
        addEnchantmentToTag("majruszsenchantments:fatigue_curse", ModTags.Enchantments.FREEZE);
        addEnchantmentToTag("majruszsenchantments:incompatibility_curse", ModTags.Enchantments.WAND_SMITE);
        addEnchantmentToTag("majruszsenchantments:incompatibility_curse", ModTags.Enchantments.TOME_DEBUFF);
        addEnchantmentToTag("majruszsenchantments:slippery_curse", ModTags.Enchantments.WATER);
        addEnchantmentToTag("majruszsenchantments:vampirism_curse", ModTags.Enchantments.TOME_ARMOR);
        addEnchantmentToTag("majruszsenchantments:vampirism_curse", ModTags.Enchantments.WAND_ARMOR);

        //Incantationem
        addEnchantmentToTag("incantationem:water_slash", ModTags.Enchantments.WATER);
        addEnchantmentToTag("incantationem:venomous", ModTags.Enchantments.WAND_SPIDER);
        addEnchantmentToTag("incantationem:venomous", ModTags.Enchantments.TOME_DEBUFF);
        addEnchantmentToTag("incantationem:retreat", ModTags.Enchantments.WAND_RANGE);
        addEnchantmentToTag("incantationem:retreat", ModTags.Enchantments.TOME_STEALTH);
        addEnchantmentToTag("incantationem:reaping_rod", ModTags.Enchantments.WAND_THWACK);
        addEnchantmentToTag("incantationem:reaping_rod", ModTags.Enchantments.TOME_ARMOR);
        addEnchantmentToTag("incantationem:magnetic", ModTags.Enchantments.TOME_PULL);
        addEnchantmentToTag("incantationem:magnetic", ModTags.Enchantments.WAND_LURE);
        addEnchantmentToTag("incantationem:last_stand", ModTags.Enchantments.WAND_DAMAGE);
        addEnchantmentToTag("incantationem:last_stand", ModTags.Enchantments.TOME_AOE);
        addEnchantmentToTag("incantationem:fuse_shot", ModTags.Enchantments.WAND_AOE);
        addEnchantmentToTag("incantationem:fuse_shot", ModTags.Enchantments.TOME_AOE);
        addEnchantmentToTag("incantationem:forging_touch", ModTags.Enchantments.FIRE);
        addEnchantmentToTag("incantationem:deflection", ModTags.Enchantments.KNOCKBACK);
        addEnchantmentToTag("incantationem:decay", ModTags.Enchantments.WAND_DAMAGE);
        addEnchantmentToTag("incantationem:decay", ModTags.Enchantments.TOME_AOE);
        addEnchantmentToTag("incantationem:charmed", ModTags.Enchantments.LUCK);
        addEnchantmentToTag("incantationem:bunnys_hop", ModTags.Enchantments.LAUNCH);
        addEnchantmentToTag("incantationem:bane_of_the_swine", ModTags.Enchantments.WAND_SMITE);
        addEnchantmentToTag("incantationem:bane_of_the_swine", ModTags.Enchantments.TOME_DEBUFF);
        addEnchantmentToTag("incantationem:recklessness", ModTags.Enchantments.WAND_THWACK);
        addEnchantmentToTag("incantationem:recklessness", ModTags.Enchantments.TOME_STEALTH);
        addEnchantmentToTag("incantationem:shrieking", ModTags.Enchantments.TOME_AOE);
        addEnchantmentToTag("incantationem:shrieking", ModTags.Enchantments.WAND_AOE);
        addEnchantmentToTag("incantationem:thunder", ModTags.Enchantments.CHANNELING);
        addEnchantmentToTag("incantationem:tough_luck", ModTags.Enchantments.LUCK);

    }

    private void addEnchantmentToTag(String enchantmentId, TagKey<Enchantment> tag) {
        String[] parts = enchantmentId.split(":", 2);
        if (parts.length < 2) {
            throw new IllegalArgumentException("Invalid enchantment ID: " + enchantmentId);
        }

        ResourceLocation enchantmentLoc = new ResourceLocation(parts[0], parts[1]);
        tag(tag).addOptional(enchantmentLoc);
    }
}
