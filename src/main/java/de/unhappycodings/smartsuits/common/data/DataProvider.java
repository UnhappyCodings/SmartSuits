package de.unhappycodings.smartsuits.common.data;

import de.unhappycodings.smartsuits.SmartSuits;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = SmartSuits.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataProvider {

    @SubscribeEvent
    public static void onDataGen(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(new ItemModelProvider(generator, existingFileHelper));
        generator.addProvider(new LanguageProvider(generator, "en_us"));
        generator.addProvider(new RecipeProvider(generator));

    }
}
