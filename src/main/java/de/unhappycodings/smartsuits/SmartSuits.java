package de.unhappycodings.smartsuits;

import com.mojang.logging.LogUtils;
import de.unhappycodings.smartsuits.common.ItemCreativeTab;
import de.unhappycodings.smartsuits.common.item.ModItems;
import de.unhappycodings.smartsuits.common.registration.Registration;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.Random;

@Mod(SmartSuits.MOD_ID)
public class SmartSuits {

    public static final Random RANDOM = new Random();
    public static final String MOD_ID = "smartsuits";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final CreativeModeTab creativeTab = new ItemCreativeTab();

    public SmartSuits() {
        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        LOGGER.info("[" + MOD_ID + "] Initialization");

        Registration.register();
        ModItems.register();

        MinecraftForge.EVENT_BUS.register(this);
    }

}
