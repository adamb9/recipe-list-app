package com.example.juniortechtask.data.api

import com.example.juniortechtask.presentation.RecipeListPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IngredientCallback(private val presenter: RecipeListPresenter) : Callback<List<String>> {

    override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
        val returnedIngredients = response.body()!!

        presenter.onDataLoaded(returnedIngredients)
    }

    override fun onFailure(call: Call<List<String>>, t: Throwable) {
        throw t
    }

}