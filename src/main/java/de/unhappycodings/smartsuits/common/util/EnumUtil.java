package de.unhappycodings.smartsuits.common.util;

import de.unhappycodings.smartsuits.common.enums.SuitTypeEnum;
import de.unhappycodings.smartsuits.common.enums.SuitTypeItemEnum;
import net.minecraft.world.entity.EquipmentSlot;

public class EnumUtil {

    public static SuitTypeItemEnum getItemEnum(SuitTypeEnum suitTypeEnum) {
        return switch (suitTypeEnum) {
            case HELMET -> SuitTypeItemEnum.HELMET;
            case CHESTPLATE -> SuitTypeItemEnum.CHESTPLATE;
            case LEGGINGS -> SuitTypeItemEnum.LEGGINGS;
            case BOOTS -> SuitTypeItemEnum.BOOTS;
        };
    }

    public static EquipmentSlot getEquipSlot(SuitTypeItemEnum suitTypeItemEnum) {
        return switch (suitTypeItemEnum) {
            case HELMET -> EquipmentSlot.HEAD;
            case CHESTPLATE -> EquipmentSlot.CHEST;
            case LEGGINGS -> EquipmentSlot.LEGS;
            case BOOTS -> EquipmentSlot.FEET;
        };
    }

}
