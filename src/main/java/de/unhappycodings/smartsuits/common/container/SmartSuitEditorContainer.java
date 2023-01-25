package de.unhappycodings.smartsuits.common.container;

import de.unhappycodings.smartsuits.common.container.base.container.BaseContainer;
import de.unhappycodings.smartsuits.common.container.base.slot.BaseSlot;
import de.unhappycodings.smartsuits.common.registration.ModContainerTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SmartSuitEditorContainer extends BaseContainer {

    public SmartSuitEditorContainer(int id, Inventory inventory, BlockPos pos, Level level, int containerSize) {
        super(ModContainerTypes.SMART_SUIT_EDITOR_CONTAINER.get(), id, inventory, pos, level, containerSize);
        layoutPlayerInventorySlots(8, 127);

        //addSlot(new BaseSlot(this, handler, inventory, 0, 143, 56)); //Output

    }

    @Override
    public boolean stillValid(@NotNull Player playerIn) {
        return true;
    }
}
