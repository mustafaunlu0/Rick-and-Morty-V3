package com.example.composetestapplication.data.remote


import com.example.composetestapplication.data.remote.response.CharacterResponse
import com.example.composetestapplication.data.remote.response.Result
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApi {

    @GET("character")
    suspend fun getCharacters() : Result

    @GET("character/{characterNumber}")
    suspend fun getCharacterDetail(
        @Path("characterNumber") characterNumber : String
    ) : CharacterResponse

    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api/"
    }
}