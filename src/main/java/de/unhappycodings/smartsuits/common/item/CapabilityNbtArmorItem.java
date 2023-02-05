package de.unhappycodings.smartsuits.common.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiFunction;

public class CapabilityNbtArmorItem extends ArmorItem {
    private final int upgradeSlotCount;
    protected final BiFunction<ItemStack, CompoundTag, ICapabilityProvider> cap;

    public CapabilityNbtArmorItem(BiFunction<ItemStack, CompoundTag, ICapabilityProvider> capability, ArmorMaterial pMaterial, EquipmentSlot pSlot, Item.Properties pProperties, int upgradeSlotCount) {
        super(pMaterial, pSlot, pProperties);
        this.cap = capability;
        this.upgradeSlotCount = upgradeSlotCount;
    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundTag nbt) {
        return cap.apply(stack, nbt);
    }

    public int getUpgradeSlotCount() {
        return upgradeSlotCount;
    }

}
