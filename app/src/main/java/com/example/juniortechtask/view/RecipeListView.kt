package com.example.juniortechtask.view

import com.example.juniortechtask.entity.Recipe

interface RecipeListView {

    fun updateData(updatedRecipeList: List<Recipe>)

}