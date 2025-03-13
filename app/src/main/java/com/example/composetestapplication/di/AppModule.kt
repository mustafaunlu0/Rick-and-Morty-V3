package com.example.composetestapplication.di

import android.app.Application
import androidx.room.Room
import com.example.composetestapplication.data.local.CharacterDatabase
import com.example.composetestapplication.data.remote.CharacterApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideApi() : CharacterApi{
        return Retrofit.Builder()
            .baseUrl(CharacterApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(CharacterApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRoom(app : Application) : CharacterDatabase {
        return Room.databaseBuilder(
            app,
            CharacterDatabase::class.java,
            "character.db"
        ).build()
    }
}