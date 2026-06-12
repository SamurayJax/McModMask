package com.gorkem.mcmodmask;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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

        @Override
        @SideOnly(Side.CLIENT)
        public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
            if (armorSlot == EntityEquipmentSlot.HEAD) {
                // Başındaki yorum satırı işaretlerini (//) kaldırdık, artık modelimiz aktif!
                return ModelCustomMask.INSTANCE;
            }
            return null;
        }

        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
            // Maskenin kafadaki 2D/3D kaplamasının okunacağı PNG dosyası yolu
            return McModMask.MODID + ":textures/models/armor/custom_mask_texture.png";
        }
    }
}