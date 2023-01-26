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
    public final BaseContainer container;
    public final Inventory inventory;
    public final Predicate<ItemStack> canPlace;
    public boolean isEnabled = true;

    public BaseSlot(BaseContainer container, IItemHandler itemHandler, Inventory inventory, int index, int xPosition, int yPosition, Predicate<ItemStack> canPlace) {
        super(itemHandler, index, xPosition, yPosition);
        this.inventory = inventory;
        this.canPlace = canPlace;
        this.container = container;
    }

    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        this.setChanged();
        return canPlace.test(stack);
    }

    public void setEnabled(boolean enable) {
        this.isEnabled = enable;
    }

    @Override
    public boolean isActive() {
        return isEnabled;
    }

    @Override
    public void setChanged() {
        if (inventory != null) inventory.setChanged();
    }

}
