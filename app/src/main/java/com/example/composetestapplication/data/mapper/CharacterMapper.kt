package com.example.composetestapplication.data.mapper

import com.example.composetestapplication.data.local.CharacterListEntity
import com.example.composetestapplication.domain.model.CharacterList

fun CharacterListEntity.toCharacterList() : CharacterList {
    return CharacterList(
        id = id,
        name = name,
        species = species,
        image = image
    )
}