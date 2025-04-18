package com.example.composetestapplication.domain.model



data class CharacterDetail(
    val id: Int,
    val name: String,
    val gender: String,
    val image: String,
    val location: Location,
    val origin: Origin,
    val species: String,
    val status: String,
)

data class Location(
    val name: String,
    val url: String
)

data class Origin(
    val name: String,
    val url: String
)
