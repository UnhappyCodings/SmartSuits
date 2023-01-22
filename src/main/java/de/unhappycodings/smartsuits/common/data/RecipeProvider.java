package de.unhappycodings.smartsuits.common.data;

import com.google.common.collect.ImmutableList;
import de.unhappycodings.smartsuits.common.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class RecipeProvider extends net.minecraft.data.recipes.RecipeProvider {

    public RecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(ModItems.SMART_CRYSTAL.get())
                .define('A', Items.DIAMOND).define('B', Items.GLOWSTONE_DUST)
                .define('C', Items.REDSTONE).pattern(" C ").pattern("CAB")
                .pattern(" B ").unlockedBy("has_diamond", has(Items.DIAMOND)).save(consumer);
        ShapedRecipeBuilder.shaped(ModItems.INTEGRATING_CIRCUIT.get())
                .define('A', ModItems.SMART_CRYSTAL.get()).define('B', Items.LAPIS_LAZULI)
                .define('C', Items.REDSTONE).define('D', Items.GREEN_DYE).define('E', Items.QUARTZ)
                .pattern("BAB").pattern("CEC").pattern("BDB").unlockedBy("has_smart_crystal", has(ModItems.SMART_CRYSTAL.get())).save(consumer);
        ShapedRecipeBuilder.shaped(ModItems.ARMOR_PLATING.get())
                .define('A', ModItems.SMART_CRYSTAL.get()).define('B', Items.GLOWSTONE_DUST)
                .define('C', Items.REDSTONE).define('D', ModItems.INTEGRATING_CIRCUIT.get())
                .define('E', ModItems.IRON_PLATE.get())
                .pattern("EBE").pattern("CDC").pattern("EAE").unlockedBy("has_integrating_circuit", has(ModItems.INTEGRATING_CIRCUIT.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModItems.SMART_SUIT_HELMET_PLATING.get())
                .define('A', ModItems.SMART_CRYSTAL.get()).define('B', Items.GLOWSTONE_DUST)
                .define('C', Items.REDSTONE).define('D', Items.NETHERITE_HELMET)
                .define('E', ModItems.IRON_PLATE.get()).define('F', ModItems.ARMOR_PLATING.get())
                .pattern("EAE").pattern("BDB").pattern("CFC").unlockedBy("has_armor_plating", has(ModItems.ARMOR_PLATING.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModItems.SMART_SUIT_HELMET.get())
                .define('A', ModItems.SMART_CRYSTAL.get()).define('B', Items.REDSTONE)
                .define('C', ModItems.CARBON_MESH.get()).define('D', ModItems.CARBON_PLATE.get())
                .define('E', ModItems.SMART_SUIT_HELMET_PLATING.get())
                .pattern("DCD").pattern("DED").pattern("BAB").unlockedBy("has_smart_suit_helmet_plating", has(ModItems.SMART_SUIT_HELMET_PLATING.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModItems.HAMMER.get())
                .define('A', Items.IRON_INGOT).define('B', Items.IRON_NUGGET).define('C', Items.STICK)
                .pattern(" AB").pattern(" CA").pattern("C  ").unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).save(consumer);

        ShapedRecipeBuilder.shaped(ModItems.CARBON_MESH.get())
                .define('A', ModItems.CARBON_PELLETS.get())
                .pattern("AA").pattern("AA").unlockedBy("has_carbon_pellets", has(ModItems.CARBON_PELLETS.get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.IRON_PLATE.get())
                .requires(ModItems.HAMMER.get()).requires(Items.IRON_INGOT)
                .unlockedBy("has_hammer", has(ModItems.HAMMER.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModItems.CARBON_PLATE.get())
                .requires(ModItems.HAMMER.get()).requires(ModItems.CARBON_MESH.get())
                .unlockedBy("has_hammer", has(ModItems.HAMMER.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModItems.COAL_DUST.get())
                .requires(Items.COAL).requires(ModItems.HAMMER.get())
                .unlockedBy("has_hammer", has(ModItems.HAMMER.get())).save(consumer);

        oreSmelting(consumer, ImmutableList.of(ModItems.COAL_DUST.get()), ModItems.CARBON_PELLETS.get(), 0.4F, 200, "carbon_pellets");
    }
}
