package com.example.composetestapplication.data.remote.response

import com.example.composetestapplication.domain.model.Location
import com.example.composetestapplication.domain.model.Origin

data class CharacterResponse (
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)
