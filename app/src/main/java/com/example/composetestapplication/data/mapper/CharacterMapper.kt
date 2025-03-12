package com.example.composetestapplication.data.mapper

import com.example.composetestapplication.data.local.CharacterListEntity
import com.example.composetestapplication.data.remote.dto.CharacterDto
import com.example.composetestapplication.domain.model.CharacterListing

fun CharacterListEntity.toCharacterList() : CharacterListing {
    return CharacterListing(
        id = id,
        name = name,
        species = species,
        image = image
    )
}

fun CharacterDto.toCharacterListEntity() : CharacterListEntity {
    return CharacterListEntity(
        id = id,
        name = name,
        species = species,
        image = image
    )
}
