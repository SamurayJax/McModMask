package com.gorkem.mcmodmask;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = McModMask.MODID)
public final class ClientModelHandler {
    private ClientModelHandler() {
    }

    @SubscribeEvent
    public static void onModelRegistry(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(
                ModItems.CUSTOM_MASK,
                0,
                new ModelResourceLocation(McModMask.MODID + ":custom_mask", "inventory")
        );
    }
}
