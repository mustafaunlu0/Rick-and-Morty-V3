package com.example.composetestapplication.data.repository

import com.example.composetestapplication.data.local.CharacterDatabase
import com.example.composetestapplication.data.mapper.toCharacterList
import com.example.composetestapplication.data.remote.CharacterApi
import com.example.composetestapplication.domain.model.CharacterList
import com.example.composetestapplication.domain.repository.CharacterRepository
import com.example.composetestapplication.util.Resource
import com.example.composetestapplication.util.callSafeApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharacterRepositoryImpl(
    val api  : CharacterApi,
    val db : CharacterDatabase
) : CharacterRepository {

    private val dao = db.dao

    override suspend fun getCharacters(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CharacterList>>> =
        flow {
            emit(Resource.Loading(true))

            val localList = dao.searchCharacterList(query).map { characterListEntity ->
                characterListEntity.toCharacterList()
            }
            emit(Resource.Success(localList))

            val isDbEmpty = localList.isEmpty() && query.isBlank() //first loadqing
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote

            if(shouldJustLoadFromCache){
                emit(Resource.Loading(false))
                return@flow
            }

            val remoteListing = callSafeApi {
                val response = api.getCharacters()
                Resource.Success(response)
            }





        }
}