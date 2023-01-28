package de.unhappycodings.smartsuits.common.container.capability;

import net.minecraftforge.items.ItemStackHandler;

public class SmartSuitEditorItemStackHandler extends ItemStackHandler {
    private final int size;

    public SmartSuitEditorItemStackHandler(int size) {
        super(size);
        this.size = size;
    }

    @Override
    public int getSlots() {
        return size;
    }
}
