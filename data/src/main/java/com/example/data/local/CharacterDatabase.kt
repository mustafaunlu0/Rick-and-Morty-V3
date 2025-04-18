package com.example.composetestapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [CharacterListEntity::class],
    version = 1
)
abstract class CharacterDatabase : RoomDatabase(){
    abstract val dao : CharacterDao
}