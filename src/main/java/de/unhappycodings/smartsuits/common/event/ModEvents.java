package de.unhappycodings.smartsuits.common.event;

import de.unhappycodings.smartsuits.SmartSuits;
import de.unhappycodings.smartsuits.common.network.PacketHandler;
import de.unhappycodings.smartsuits.common.network.toserver.SmartSuitEditorOpenPacket;
import de.unhappycodings.smartsuits.common.registration.ModKeyBindings;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.IItemHandler;

@Mod.EventBusSubscriber(modid = SmartSuits.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    @SubscribeEvent
    public static void onEditorKeybindPressEvent(InputEvent.KeyInputEvent event) {
        tryOpenGui(event.getKey());
    }

    @SubscribeEvent
    public static void onEditorKeybindPressEvent(InputEvent.MouseInputEvent event) {
        tryOpenGui(event.getButton());
    }

    public static void tryOpenGui(int button) {
        if (button == ModKeyBindings.OPEN_EDITOR.getKey().getValue()) {
            PacketHandler.sendToServer(new SmartSuitEditorOpenPacket());
        }
    }

}
