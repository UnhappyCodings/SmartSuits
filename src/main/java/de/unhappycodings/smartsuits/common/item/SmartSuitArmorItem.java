package de.unhappycodings.smartsuits.common.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class SmartSuitArmorItem extends ArmorItem {

    public SmartSuitArmorItem(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public int getDefense() {
        return super.getDefense();
    }

    @Override
    public int getEnchantmentValue() {
        return super.getEnchantmentValue();
    }

    @Override
    public int getItemEnchantability(ItemStack stack) {
        return 0;
    }

    @Override
    public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
        return true;
    }

    @Override
    public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
        return true;
    }
}
