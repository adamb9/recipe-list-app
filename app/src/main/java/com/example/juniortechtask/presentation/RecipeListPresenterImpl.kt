package com.example.juniortechtask.presentation

import android.content.Context
import com.example.juniortechtask.data.api.IngredientCallback
import com.example.juniortechtask.interactors.RecipeInteractor
import com.example.juniortechtask.interactors.RecipeInteractorImpl
import com.example.juniortechtask.view.RecipeListView

class RecipeListPresenterImpl(private val view: RecipeListView) : RecipeListPresenter {

    private val recipeInteractor: RecipeInteractor = RecipeInteractorImpl()
    private val callback: IngredientCallback = IngredientCallback(this)

    override fun getAvailableRecipes(context: Context) =
        recipeInteractor.loadRecipes(context, callback)

    override fun onDataLoaded(ingredientList: List<String>) {
        val recipeList = recipeInteractor.getAvailableRecipes(ingredientList)
        view.updateData(recipeList)
    }

}