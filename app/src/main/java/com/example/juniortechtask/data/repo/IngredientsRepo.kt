package com.example.juniortechtask.data.repo

import com.example.juniortechtask.data.api.IngredientCallback

interface IngredientsRepo {

    fun getIngredients(callback: IngredientCallback)

}