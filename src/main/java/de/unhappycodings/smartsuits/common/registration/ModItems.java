package de.unhappycodings.smartsuits.common.registration;

import de.unhappycodings.smartsuits.SmartSuits;
import de.unhappycodings.smartsuits.common.item.HammerItem;
import de.unhappycodings.smartsuits.common.item.ModuleItem;
import de.unhappycodings.smartsuits.common.item.SmartSuitArmorItem;
import de.unhappycodings.smartsuits.common.material.ModArmorMaterials;
import de.unhappycodings.smartsuits.common.registration.Registration;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final RegistryObject<Item> SMART_SUIT_HELMET = Registration.ITEMS.register("smart_suit_helmet",
            () -> new SmartSuitArmorItem(ModArmorMaterials.SMART, EquipmentSlot.HEAD,
                    new Item.Properties().tab(SmartSuits.creativeTab), 3));
    public static final RegistryObject<Item> SMART_SUIT_CHESTPLATE = Registration.ITEMS.register("smart_suit_chestplate",
            () -> new SmartSuitArmorItem(ModArmorMaterials.SMART, EquipmentSlot.CHEST,
                    new Item.Properties().tab(SmartSuits.creativeTab), 4));
    public static final RegistryObject<Item> SMART_SUIT_LEGGINGS = Registration.ITEMS.register("smart_suit_leggings",
            () -> new SmartSuitArmorItem(ModArmorMaterials.SMART, EquipmentSlot.LEGS,
                    new Item.Properties().tab(SmartSuits.creativeTab), 3));
    public static final RegistryObject<Item> SMART_SUIT_BOOTS = Registration.ITEMS.register("smart_suit_boots",
            () -> new SmartSuitArmorItem(ModArmorMaterials.SMART, EquipmentSlot.FEET,
                    new Item.Properties().tab(SmartSuits.creativeTab), 3));

    public static final RegistryObject<Item> SMART_SUIT_HELMET_PLATING = Registration.ITEMS.register("smart_suit_helmet_plating", () -> new Item(new Item.Properties().tab(SmartSuits.creativeTab).stacksTo(1)));
    public static final RegistryObject<Item> SMART_SUIT_CHESTPLATE_PLATING = Registration.ITEMS.register("smart_suit_chestplate_plating", () -> new Item(new Item.Properties().tab(SmartSuits.creativeTab).stacksTo(1)));
    public static final RegistryObject<Item> SMART_SUIT_LEGGINGS_PLATING = Registration.ITEMS.register("smart_suit_leggings_plating", () -> new Item(new Item.Properties().tab(SmartSuits.creativeTab).stacksTo(1)));
    public static final RegistryObject<Item> SMART_SUIT_BOOTS_PLATING = Registration.ITEMS.register("smart_suit_boots_plating", () -> new Item(new Item.Properties().tab(SmartSuits.creativeTab).stacksTo(1)));

    public static final RegistryObject<Item> HAMMER = Registration.ITEMS.register("hammer", HammerItem::new);

    public static final RegistryObject<Item> COAL_DUST = Registration.ITEMS.register("coal_dust", () -> new Item(new Item.Properties().tab(SmartSuits.creativeTab)));
    public static final RegistryObject<Item> CARBON_PELLETS = Registration.ITEMS.register("carbon_pellets", () -> new Item(new Item.Properties().tab(SmartSuits.creativeTab)));
    public static final RegistryObject<Item> CARBON_MESH = Registration.ITEMS.register("carbon_mesh", () -> new Item(new Item.Properties().tab(SmartSuits.creativeTab)));
    public static final RegistryObject<Item> CARBON_PLATE = Registration.ITEMS.register("carbon_plate", () -> new Item(new Item.Properties().tab(SmartSuits.creativeTab)));
    public static final RegistryObject<Item> IRON_PLATE = Registration.ITEMS.register("iron_plate", () -> new Item(new Item.Properties().tab(SmartSuits.creativeTab)));

    public static final RegistryObject<Item> ARMOR_PLATING = Registration.ITEMS.register("armor_plating", () -> new Item(new Item.Properties().tab(SmartSuits.creativeTab)));
    public static final RegistryObject<Item> INTEGRATING_CIRCUIT = Registration.ITEMS.register("integrating_circuit", () -> new Item(new Item.Properties().tab(SmartSuits.creativeTab)));
    public static final RegistryObject<Item> SMART_CRYSTAL = Registration.ITEMS.register("smart_crystal", () -> new Item(new Item.Properties().tab(SmartSuits.creativeTab)));

    public static final RegistryObject<Item> MAGNET_MODULE = Registration.ITEMS.register("magnet_module", ModuleItem::new);
    public static final RegistryObject<Item> NIGHT_VISION_MODULE = Registration.ITEMS.register("night_vision_module", ModuleItem::new);
    public static final RegistryObject<Item> EMPTY_MODULE = Registration.ITEMS.register("empty_module", ModuleItem::new);

    public static void register() {
    }

}
