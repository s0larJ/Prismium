package net.s0larj.prismium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.s0larj.prismium.Prismium;
import net.s0larj.prismium.block.ModBlocks;
import net.s0larj.prismium.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        //all items that can be smelted to make prismium
        List<ItemConvertible> PRISMIUM_SMELTABLES = List.of(ModItems.PRISMARITE, ModBlocks.PRISMARITE_BLOCK);

        //smelting recipes, item category is for recipe book, first is input, second is output
        offerSmelting(recipeExporter, PRISMIUM_SMELTABLES, RecipeCategory.MISC, ModItems.PRISMIUM, 0.25f, 200, "prismium");
        offerBlasting(recipeExporter, PRISMIUM_SMELTABLES, RecipeCategory.MISC, ModItems.PRISMIUM, 0.25f, 100, "prismium");

        //for items that can be turned from one to the other, ie iron and iron blocks
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PRISMIUM, RecipeCategory.DECORATIONS, ModBlocks.PRISMIUM_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PRISMARITE_BLOCK)
                .pattern("PPP")
                .pattern("PPP")
                .pattern("PPP")
                .input('P', ModItems.PRISMARITE)
                .criterion(hasItem(ModItems.PRISMARITE), conditionsFromItem(ModItems.PRISMARITE)) //for unlocking in recipe book
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PRISMARITE, 9)
                .input(ModBlocks.PRISMARITE_BLOCK)
                .criterion(hasItem(ModBlocks.PRISMARITE_BLOCK), conditionsFromItem(ModBlocks.PRISMARITE_BLOCK))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PRISMARITE, 32)
                .input(ModBlocks.MAGIC_BLOCK)
                .criterion(hasItem(ModBlocks.MAGIC_BLOCK), conditionsFromItem(ModBlocks.MAGIC_BLOCK))
                .offerTo(recipeExporter, Identifier.of(Prismium.MOD_ID, "prismarite_from_magic_block"));//need other name if theres more than one recipe for something

    }
}
