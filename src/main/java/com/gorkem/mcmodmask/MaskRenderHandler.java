package com.gorkem.mcmodmask;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.lwjgl.opengl.GL11;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = McModMask.MODID)
public final class MaskRenderHandler {
    private static final double MAX_NAME_RENDER_DISTANCE_SQ = 32.0D * 32.0D;
    private static final Frustum NAME_FRUSTUM = new Frustum();

    private MaskRenderHandler() {
    }

    public static boolean isMask(ItemStack stack) {
        return MaskItemHelper.isMask(stack);
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
        Entity cameraEntity = minecraft.getRenderViewEntity();
        if (cameraEntity == null || player.getDistanceSq(cameraEntity) > MAX_NAME_RENDER_DISTANCE_SQ) {
            return;
        }

        FontRenderer fontRenderer = minecraft.fontRenderer;
        RenderManager renderManager = minecraft.getRenderManager();
        NAME_FRUSTUM.setPosition(renderManager.viewerPosX, renderManager.viewerPosY, renderManager.viewerPosZ);
        if (!NAME_FRUSTUM.isBoundingBoxInFrustum(player.getEntityBoundingBox())) {
            return;
        }

        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();

        float yOffset = player.isSneaking() ? 2.1F : 2.4F;
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
            // Renk kodlari (section sign + 6, section sign + c vb.) FontRenderer tarafindan dogrudan yorumlanir.
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
}
