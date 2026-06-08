package com.gorkem.mcmodmask;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public final class MaskItemHelper {
    private static final Set<Item> NAMETAG_MASK_ITEMS = createNametagMaskItems();

    private MaskItemHelper() {
    }

    public static boolean isMask(ItemStack stack) {
        return !stack.isEmpty() && NAMETAG_MASK_ITEMS.contains(stack.getItem());
    }

    private static Set<Item> createNametagMaskItems() {
        Set<Item> items = new HashSet<Item>();
        items.add(ModItems.CUSTOM_MASK);

        // TODO: Yeni maske/kask esyasi eklediginizde, nametag ve chat ozelligini acmak icin
        // TODO: o item'i burada items.add(ModItems.YENI_MASKENIZ); seklinde listeye ekleyin.
        // TODO: Sadece HEAD slotuna takilabilen ItemArmor esyalarini eklemek render ve isim hatalarini azaltir.

        return Collections.unmodifiableSet(items);
    }
}
