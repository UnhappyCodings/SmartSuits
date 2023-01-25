package de.unhappycodings.smartsuits.client;

import de.unhappycodings.smartsuits.SmartSuits;
import de.unhappycodings.smartsuits.common.container.SmartSuitEditorScreen;
import de.unhappycodings.smartsuits.common.registration.ModContainerTypes;
import de.unhappycodings.smartsuits.common.registration.ModKeyBindings;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = SmartSuits.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEvents {

    @SubscribeEvent
    public static void onRegisterKeyMappingEvent(FMLClientSetupEvent event) {
        ClientRegistry.registerKeyBinding(ModKeyBindings.OPEN_EDITOR);

        MenuScreens.register(ModContainerTypes.SMART_SUIT_EDITOR_CONTAINER.get(), SmartSuitEditorScreen::new);
    }

}
