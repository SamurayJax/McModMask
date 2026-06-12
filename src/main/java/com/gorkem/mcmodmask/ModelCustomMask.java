package com.gorkem.mcmodmask; // En üstte bu paket adı kalsın

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCustomMask extends ModelBiped {

    // ModItems veya zırh sınıflarının bu modeli çağırabilmesi için tekil örnek (Instance)
    public static final ModelCustomMask INSTANCE = new ModelCustomMask();

    public ModelCustomMask() {
        // Blockbench modelinin texture genişlik ve yükseklik ayarları (16x16)
        this.textureWidth = 16;
        this.textureHeight = 16;

        // --- BLOCKBENCH KÜPLERİNİN 1.12.2 SÜRÜMÜNE UYARLANMIŞ HALİ ---
        addBoxToHead(0, 2, 8.0F, -1.0F, -4.0F, 1, 1, 8, false);
        addBoxToHead(0, 2, 8.0F, -2.0F, -5.0F, 1, 1, 10, false);
        addBoxToHead(0, 2, 8.0F, -3.0F, -6.0F, 1, 1, 12, false);
        addBoxToHead(0, 2, 8.0F, -4.0F, -6.0F, 1, 1, 12, false);
        addBoxToHead(0, 2, 8.0F, -5.0F, -7.0F, 1, 1, 14, false);
        addBoxToHead(0, 1, 8.0F, -6.0F, -8.0F, 1, 1, 16, false);
        addBoxToHead(0, 4, 8.0F, -7.0F, -2.0F, 1, 1, 4, false);
        addBoxToHead(0, 4, 8.0F, -8.0F, -2.0F, 1, 1, 4, false);
        addBoxToHead(0, 4, 8.0F, -9.0F, -2.0F, 1, 1, 4, false);
        addBoxToHead(1, 0, 8.0F, -9.0F, -8.0F, 1, 3, 1, false);
        addBoxToHead(0, 2, 8.0F, -7.0F, -7.0F, 1, 1, 1, false);
        addBoxToHead(0, 2, 8.0F, -7.0F, -6.0F, 1, 1, 1, false);
        addBoxToHead(0, 2, 8.0F, -7.0F, 6.0F, 1, 1, 1, false);
        addBoxToHead(0, 2, 8.0F, -10.0F, 7.0F, 1, 1, 1, false);
        addBoxToHead(0, 2, 8.0F, -10.0F, -8.0F, 1, 1, 1, false);
        addBoxToHead(0, 2, 8.0F, -7.0F, 5.0F, 1, 1, 1, false);
        addBoxToHead(1, 0, 8.0F, -9.0F, 7.0F, 1, 3, 1, false);
        addBoxToHead(0, 2, 8.0F, -10.0F, -6.0F, 1, 1, 12, false);
        addBoxToHead(0, 1, 8.0F, -11.0F, -8.0F, 1, 1, 16, false);
        addBoxToHead(0, 1, 8.0F, -12.0F, -8.0F, 1, 1, 16, false);
        addBoxToHead(0, 1, 8.0F, -13.0F, -8.0F, 1, 1, 16, false);
        addBoxToHead(0, 1, 8.0F, -14.0F, -8.0F, 1, 1, 16, false);
        addBoxToHead(0, 1, 8.0F, -15.0F, -8.0F, 1, 1, 16, false);
        addBoxToHead(0, 2, 8.0F, -16.0F, -7.0F, 1, 1, 14, false);
        addBoxToHead(0, 2, 2.0F, -6.0F, -8.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -5.0F, -7.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -4.0F, -6.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -3.0F, -6.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -2.0F, -5.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -1.0F, -4.0F, 6, 1, 1, false);
        addBoxToHead(6, 0, 2.0F, -1.0F, -3.0F, 6, 1, 6, false);
        addBoxToHead(0, 0, 7.0F, -10.0F, -7.0F, 1, 5, 6, false);
        addBoxToHead(0, 0, 7.0F, -10.0F, 1.0F, 1, 5, 6, false);
        addBoxToHead(0, 2, 2.0F, -7.0F, -8.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -8.0F, -8.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -9.0F, -8.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -10.0F, -8.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -11.0F, -8.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -12.0F, -8.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -13.0F, -8.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -14.0F, -8.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -15.0F, -8.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -14.0F, 7.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -15.0F, 7.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -13.0F, 7.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -12.0F, 7.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -11.0F, 7.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -10.0F, 7.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -9.0F, 7.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -8.0F, 7.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -7.0F, 7.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -6.0F, 7.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -5.0F, 6.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -4.0F, 5.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -3.0F, 5.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -2.0F, 4.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -1.0F, 3.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -16.0F, -7.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -16.0F, -6.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -16.0F, -5.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -16.0F, -4.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -16.0F, -3.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -16.0F, -2.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -16.0F, -1.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -16.0F, 1.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -16.0F, 0.0F, 6, 1, 1, false);
        addBoxToHead(1, 6, 2.0F, -16.0F, 1.0F, 6, 1, 1, true); // Mirror aktif
        addBoxToHead(0, 2, 2.0F, -16.0F, 2.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -16.0F, 3.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -16.0F, 4.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -16.0F, 5.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 2.0F, -16.0F, 6.0F, 6, 1, 1, false);
        addBoxToHead(0, 2, 7.0F, -17.0F, -4.0F, 1, 1, 8, false);
        addBoxToHead(0, 2, 6.0F, -17.0F, -5.0F, 1, 1, 10, false);
        addBoxToHead(0, 2, 6.0F, -18.0F, -4.0F, 1, 1, 8, false);
        addBoxToHead(0, 2, 6.0F, -19.0F, -4.0F, 1, 1, 8, false);
        addBoxToHead(1, 0, 5.0F, -20.0F, 4.0F, 1, 3, 1, false);
        addBoxToHead(1, 0, 5.0F, -20.0F, -5.0F, 1, 3, 1, false);
        addBoxToHead(0, 5, 3.0F, -21.0F, 4.0F, 3, 5, 1, false);
        addBoxToHead(1, 0, 3.0F, -21.0F, -5.0F, 2, 5, 1, true); // Mirror aktif
        addBoxToHead(0, 6, 3.0F, -21.0F, -8.0F, 1, 6, 3, false);
        addBoxToHead(4, 6, 5.0F, -21.0F, 4.0F, 1, 1, 2, false);
        addBoxToHead(0, 2, 5.0F, -21.0F, -6.0F, 1, 1, 2, false);
        addBoxToHead(0, 2, 5.0F, -22.0F, 5.0F, 1, 1, 2, false);
        addBoxToHead(0, 2, 5.0F, -22.0F, -7.0F, 1, 1, 2, false);
        addBoxToHead(0, 2, 5.0F, -23.0F, -8.0F, 1, 1, 2, false);
        addBoxToHead(0, 2, 4.0F, -23.0F, -8.0F, 1, 1, 2, false);
        addBoxToHead(0, 2, 3.0F, -22.0F, -8.0F, 1, 1, 3, false);
        addBoxToHead(0, 2, 5.0F, -23.0F, 6.0F, 1, 1, 2, false);
        addBoxToHead(4, 6, 4.0F, -23.0F, 6.0F, 1, 1, 2, false);
        addBoxToHead(4, 6, 3.0F, -23.0F, 6.0F, 1, 1, 2, false);
        addBoxToHead(0, 8, 4.0F, -22.0F, 7.0F, 1, 7, 1, false);
        addBoxToHead(0, 0, 4.0F, -22.0F, 5.0F, 1, 7, 3, false);
        addBoxToHead(0, 0, 4.0F, -22.0F, -8.0F, 1, 7, 3, false);
        addBoxToHead(0, 10, 4.0F, -22.0F, -8.0F, 1, 7, 3, false);
        addBoxToHead(1, 0, 5.0F, -22.0F, 7.0F, 1, 7, 1, false);
        addBoxToHead(1, 0, 5.0F, -22.0F, -8.0F, 1, 7, 1, false);
        addBoxToHead(1, 0, 2.0F, -21.0F, 6.0F, 1, 5, 1, false);
        addBoxToHead(1, 0, 2.0F, -21.0F, -7.0F, 1, 5, 1, false);
        addBoxToHead(1, 0, 2.0F, -21.0F, 5.0F, 1, 5, 1, false);
        addBoxToHead(1, 0, 2.0F, -21.0F, -6.0F, 1, 5, 1, false);
        addBoxToHead(0, 10, 3.0F, -22.0F, 5.0F, 2, 7, 3, false);
        addBoxToHead(0, 8, 3.0F, -22.0F, 7.0F, 1, 7, 1, false);
    }

    /**
     * Küpleri dinamik olarak oluşturup ModelBiped'in kafa (bipedHead) yapısına bağlayan temiz yardımcı fonksiyon.
     * Bu sayede maske, oyuncunun kafasının tüm dönüş/eğilme animasyonlarını otomatik olarak miras alır.
     */
    private void addBoxToHead(int texX, int texY, float x, float y, float z, int width, int height, int depth, boolean mirror) {
        ModelRenderer box = new ModelRenderer(this, texX, texY);
        box.mirror = mirror;
        box.addBox(x, y, z, width, height, depth);
        this.bipedHead.addChild(box);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        // ModelBiped'in kafa rotasyonlarını kararlı çalıştırmak için ana animasyon fonksiyonunu çağırıyoruz
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
    }
}