package com.gorkem.mcmodmask;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.lwjgl.opengl.GL11;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = McModMask.MODID)
public final class MaskRenderHandler {
    private static final Set<Item> NAMETAG_MASK_ITEMS = createNametagMaskItems();

    private MaskRenderHandler() {
    }

    public static boolean isMask(ItemStack stack) {
        return !stack.isEmpty() && NAMETAG_MASK_ITEMS.contains(stack.getItem());
    }

    @SubscribeEvent
    public static void onRenderLivingSpecialsPre(RenderLivingEvent.Specials.Pre<EntityLivingBase> event) {
        EntityLivingBase entity = event.getEntity();
        if (!(entity instanceof EntityPlayer)) {
            return;
        }

        EntityPlayer player = (EntityPlayer) entity;

        ItemStack helmetStack = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);

        // Sunucu kuralimiz: Vanilla oyuncu isimleri hicbir senaryoda cizilmeyecek.
        // Maskesiz oyuncu tamamen isimsiz kalir; maskeli oyuncuya Faz 3'te ozel etiket cizilir.
        event.setCanceled(true);

        if (!isMask(helmetStack)) {
            return;
        }

        // Maskeli oyuncuda vanilla nametag iptal edildi. Sadece orste ozel isim basildiysa
        // Faz 3 render hook'una bilgi tasiyoruz; aksi halde ozel etiket de cizilmeyecek.
        if (helmetStack.hasDisplayName()) {
            renderCustomMaskName(player, helmetStack, helmetStack.getDisplayName(), event.getX(), event.getY(), event.getZ());
        }
    }

    private static void renderCustomMaskName(EntityPlayer player, ItemStack maskStack, String maskName, double x, double y, double z) {
        Minecraft minecraft = Minecraft.getMinecraft();
        FontRenderer fontRenderer = minecraft.fontRenderer;
        RenderManager renderManager = minecraft.getRenderManager();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();

        float yOffset = player.isSneaking() ? 1.7F : 2.0F;
        float scale = 0.025F;
        int textWidthHalf = fontRenderer.getStringWidth(maskName) / 2;

        GlStateManager.pushMatrix();
        try {
            GlStateManager.translate((float) x, (float) y + yOffset, (float) z);
            GL11.glNormal3f(0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(-renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
            GlStateManager.scale(-scale, -scale, scale);

            GlStateManager.disableLighting();
            GlStateManager.depthMask(false);
            GlStateManager.disableDepth();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(
                    GlStateManager.SourceFactor.SRC_ALPHA,
                    GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
                    GlStateManager.SourceFactor.ONE,
                    GlStateManager.DestFactor.ZERO
            );
            GlStateManager.disableTexture2D();

            buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_COLOR);
            buffer.pos(-textWidthHalf - 1, -1, 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
            buffer.pos(-textWidthHalf - 1, 8, 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
            buffer.pos(textWidthHalf + 1, 8, 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
            buffer.pos(textWidthHalf + 1, -1, 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
            tessellator.draw();

            GlStateManager.enableTexture2D();
            fontRenderer.drawString(maskName, -textWidthHalf, 0, 553648127);

            GlStateManager.enableDepth();
            GlStateManager.depthMask(true);
            fontRenderer.drawString(maskName, -textWidthHalf, 0, -1);
        } finally {
            GlStateManager.enableTexture2D();
            GlStateManager.enableDepth();
            GlStateManager.depthMask(true);
            GlStateManager.enableLighting();
            GlStateManager.disableBlend();
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.popMatrix();
        }
    }

    private static Set<Item> createNametagMaskItems() {
        Set<Item> items = new HashSet<Item>();
        items.add(ModItems.CUSTOM_MASK);
        items.add(Items.LEATHER_HELMET);

        // TODO: Test bittiginde vanilla deri kask destegini kapatmak icin ustteki
        // TODO: items.add(Items.LEATHER_HELMET); satirini silin veya yorum satirina alin.

        // TODO: Yeni maske/kask esyasi eklediginizde, nametag ozelligini acmak icin
        // TODO: o item'i burada items.add(ModItems.YENI_MASKENIZ); seklinde listeye ekleyin.
        // TODO: Sadece HEAD slotuna takilabilen ItemArmor esyalarini eklemek client render hatalarini azaltir.

        return Collections.unmodifiableSet(items);
    }
}
