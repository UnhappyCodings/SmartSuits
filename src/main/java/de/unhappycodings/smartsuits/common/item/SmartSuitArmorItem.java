package de.unhappycodings.smartsuits.common.item;

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
import net.minecraftforge.common.capabilities.Capability;
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

public class SmartSuitArmorItem extends ArmorItem implements Container {
    private final int upgradeSlotCount;
    public NonNullList<ItemStack> items;
    private LazyOptional<EnergyStorage> lazyEnergyHandler = LazyOptional.empty();
    private final LazyOptional<? extends IItemHandlerModifiable> itemHandler = LazyOptional.of(() -> new InvWrapper(this));
    private final LazyOptional<? extends CapabilityItemHandler> lazyItemHandler = LazyOptional.of(CapabilityItemHandler::new);

    public SmartSuitArmorItem(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties, int upgradeSlotCount) {
        super(pMaterial, pSlot, pProperties);
        items = NonNullList.withSize(upgradeSlotCount, ItemStack.EMPTY);
        this.upgradeSlotCount = upgradeSlotCount;
    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return new ICapabilityProvider() {
            @NotNull
            @Override
            public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
                if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
                    return itemHandler.cast();
                } else if (cap == CapabilityEnergy.ENERGY) {

                }
                return LazyOptional.empty();
            }
        };
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

    @Override
    public int getContainerSize() {
        return upgradeSlotCount;
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemStack : items) {
            if (itemStack.isEmpty()) return true;
        }
        return false;
    }

    @NotNull
    @Override
    public ItemStack getItem(int index) {
        if (index < 0 || index >= items.size()) {
            return ItemStack.EMPTY;
        }
        return items.get(index);
    }

    @NotNull
    @Override
    public ItemStack removeItem(int index, int count) {
        return ContainerHelper.removeItem(items, index, count);
    }

    @NotNull
    @Override
    public ItemStack removeItemNoUpdate(int index) {
        return ContainerHelper.takeItem(items, index);
    }

    @Override
    public void setItem(int index, ItemStack stack) {
        items.set(index, stack);
        if (stack.getCount() > getMaxStackSize()) {
            stack.setCount(getMaxStackSize());
        }
    }

    @Override
    public void setChanged() {

    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public void clearContent() {
        items.clear();
    }
}
