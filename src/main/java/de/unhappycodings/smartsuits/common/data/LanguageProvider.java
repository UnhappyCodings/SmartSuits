package de.unhappycodings.smartsuits.common.data;

import de.unhappycodings.smartsuits.SmartSuits;
import de.unhappycodings.smartsuits.common.registration.ModItems;
import net.minecraft.data.DataGenerator;

public class LanguageProvider extends net.minecraftforge.common.data.LanguageProvider {

    public LanguageProvider(DataGenerator gen, String locale) {
        super(gen, SmartSuits.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add(ModItems.SMART_SUIT_HELMET.get(), "Smart Helmet");
        add(ModItems.SMART_SUIT_CHESTPLATE.get(), "Smart Chestplate");
        add(ModItems.SMART_SUIT_LEGGINGS.get(), "Smart Leggings");
        add(ModItems.SMART_SUIT_BOOTS.get(), "Smart Boots");

        add(ModItems.COAL_DUST.get(), "Coal Dust");
        add(ModItems.CARBON_PELLETS.get(), "Carbon Pellets");
        add(ModItems.CARBON_MESH.get(), "Carbon Mesh");
        add(ModItems.CARBON_PLATE.get(), "Carbon Plate");
        add(ModItems.IRON_PLATE.get(), "Iron Plate");

        add(ModItems.SMART_CRYSTAL.get(), "Smart Crystal");
        add(ModItems.ARMOR_PLATING.get(), "Armor Plating");
        add(ModItems.SMART_SUIT_HELMET_PLATING.get(), "Smart Helmet Plating");
        add(ModItems.SMART_SUIT_CHESTPLATE_PLATING.get(), "Smart Chestplate Plating");
        add(ModItems.SMART_SUIT_LEGGINGS_PLATING.get(), "Smart Leggings Plating");
        add(ModItems.SMART_SUIT_BOOTS_PLATING.get(), "Smart Boots Plating");
        add(ModItems.INTEGRATING_CIRCUIT.get(), "Integrating Circuit");
    }
}
