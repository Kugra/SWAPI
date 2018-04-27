package com.dbserver.johank.swapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val BASE_URL : String = "https://swapi.co/api/"

    private val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    fun starWarsService() = retrofit.create(SWService::class.java)
}