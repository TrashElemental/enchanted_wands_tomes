package net.trashelemental.junkyard_lib;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
* Allows you to queue an event to happen in a number of ticks. Takes a tick delay and
 * then a supplier of the action. Example below.
 */

/*
  DelayedEventHandler.queueEvent(100, () -> {
      System.out.println("This runs after 100 ticks!");
  });
 */

@EventBusSubscriber
public class DelayedEventHandler {

    private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

    public static void queueEvent(int tickDelay, Runnable action) {
        workQueue.add(new AbstractMap.SimpleEntry<>(action, tickDelay));
    }

    @SubscribeEvent
    public static void onServerTick(ServerTickEvent.Post event) {
        List<AbstractMap.SimpleEntry<Runnable, Integer>> actionsToRun = new ArrayList<>();
        workQueue.forEach(work -> {
            work.setValue(work.getValue() - 1);
            if (work.getValue() <= 0) {
                actionsToRun.add(work);
            }
        });
        actionsToRun.forEach(work -> work.getKey().run());
        workQueue.removeAll(actionsToRun);
    }

}

