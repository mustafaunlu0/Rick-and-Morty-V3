package com.example.composetestapplication.domain.model

import com.example.composetestapplication.data.remote.response.Location
import com.example.composetestapplication.data.remote.response.Origin


data class CharacterDetail (
    val id: Int,
    val name: String,
    val gender: String,
    val image: String,
    val location: Location,
    val origin: Origin,
    val species: String,
    val status: String,
)
