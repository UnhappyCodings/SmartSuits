package de.unhappycodings.smartsuits.common.enums;

import de.unhappycodings.smartsuits.common.registration.ModItems;
import net.minecraft.world.item.Item;

public enum SuitTypeItemEnum {
    HELMET(ModItems.SMART_SUIT_HELMET.get()),
    CHESTPLATE(ModItems.SMART_SUIT_CHESTPLATE.get()),
    LEGGINGS(ModItems.SMART_SUIT_LEGGINGS.get()),
    BOOTS(ModItems.SMART_SUIT_BOOTS.get());

    public final Item item;

    SuitTypeItemEnum(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}
