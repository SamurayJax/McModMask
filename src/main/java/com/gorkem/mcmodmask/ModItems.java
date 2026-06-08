package com.gorkem.mcmodmask;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = McModMask.MODID)
public final class ModItems {
    public static final ItemArmor.ArmorMaterial CUSTOM_MASK_MATERIAL = EnumHelper.addArmorMaterial(
            McModMask.MODID + ":custom_mask",
            McModMask.MODID + ":custom_mask",
            5,
            new int[] {1, 2, 3, 1},
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0F
    );

    public static final Item CUSTOM_MASK = new ItemCustomMask();

    private ModItems() {
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(CUSTOM_MASK);
    }

    private static final class ItemCustomMask extends ItemArmor {
        private ItemCustomMask() {
            super(CUSTOM_MASK_MATERIAL, 0, EntityEquipmentSlot.HEAD);
            setRegistryName(McModMask.MODID, "custom_mask");
            setUnlocalizedName(McModMask.MODID + ".custom_mask");
            setMaxStackSize(1);
        }
    }
}
