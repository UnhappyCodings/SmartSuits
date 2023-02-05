package de.unhappycodings.smartsuits.common.container.base.slot;

import de.unhappycodings.smartsuits.SmartSuits;
import de.unhappycodings.smartsuits.common.container.base.container.BaseContainer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class BaseSlot extends SlotItemHandler {
    public final Predicate<ItemStack> canPlace;
    public boolean isEnabled = true;

    public BaseSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition, Predicate<ItemStack> canPlace) {
        super(itemHandler, index, xPosition, yPosition);
        this.canPlace = canPlace;
    }

    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        this.setChanged();
        return canPlace.test(stack);
    }

    public void setActive(boolean enable) {
        this.isEnabled = enable;
    }

    @Override
    public boolean isActive() {
        return isEnabled;
    }

}
