package com.nyfaria.upgradedchests.datagen;

import com.nyfaria.upgradedchests.init.BlockInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> recipeSaver) {
        upgradedChestRecipe(BlockInit.ACACIA_UPGRADED_CHEST.get(), Items.ACACIA_PLANKS, recipeSaver);
        upgradedChestRecipe(BlockInit.BIRCH_UPGRADED_CHEST.get(), Items.BIRCH_PLANKS, recipeSaver);
        upgradedChestRecipe(BlockInit.DARK_OAK_UPGRADED_CHEST.get(), Items.DARK_OAK_PLANKS, recipeSaver);
        upgradedChestRecipe(BlockInit.JUNGLE_UPGRADED_CHEST.get(), Items.JUNGLE_PLANKS, recipeSaver);
        upgradedChestRecipe(BlockInit.OAK_UPGRADED_CHEST.get(), Items.OAK_PLANKS, recipeSaver);
        upgradedChestRecipe(BlockInit.SPRUCE_UPGRADED_CHEST.get(), Items.SPRUCE_PLANKS, recipeSaver);
        upgradedChestRecipe(BlockInit.CRIMSON_UPGRADED_CHEST.get(), Items.CRIMSON_PLANKS, recipeSaver);
        upgradedChestRecipe(BlockInit.WARPED_UPGRADED_CHEST.get(), Items.WARPED_PLANKS, recipeSaver);
    }
    public void upgradedChestRecipe(ItemLike chest, Item wood , Consumer<FinishedRecipe> recipeConsumer){
        ShapedRecipeBuilder.shaped(chest)
                .pattern("WWW")
                .pattern("WCW")
                .pattern("WAW")
                .define('W', wood)
                .define('C', Items.CHEST)
                .define('A', Items.AMETHYST_SHARD)
                .group("upgraded_chest")
                .unlockedBy("has_chest", has(Items.CHEST))
                .save(recipeConsumer);
    }

}
