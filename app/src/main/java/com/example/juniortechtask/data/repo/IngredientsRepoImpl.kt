package com.example.juniortechtask.data.repo

import com.example.juniortechtask.data.api.IngredientCallback
import com.example.juniortechtask.data.api.IngredientsApiService
import com.example.juniortechtask.data.api.RetrofitServiceBuilder

class IngredientsRepoImpl : IngredientsRepo {

    private val retrofit = RetrofitServiceBuilder()
    private val ingredientApi = retrofit.buildService(IngredientsApiService::class.java)

    override fun getIngredients(callback: IngredientCallback) =
        ingredientApi.getIngredients().enqueue(callback)

}
