package com.example.juniortechtask.interactors

import android.content.Context
import com.example.juniortechtask.data.api.IngredientCallback
import com.example.juniortechtask.data.repo.IngredientsRepoImpl
import com.example.juniortechtask.data.repo.RecipeRepoImpl
import com.example.juniortechtask.entity.Recipe

class RecipeInteractorImpl : RecipeInteractor {


    private lateinit var ingredientsList: List<String>
    private lateinit var recipesList: List<Recipe>

    private val recipeRepo = RecipeRepoImpl()
    private val ingredientsRepo = IngredientsRepoImpl()

    override fun loadRecipes(context: Context, callback: IngredientCallback) {
        recipesList = recipeRepo.getRecipes(context)
        ingredientsRepo.getIngredients(callback)
    }

    override fun getAvailableRecipes(ingredients: List<String>): List<Recipe> {
        ingredientsList = ingredients

        val availableRecipes = mutableListOf<Recipe>()

        for (recipe in recipesList) {
            if (ingredientsList.containsAll(recipe.ingredients)) {
                availableRecipes.add(recipe)
            }
        }

        return availableRecipes
    }

}