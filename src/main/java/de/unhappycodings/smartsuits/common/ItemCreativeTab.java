package de.unhappycodings.smartsuits.common;

import de.unhappycodings.smartsuits.SmartSuits;
import de.unhappycodings.smartsuits.common.registration.ModItems;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

public class ItemCreativeTab extends CreativeModeTab {

    public ItemCreativeTab() {
        super(SmartSuits.MOD_ID + ".items");
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(ModItems.SMART_SUIT_CHESTPLATE.get());
    }

    @Override
    public void fillItemList(@NotNull NonNullList<ItemStack> items) {
        int index = 0;

        ArrayList<Item> blockList = new ArrayList<>();
        Collections.addAll(blockList, ModItems.SMART_CRYSTAL.get(), ModItems.INTEGRATING_CIRCUIT.get(), ModItems.ARMOR_PLATING.get(), ModItems.SMART_SUIT_HELMET_PLATING.get(),
                ModItems.SMART_SUIT_CHESTPLATE_PLATING.get(), ModItems.SMART_SUIT_LEGGINGS_PLATING.get(), ModItems.SMART_SUIT_BOOTS_PLATING.get(),
                ModItems.SMART_SUIT_HELMET.get(), ModItems.SMART_SUIT_CHESTPLATE.get(), ModItems.SMART_SUIT_LEGGINGS.get(), ModItems.SMART_SUIT_BOOTS.get());

        for (Item i : blockList) {
            items.add(index, new ItemStack(i));
            index++;
        }
    }

}
