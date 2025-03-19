package net.trashelemental.enchanted_wands_tomes.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.trashelemental.enchanted_wands_tomes.EnchantedWandsTomes;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, EnchantedWandsTomes.MOD_ID);
    }


    @Override
    protected void start() {


    }
}
