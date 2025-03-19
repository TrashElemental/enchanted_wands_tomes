package net.trashelemental.enchanted_wands_tomes.item.custom.UniqueWands;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.trashelemental.enchanted_wands_tomes.item.custom.WandItem;

public class SlowRepairWandItem extends WandItem {
    private static final int repairTime = 300;
    private int ticksSinceRepair = 0;

    public SlowRepairWandItem(Properties properties, int baseDamage, int baseCooldown, int maxEnchantments, int enchantmentValue) {
        super(properties, baseDamage, baseCooldown, maxEnchantments, enchantmentValue);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);

        int currentDamage = stack.getDamageValue();
        int maxDamage = stack.getMaxDamage();

        if (currentDamage > 0 && currentDamage < maxDamage) {
            if (ticksSinceRepair >= repairTime) {
                stack.setDamageValue(currentDamage - 2);
                ticksSinceRepair = 0;
            } else {
                ticksSinceRepair++;
            }
        }
    }
}
