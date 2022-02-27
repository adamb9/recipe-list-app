package com.example.juniortechtask.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitServiceBuilder {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://run.mocky.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> buildService(service: Class<T>): T = retrofit.create(service)

}