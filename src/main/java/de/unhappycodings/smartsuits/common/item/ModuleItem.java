package de.unhappycodings.smartsuits.common.item;

import de.unhappycodings.smartsuits.SmartSuits;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ModuleItem extends Item {

    public ModuleItem() {
        super(new Properties().tab(SmartSuits.creativeTab).stacksTo(1));
    }

}
