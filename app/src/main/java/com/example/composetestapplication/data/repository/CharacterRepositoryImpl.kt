package com.example.composetestapplication.data.repository

import com.example.composetestapplication.data.local.CharacterDatabase
import com.example.composetestapplication.data.mapper.toCharacterDetail
import com.example.composetestapplication.data.mapper.toCharacterList
import com.example.composetestapplication.data.mapper.toCharacterListEntity
import com.example.composetestapplication.data.remote.CharacterApi
import com.example.composetestapplication.domain.model.CharacterDetail
import com.example.composetestapplication.domain.model.CharacterListing
import com.example.composetestapplication.domain.repository.CharacterRepository
import com.example.composetestapplication.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepositoryImpl @Inject constructor(
    private val api: CharacterApi,
    db: CharacterDatabase
) : CharacterRepository {

    private val dao = db.dao

    override suspend fun getCharacters(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CharacterListing>>> =
        flow {
            emit(Resource.Loading(true))

            val localList = dao.searchCharacterList(query).map { characterListEntity ->
                characterListEntity.toCharacterList()
            }
            emit(Resource.Success(localList))

            val isDbEmpty = localList.isEmpty() && query.isBlank() //first loadqing
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote

            if (shouldJustLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }

            val remoteListing = try {
                api.getCharacters()
            } catch (e: Exception) {
                emit(Resource.Error(e))
                null
            }

            remoteListing?.let {
                val characterEntity = it.results.map { dto -> dto.toCharacterListEntity() }
                dao.clearCharacterList()
                dao.insertCharacterList(characterEntity)
                emit(Resource.Success(characterEntity.map { entity -> entity.toCharacterList() }))
                emit(Resource.Loading(false))
            }

        }

    override suspend fun getCharacter(charId: String): Flow<Resource<CharacterDetail>> =
        flow {

            emit(Resource.Loading(isLoading = true))

            val character =  try {
                api.getCharacterDetail(charId)
            }catch (e : Exception){
                emit(Resource.Error(e))
                null
            }

            character?.let {
                emit(Resource.Success(character.toCharacterDetail()))
                emit(Resource.Loading(isLoading = false))
            }

        }

}