package com.example.composetestapplication.domain.repository

import com.example.common.util.util.util.Resource
import com.example.composetestapplication.domain.model.CharacterDetail
import com.example.composetestapplication.domain.model.CharacterListing
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