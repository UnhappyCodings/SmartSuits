package de.unhappycodings.smartsuits.common.item;

import de.unhappycodings.smartsuits.SmartSuits;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class HammerItem extends Item {

    public HammerItem() {
        super(new Item.Properties().defaultDurability(238).setNoRepair().tab(SmartSuits.creativeTab));
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack itemStack1 = itemStack.copy();
        if (!itemStack1.hurt(1, SmartSuits.RANDOM, null))
            return itemStack1;
        return ItemStack.EMPTY;
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
            return true;
        }


}
