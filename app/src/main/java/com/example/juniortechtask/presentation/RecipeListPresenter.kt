package com.example.juniortechtask.presentation

import android.content.Context

interface RecipeListPresenter {

    fun getAvailableRecipes(context: Context)

    fun onDataLoaded(ingredientList: List<String>)

}