package de.unhappycodings.smartsuits.common.container;

import de.unhappycodings.smartsuits.common.container.base.container.BaseContainer;
import de.unhappycodings.smartsuits.common.container.base.slot.BaseSlot;
import de.unhappycodings.smartsuits.common.registration.ModContainerTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.CapabilityItemHandler;
import org.jetbrains.annotations.NotNull;

public class SmartSuitEditorContainer extends BaseContainer {

    public SmartSuitEditorContainer(int id, Inventory inventory, Level level, int containerSize) {
        super(ModContainerTypes.SMART_SUIT_EDITOR_CONTAINER.get(), id, inventory, level, containerSize);
        layoutPlayerInventorySlots(8, 162);

        player.getItemBySlot(EquipmentSlot.HEAD).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> {
            BaseSlot helmetModule1 = new BaseSlot(this, handler, inventory, 0, 0, 0, (stack) -> stack.is(Items.STICK));
            BaseSlot helmetModule2 = new BaseSlot(this, handler, inventory, 0, 0, 0, (stack) -> stack.is(Items.STICK));
            BaseSlot helmetModule3 = new BaseSlot(this, handler, inventory, 0, 0, 0, (stack) -> stack.is(Items.STICK));

            addSlot(helmetModule1); //Output
        });

        //BaseSlot helmetUpgrade1 = new BaseSlot(this, handler, inventory, 0, 143, 56);

        //addSlot(new BaseSlot(this, handler, inventory, 0, 143, 56)); //Output

    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player playerIn, int index) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(@NotNull Player playerIn) {
        return true;
    }
}
