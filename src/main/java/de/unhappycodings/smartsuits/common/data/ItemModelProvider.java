package de.unhappycodings.smartsuits.common.data;

import de.unhappycodings.smartsuits.SmartSuits;
import de.unhappycodings.smartsuits.common.registration.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Objects;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {

    public ItemModelProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, SmartSuits.MOD_ID, exFileHelper);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void registerModels() {
        simpleItem(ModItems.SMART_SUIT_HELMET.get());
        simpleItem(ModItems.SMART_SUIT_CHESTPLATE.get());
        simpleItem(ModItems.SMART_SUIT_LEGGINGS.get());
        simpleItem(ModItems.SMART_SUIT_BOOTS.get());

        simpleItem(ModItems.HAMMER.get());

        simpleItem(ModItems.COAL_DUST.get());
        simpleItem(ModItems.CARBON_PELLETS.get());
        simpleItem(ModItems.CARBON_MESH.get());
        simpleItem(ModItems.CARBON_PLATE.get());
        simpleItem(ModItems.IRON_PLATE.get());

        simpleItem(ModItems.ARMOR_PLATING.get());
        simpleItem(ModItems.SMART_SUIT_HELMET_PLATING.get());
        simpleItem(ModItems.SMART_SUIT_CHESTPLATE_PLATING.get());
        simpleItem(ModItems.SMART_SUIT_LEGGINGS_PLATING.get());
        simpleItem(ModItems.SMART_SUIT_BOOTS_PLATING.get());
        simpleItem(ModItems.INTEGRATING_CIRCUIT.get());
        simpleItem(ModItems.SMART_CRYSTAL.get());
    }

    private void simpleItem(Item item) {
        withExistingParent(Objects.requireNonNull(item.getRegistryName()).toString(), "item/generated")
                .texture("layer0", new ResourceLocation(this.modid, "item/" + item.getRegistryName().getPath()));
    }

}
