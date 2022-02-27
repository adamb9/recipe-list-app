package com.example.juniortechtask.data.api

import retrofit2.Call
import retrofit2.http.GET

interface IngredientsApiService {

    @GET("v3/45a5a07f-e981-4918-9c31-090b121d6c5f")
    fun getIngredients(): Call<List<String>>

}
