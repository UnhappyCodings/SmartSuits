package de.unhappycodings.smartsuits.common.container;

import de.unhappycodings.smartsuits.client.config.ClientConfig;
import de.unhappycodings.smartsuits.common.container.base.container.BaseContainer;
import de.unhappycodings.smartsuits.common.container.base.slot.BaseSlot;
import de.unhappycodings.smartsuits.common.enums.SuitTypeItemEnum;
import de.unhappycodings.smartsuits.common.item.ModuleItem;
import de.unhappycodings.smartsuits.common.registration.ModContainerTypes;
import de.unhappycodings.smartsuits.common.registration.ModItems;
import de.unhappycodings.smartsuits.common.registration.Registration;
import de.unhappycodings.smartsuits.common.util.EnumUtil;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Container;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SmartSuitEditorContainer extends BaseContainer {
    private static BaseSlot helmetModule1;
    private static BaseSlot helmetModule2;
    private static BaseSlot helmetModule3;
    private static BaseSlot chestplateModule1;
    private static BaseSlot chestplateModule2;
    private static BaseSlot chestplateModule3;
    private static BaseSlot chestplateModule4;
    private static BaseSlot leggingsModule1;
    private static BaseSlot leggingsModule2;
    private static BaseSlot leggingsModule3;
    private static BaseSlot bootsModule1;
    private static BaseSlot bootsModule2;
    private static BaseSlot bootsModule3;

    private static BaseSlot[] allModuleSlots;
    private static boolean changed;

    private SuitTypeItemEnum selection;

    public SmartSuitEditorContainer(int id, Inventory inventory, Level level, int containerSize) {
        super(ModContainerTypes.SMART_SUIT_EDITOR_CONTAINER.get(), id, inventory, level, containerSize);
        layoutPlayerInventorySlots(8, 162);

        player.getItemBySlot(EquipmentSlot.HEAD).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> {
            helmetModule1 = new BaseSlot(handler, 0, 61, 72, stack -> stack.getItem() instanceof ModuleItem);
            helmetModule2 = new BaseSlot(handler, 1, 81, 57, stack -> stack.getItem() instanceof ModuleItem);
            helmetModule3 = new BaseSlot(handler, 2, 101, 72, stack -> stack.getItem() instanceof ModuleItem);
            addSlot(helmetModule1);
            addSlot(helmetModule2);
            addSlot(helmetModule3);
        });
        player.getItemBySlot(EquipmentSlot.CHEST).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> {
            chestplateModule1 = new BaseSlot(handler, 0, 60, 55, stack -> stack.getItem() instanceof ModuleItem);
            chestplateModule2 = new BaseSlot(handler, 1, 103, 55, stack -> stack.getItem() instanceof ModuleItem);
            chestplateModule3 = new BaseSlot(handler, 2, 81, 75, stack -> stack.getItem() instanceof ModuleItem);
            chestplateModule4 = new BaseSlot(handler, 3, 81, 96, stack -> stack.getItem() instanceof ModuleItem);
            addSlot(chestplateModule1);
            addSlot(chestplateModule2);
            addSlot(chestplateModule3);
            addSlot(chestplateModule4);
        });
        player.getItemBySlot(EquipmentSlot.LEGS).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> {
            leggingsModule1 = new BaseSlot(handler, 0, 65, 75, stack -> stack.getItem() instanceof ModuleItem);
            leggingsModule2 = new BaseSlot(handler, 1, 81, 54, stack -> stack.getItem() instanceof ModuleItem);
            leggingsModule3 = new BaseSlot(handler, 2, 97, 75, stack -> stack.getItem() instanceof ModuleItem);
            addSlot(leggingsModule1);
            addSlot(leggingsModule2);
            addSlot(leggingsModule3);
        });
        player.getItemBySlot(EquipmentSlot.FEET).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> {
            bootsModule1 = new BaseSlot(handler, 0, 65, 75, stack -> stack.getItem() instanceof ModuleItem);
            bootsModule2 = new BaseSlot(handler, 1, 81, 54, stack -> stack.getItem() instanceof ModuleItem);
            bootsModule3 = new BaseSlot(handler, 2, 97, 75, stack -> stack.getItem() instanceof ModuleItem);
            addSlot(bootsModule1);
            addSlot(bootsModule2);
            addSlot(bootsModule3);
        });

        selection = EnumUtil.getItemEnum(ClientConfig.smartSuitEditorSelection.get());
        allModuleSlots = new BaseSlot[]{helmetModule1, helmetModule2, helmetModule3, chestplateModule1, chestplateModule2, chestplateModule3, chestplateModule4, leggingsModule1, leggingsModule2, leggingsModule3, bootsModule1, bootsModule2, bootsModule3};

        refreshActiveSlots();

        ItemStack playerHelmet = this.player.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack playerChestplate = this.player.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack playerLeggings = this.player.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack playerBoots = this.player.getItemBySlot(EquipmentSlot.FEET);

        if (playerHelmet.getOrCreateTag().contains("Modules")) {
            rolloutModulesFromItemNbt(playerHelmet, new BaseSlot[]{helmetModule1, helmetModule2, helmetModule3});
        }
        if (playerChestplate.getOrCreateTag().contains("Modules")) {
            rolloutModulesFromItemNbt(playerChestplate, new BaseSlot[]{chestplateModule1, chestplateModule2, chestplateModule3, chestplateModule4});
        }
        if (playerLeggings.getOrCreateTag().contains("Modules")) {
            rolloutModulesFromItemNbt(playerLeggings, new BaseSlot[]{leggingsModule1, leggingsModule2, leggingsModule3});
        }
        if (playerBoots.getOrCreateTag().contains("Modules")) {
            rolloutModulesFromItemNbt(playerBoots, new BaseSlot[]{bootsModule1, bootsModule2, bootsModule3});
        }

    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player playerIn, int index) {
        return ItemStack.EMPTY;
    }

    @Override
    public void broadcastChanges() {
        this.selection = EnumUtil.getItemEnum(ClientConfig.smartSuitEditorSelection.get());
        refreshActiveSlots();

        if (changed) {
            ItemStack playerHelmet = this.player.getItemBySlot(EquipmentSlot.HEAD);
            ItemStack playerChestplate = this.player.getItemBySlot(EquipmentSlot.CHEST);
            ItemStack playerLeggings = this.player.getItemBySlot(EquipmentSlot.LEGS);
            ItemStack playerBoots = this.player.getItemBySlot(EquipmentSlot.FEET);

            if (helmetModule1 != null) {
                putModulesToItemNbt(playerHelmet, new BaseSlot[]{helmetModule1, helmetModule2, helmetModule3});
            }
            if (chestplateModule1 != null) {
                putModulesToItemNbt(playerChestplate, new BaseSlot[]{chestplateModule1, chestplateModule2, chestplateModule3, chestplateModule4});
            }
            if (leggingsModule1 != null) {
                putModulesToItemNbt(playerLeggings, new BaseSlot[]{leggingsModule1, leggingsModule2, leggingsModule3});
            }
            if (bootsModule1 != null) {
                putModulesToItemNbt(playerBoots, new BaseSlot[]{bootsModule1, bootsModule2, bootsModule3});
            }

            changed = false;
        }

        super.broadcastChanges();
    }

    public void putModulesToItemNbt(ItemStack target, BaseSlot[] baseSlots) {
        CompoundTag tag = new CompoundTag();
        CompoundTag modules = new CompoundTag();
        for (int i = 0; i < baseSlots.length; i++) {
            CompoundTag items = new CompoundTag();
            baseSlots[i].getItem().save(items);
            tag.put("slot-" + (i + 1), items);
        }
        modules.put("Modules", tag);
        target.setTag(modules);
    }

    public void rolloutModulesFromItemNbt(ItemStack target, BaseSlot[] baseSlots) {
        CompoundTag tag = target.getOrCreateTag().getCompound("Modules");
        for (int i = 0; i < baseSlots.length; i++) {
            baseSlots[i].set(ItemStack.of(tag.getCompound("slot-" + (i + 1))));
        }
    }

    public void refreshActiveSlots() {
        disableAllSlots();
        switch (selection) {
            case HELMET -> {
                if (player.getItemBySlot(EquipmentSlot.HEAD).is(ModItems.SMART_SUIT_HELMET.get())) {
                    helmetModule1.setActive(true);
                    helmetModule2.setActive(true);
                    helmetModule3.setActive(true);
                }
            }
            case CHESTPLATE -> {
                if (player.getItemBySlot(EquipmentSlot.CHEST).is(ModItems.SMART_SUIT_CHESTPLATE.get())) {
                    chestplateModule1.setActive(true);
                    chestplateModule2.setActive(true);
                    chestplateModule3.setActive(true);
                    chestplateModule4.setActive(true);
                }
            }
            case LEGGINGS -> {
                if (player.getItemBySlot(EquipmentSlot.LEGS).is(ModItems.SMART_SUIT_LEGGINGS.get())) {
                    leggingsModule1.setActive(true);
                    leggingsModule2.setActive(true);
                    leggingsModule3.setActive(true);
                }
            }
            case BOOTS -> {
                if (player.getItemBySlot(EquipmentSlot.FEET).is(ModItems.SMART_SUIT_BOOTS.get())) {
                    bootsModule1.setActive(true);
                    bootsModule2.setActive(true);
                    bootsModule3.setActive(true);
                }
            }
        }
    }

    public void disableAllSlots() {
        for (BaseSlot moduleSlot : allModuleSlots) {
            if (moduleSlot != null)
                moduleSlot.setActive(false);
        }
    }

    @Override
    public void clicked(int pMouseX, int pMouseY, @NotNull ClickType pClickType, @NotNull Player pPlayer) {
        super.clicked(pMouseX, pMouseY, pClickType, pPlayer);
        changed = true;
    }

    @Override
    public boolean stillValid(@NotNull Player playerIn) {
        return true;
    }

}
