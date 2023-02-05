package de.unhappycodings.smartsuits;

import com.mojang.logging.LogUtils;
import de.unhappycodings.smartsuits.client.config.ClientConfig;
import de.unhappycodings.smartsuits.common.ItemCreativeTab;
import de.unhappycodings.smartsuits.common.config.CommonConfig;
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
import net.minecraftforge.fml.loading.FMLPaths;
import org.slf4j.Logger;

import java.util.Random;

@Mod(SmartSuits.MOD_ID)
public class SmartSuits {
    public static final ResourceLocation BLANK = new ResourceLocation(SmartSuits.MOD_ID, "textures/gui/overlay/blank.png");
    public static final ResourceLocation GHOST_OVERLAY = new ResourceLocation(SmartSuits.MOD_ID, "textures/gui/overlay/ghost.png");

    public static final ResourceLocation HELMET_NORMAL = new ResourceLocation(SmartSuits.MOD_ID, "textures/gui/button/helmet_normal.png");
    public static final ResourceLocation CHESTPLATE_NORMAL = new ResourceLocation(SmartSuits.MOD_ID, "textures/gui/button/chestplate_normal.png");
    public static final ResourceLocation LEGGINGS_NORMAL = new ResourceLocation(SmartSuits.MOD_ID, "textures/gui/button/leggings_normal.png");
    public static final ResourceLocation BOOTS_NORMAL = new ResourceLocation(SmartSuits.MOD_ID, "textures/gui/button/boots_normal.png");

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

        CommonConfig.loadConfigFile(CommonConfig.commonConfig, FMLPaths.CONFIGDIR.get().resolve("smartsuits-common.toml").toString());
        ClientConfig.loadConfigFile(ClientConfig.clientConfig, FMLPaths.CONFIGDIR.get().resolve("smartsuits-client.toml").toString());

        MinecraftForge.EVENT_BUS.register(this);
        bus.addListener(this::onCommonSetup);
    }

    public void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(PacketHandler::init);
    }

}
