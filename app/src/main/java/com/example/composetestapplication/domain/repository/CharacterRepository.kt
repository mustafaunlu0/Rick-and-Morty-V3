package com.example.composetestapplication.domain.repository

import com.example.composetestapplication.domain.model.CharacterDetail
import com.example.composetestapplication.domain.model.CharacterListing
import com.example.composetestapplication.util.Resource
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    suspend fun getCharacters(
        fetchFromRemote : Boolean,
        query : String
    ) : Flow<Resource<List<CharacterListing>>>

    suspend fun getCharacter(
        charId : String
    ) : Flow<Resource<CharacterDetail>>


}