package com.example.composetestapplication.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CharacterDao {

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    suspend fun insertCharacterList(
        characterList: List<CharacterListEntity>
    )

    @Query("DELETE FROM characterlistentity")
    suspend fun clearCharacterList()

    @Query(
        """
            SELECT * 
            FROM characterlistentity
            WHERE LOWER(name) LIKE '%' || LOWER(:query) || '%'
        """
    )
    suspend fun searchCharacterLşst(query: String) : List<CharacterListEntity>


}