package com.dbserver.johank.swapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface SWService {

    @GET("people/")
    fun getCharacters(): Call<CharactersPage>

    @GET
    fun getCharactersPage(@Url url: String): Call<CharactersPage>
}