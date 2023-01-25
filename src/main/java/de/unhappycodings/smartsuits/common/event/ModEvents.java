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
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SmartSuits.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    @SubscribeEvent
    public static void onEditorKeybindPressEvent(InputEvent.KeyInputEvent event) {
        if (event.getKey() == ModKeyBindings.OPEN_EDITOR.getKey().getValue()) {
            System.out.println("keyboard");
            PacketHandler.sendToServer(new SmartSuitEditorOpenPacket());

        }
    }

    @SubscribeEvent
    public static void onEditorKeybindPressEvent(InputEvent.MouseInputEvent event) {
        if (event.getButton() == ModKeyBindings.OPEN_EDITOR.getKey().getValue()) {
            System.out.println("mouse");
        }
    }

}
