package com.example.composetestapplication.data.mapper

import com.example.composetestapplication.data.local.CharacterListEntity
import com.example.composetestapplication.data.remote.response.CharacterResponse
import com.example.composetestapplication.domain.model.CharacterDetail
import com.example.composetestapplication.domain.model.CharacterListing

fun CharacterListEntity.toCharacterList() : CharacterListing {
    return CharacterListing(
        id = id,
        name = name,
        species = species,
        image = image
    )
}

fun CharacterResponse.toCharacterListEntity() : CharacterListEntity {
    return CharacterListEntity(
        id = id,
        name = name,
        species = species,
        image = image
    )
}

fun CharacterResponse.toCharacterDetail() : CharacterDetail {
    return CharacterDetail(
        id = id,
        name = name,
        species = species,
        image = image,
        gender = gender,
        location = location,
        origin = origin,
        status = status
    )
}
