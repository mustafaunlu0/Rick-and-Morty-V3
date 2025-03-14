package com.example.composetestapplication.di

import com.example.composetestapplication.data.repository.CharacterRepositoryImpl
import com.example.composetestapplication.domain.repository.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCharacterRepository(characterRepositoryImpl: CharacterRepositoryImpl) : CharacterRepository

}