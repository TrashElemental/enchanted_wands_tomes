package net.trashelemental.enchanted_wands_tomes.util.event;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AnvilUpdateEvent;
import net.trashelemental.enchanted_wands_tomes.item.custom.TomeItem;
import net.trashelemental.enchanted_wands_tomes.item.custom.WandItem;

import java.util.Map;

@EventBusSubscriber
public class AnvilEventHandler {

    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {
        ItemStack leftStack = event.getLeft();
        ItemStack rightStack = event.getRight();
        Item leftItem = leftStack.getItem();
        Item rightItem = rightStack.getItem();

        if (leftItem instanceof WandItem leftWand) {

            int maxWandEnchantmentsLeft = leftWand.getMaxEnchantments(leftStack);
            ItemEnchantments enchantmentsLeft = leftStack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
            ItemEnchantments enchantmentsRight = rightStack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);

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
            ItemEnchantments enchantmentsLeft = leftStack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
            ItemEnchantments enchantmentsRight = rightStack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);

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
