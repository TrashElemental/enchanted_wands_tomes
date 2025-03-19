package net.trashelemental.enchanted_wands_tomes.util.event;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trashelemental.enchanted_wands_tomes.item.custom.TomeItem;
import net.trashelemental.enchanted_wands_tomes.item.custom.WandItem;

import java.util.Map;

@Mod.EventBusSubscriber
public class AnvilEventHandler {

    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {
        ItemStack leftStack = event.getLeft();
        ItemStack rightStack = event.getRight();
        Item leftItem = leftStack.getItem();
        Item rightItem = rightStack.getItem();

        if (leftItem instanceof WandItem leftWand) {

            int maxWandEnchantmentsLeft = leftWand.getMaxEnchantments(leftStack);
            Map<Enchantment, Integer> enchantmentsLeft = EnchantmentHelper.getEnchantments(leftStack);
            Map<Enchantment, Integer> enchantmentsRight = EnchantmentHelper.getEnchantments(rightStack);

            if (enchantmentsLeft.size() >= maxWandEnchantmentsLeft && rightStack.is(Items.ENCHANTED_BOOK)) {
                event.setCanceled(true);
                return;
            }

            if (rightItem instanceof WandItem rightWand) {
                int maxWandEnchantmentsRight = rightWand.getMaxEnchantments(rightStack);
                if (enchantmentsRight.size() >= maxWandEnchantmentsRight) {
                    event.setCanceled(true);
                }

                int combinedEnchantments = enchantmentsLeft.size() + enchantmentsRight.size();
                int maxEnchantmentsForOutput = leftWand.getMaxEnchantments(leftStack);

                if (combinedEnchantments > maxEnchantmentsForOutput) {
                    event.setCanceled(true);
                }
            }
        }


        if (leftItem instanceof TomeItem leftTome) {

            int maxWandEnchantmentsLeft = leftTome.getMaxEnchantments(leftStack);
            Map<Enchantment, Integer> enchantmentsLeft = EnchantmentHelper.getEnchantments(leftStack);
            Map<Enchantment, Integer> enchantmentsRight = EnchantmentHelper.getEnchantments(rightStack);

            if (enchantmentsLeft.size() >= maxWandEnchantmentsLeft && rightStack.is(Items.ENCHANTED_BOOK)) {
                event.setCanceled(true);
                return;
            }

            if (rightItem instanceof TomeItem rightTome) {
                int maxWandEnchantmentsRight = rightTome.getMaxEnchantments(rightStack);
                if (enchantmentsRight.size() >= maxWandEnchantmentsRight) {
                    event.setCanceled(true);
                }

                int combinedEnchantments = enchantmentsLeft.size() + enchantmentsRight.size();
                int maxEnchantmentsForOutput = leftTome.getMaxEnchantments(leftStack);

                if (combinedEnchantments > maxEnchantmentsForOutput) {
                    event.setCanceled(true);
                }
            }
        }

    }


}
