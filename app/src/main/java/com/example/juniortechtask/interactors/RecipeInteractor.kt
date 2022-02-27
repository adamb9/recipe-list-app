package com.example.juniortechtask.interactors

import android.content.Context
import com.example.juniortechtask.data.api.IngredientCallback
import com.example.juniortechtask.entity.Recipe

interface RecipeInteractor {

    fun loadRecipes(context: Context, callback: IngredientCallback)

    fun getAvailableRecipes(ingredients: List<String>): List<Recipe>

}