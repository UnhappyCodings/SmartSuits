package de.unhappycodings.smartsuits.common.item;

import de.unhappycodings.smartsuits.common.container.capability.SmartSuitEditorCapabilityProvider;
import de.unhappycodings.smartsuits.common.container.capability.SmartSuitEditorItemStackHandler;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.items.*;
import net.minecraftforge.items.wrapper.EntityEquipmentInvWrapper;
import net.minecraftforge.items.wrapper.InvWrapper;
import net.minecraftforge.items.wrapper.RangedWrapper;
import net.minecraftforge.items.wrapper.SidedInvWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SmartSuitArmorItem extends CapabilityNbtArmorItem {

    public SmartSuitArmorItem(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties, int upgradeSlotCount) {
        super((stack, tag) -> {
            return new ICapabilityProvider() {
                @Override
                public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
                    return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.orEmpty(cap, LazyOptional.of(() -> new ItemStackHandler(upgradeSlotCount)));
                }
            };
        }, pMaterial, pSlot, pProperties, upgradeSlotCount);
    }

    @Nullable
    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_NETHERITE;
    }
}
