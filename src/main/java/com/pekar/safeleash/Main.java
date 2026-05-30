package com.pekar.safeleash;

import com.mojang.logging.LogUtils;
import com.pekar.safeleash.events.EventRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import org.slf4j.Logger;

public class Main implements ModInitializer
{
    public static final String MODID = "safeleash";
    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize()
    {
        EventRegistry.registerEvents();
        ServerLifecycleEvents.SERVER_STARTING.register(server -> LOGGER.debug("Initializing {}", MODID));
    }
}
