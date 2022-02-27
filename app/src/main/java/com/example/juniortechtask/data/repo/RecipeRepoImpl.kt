package com.example.juniortechtask.data.repo

import android.content.Context
import com.example.juniortechtask.entity.Recipe
import com.example.juniortechtask.utils.JsonUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class RecipeRepoImpl : RecipeRepo {

    companion object {
        val RECIPES_FILE = "Recipes.json"
    }

    private val jsonUtils = JsonUtils()

    override fun getRecipes(context: Context): List<Recipe> {
        val jsonString = jsonUtils.loadJsonFromAsset(context, RECIPES_FILE)
        val collectionType: Type = object : TypeToken<Collection<Recipe>>() {}.type

        return Gson().fromJson(jsonString, collectionType)
    }

}