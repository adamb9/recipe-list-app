package com.example.juniortechtask.data.repo

import android.content.Context
import com.example.juniortechtask.entity.Recipe

interface RecipeRepo {

    fun getRecipes(context: Context): List<Recipe>

}
