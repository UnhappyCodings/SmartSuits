package de.unhappycodings.smartsuits.common.registration;

import de.unhappycodings.smartsuits.common.container.SmartSuitEditorContainer;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.RegistryObject;

public class ModContainerTypes {

    public static final RegistryObject<MenuType<SmartSuitEditorContainer>> SMART_SUIT_EDITOR_CONTAINER = Registration.CONTAINER_TYPES.register("smart_suit_editor_container", () -> IForgeMenuType.create((windowId, inv, data) -> new SmartSuitEditorContainer(windowId, inv, data.readBlockPos(), inv.player.getCommandSenderWorld(), 0)));

    public static void register() {
    }

}
