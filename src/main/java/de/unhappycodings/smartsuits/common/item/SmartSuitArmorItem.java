package de.unhappycodings.smartsuits.common.item;

import de.unhappycodings.smartsuits.common.container.capability.SmartSuitEditorCapabilityProvider;
import de.unhappycodings.smartsuits.common.container.capability.SmartSuitEditorItemStackHandler;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
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

public class SmartSuitArmorItem extends ArmorItem {
    private final int upgradeSlotCount;
    private final LazyOptional<EnergyStorage> lazyEnergyHandler = LazyOptional.empty();
    public NonNullList<ItemStack> items;

    public SmartSuitArmorItem(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties, int upgradeSlotCount) {
        super(pMaterial, pSlot, pProperties);
        this.upgradeSlotCount = upgradeSlotCount;
    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return new SmartSuitEditorCapabilityProvider(3);
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
