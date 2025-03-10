package com.example.composetestapplication.data.remote.dto

data class CharacterDto (
    val id: Int,
    val name: String,
    val gender: String,
    val image: String,
    val location: LocationDto,
    val origin: OriginDto,
    val species: String,
    val status: String,
)
