package com.example.composetestapplication.data.remote


import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApi {

    @GET("character")
    suspend fun getCharacters() : List<CharacterListDto>

    @GET("character/{characterNumber}")
    suspend fun getCharacterDetail(
        @Path("characterNumber") characterNumber : String
    ) : ResponseBody
}