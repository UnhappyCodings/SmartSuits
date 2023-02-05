package de.unhappycodings.smartsuits.common.container.capability;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class SmartSuitEditorCapabilityProvider implements ICapabilitySerializable<CompoundTag> {
    private final LazyOptional<IItemHandler> lazyItemHandler;
    private final ItemStackHandler inventory;

    public SmartSuitEditorCapabilityProvider(int basketSize) {
        this.inventory = new ItemStackHandler(basketSize);
        lazyItemHandler = LazyOptional.of(() -> new ItemStackHandler(basketSize));
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, @Nullable Direction side) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return lazyItemHandler.cast();
        }
        else return LazyOptional.empty();
    }

    // Farm out the serialization/deserialization to the capability
    @Override
    public CompoundTag serializeNBT() {
        return inventory.serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        inventory.deserializeNBT(nbt);
    }


}