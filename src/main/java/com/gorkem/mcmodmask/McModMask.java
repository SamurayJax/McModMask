package com.gorkem.mcmodmask;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = McModMask.MODID, name = McModMask.NAME, version = McModMask.VERSION)
public final class McModMask {
    public static final String MODID = "mcmodmask";
    public static final String NAME = "McModMask";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("{} initialized.", NAME);
    }
}
