package net.trashelemental.enchanted_wands_tomes.util.event;

import net.minecraft.network.chat.Component;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trashelemental.enchanted_wands_tomes.item.custom.TomeItem;
import net.trashelemental.enchanted_wands_tomes.item.custom.WandItem;

import java.util.List;

@Mod.EventBusSubscriber
public class TooltipHandler {

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {

        if (event.getItemStack().getItem() instanceof WandItem || event.getItemStack().getItem() instanceof TomeItem) {
            List<Component> tooltips = event.getToolTip();

            tooltips.removeIf(tooltip -> tooltip.getContents().toString().contains("attribute"));
            tooltips.removeIf(tooltip -> tooltip.getContents().toString().contains("item.modifiers"));

        }

    }
}
