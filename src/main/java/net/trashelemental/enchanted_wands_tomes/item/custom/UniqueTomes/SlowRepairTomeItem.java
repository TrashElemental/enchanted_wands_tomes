package net.trashelemental.enchanted_wands_tomes.item.custom.UniqueTomes;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.trashelemental.enchanted_wands_tomes.item.custom.TomeItem;

public class SlowRepairTomeItem extends TomeItem {
    public SlowRepairTomeItem(Properties properties, int baseCooldown, int enchantmentValue, int maxEnchantments) {
        super(properties, baseCooldown, enchantmentValue, maxEnchantments);
    }

    private static final int repairTime = 300;
    private int ticksSinceRepair = 0;

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
