package de.unhappycodings.smartsuits;

import com.mojang.logging.LogUtils;
import de.unhappycodings.smartsuits.common.ItemCreativeTab;
import de.unhappycodings.smartsuits.common.network.PacketHandler;
import de.unhappycodings.smartsuits.common.registration.ModContainerTypes;
import de.unhappycodings.smartsuits.common.registration.ModItems;
import de.unhappycodings.smartsuits.common.registration.Registration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.Random;

@Mod(SmartSuits.MOD_ID)
public class SmartSuits {
    public static final ResourceLocation BLANK = new ResourceLocation(SmartSuits.MOD_ID, "textures/gui/overlay/blank.png");
    public static final ResourceLocation GHOST_OVERLAY = new ResourceLocation(SmartSuits.MOD_ID, "textures/gui/overlay/ghost.png");

    public static final Random RANDOM = new Random();
    public static final String MOD_ID = "smartsuits";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final CreativeModeTab creativeTab = new ItemCreativeTab();

    public SmartSuits() {
        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        LOGGER.info("[" + MOD_ID + "] Initialization");

        Registration.register();
        ModItems.register();
        ModContainerTypes.register();

        MinecraftForge.EVENT_BUS.register(this);
        bus.addListener(this::onCommonSetup);
    }

    public void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(PacketHandler::init);
    }

}
