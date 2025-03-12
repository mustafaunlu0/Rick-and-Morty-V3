package com.example.composetestapplication.data.remote


import com.example.composetestapplication.data.remote.dto.ResultDto
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApi {

    @GET("character")
    suspend fun getCharacters() : ResultDto

    @GET("character/{characterNumber}")
    suspend fun getCharacterDetail(
        @Path("characterNumber") characterNumber : String
    ) : ResponseBody
}