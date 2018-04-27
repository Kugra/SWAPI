package com.dbserver.johank.swapi

import retrofit2.Call
import retrofit2.http.GET

interface SWService {

    @GET("people/")
    fun getCharacters(): Call<CharactersPage>

    @GET("people/1/")
    fun getCharacterOneAsTest(): Call<Character>

}