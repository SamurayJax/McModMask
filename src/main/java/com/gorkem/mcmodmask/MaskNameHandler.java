package com.gorkem.mcmodmask;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = McModMask.MODID)
public final class MaskNameHandler {
    private MaskNameHandler() {
    }

    @SubscribeEvent
    public static void onPlayerNameFormat(PlayerEvent.NameFormat event) {
        EntityPlayer player = event.getEntityPlayer();
        if (player == null) {
            return;
        }

        ItemStack helmetStack = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
        if (MaskItemHelper.isMask(helmetStack) && helmetStack.hasDisplayName()) {
            // Orsteki renk kodlari bozulmadan korunur; Minecraft chat renderer'i bu kodlari kendisi yorumlar.
            event.setDisplayname(helmetStack.getDisplayName());
        }
    }
}
