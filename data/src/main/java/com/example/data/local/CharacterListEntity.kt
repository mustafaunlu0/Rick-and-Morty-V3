package com.example.composetestapplication.data.local

import android.webkit.WebStorage.Origin
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterListEntity(
    @PrimaryKey
    val id : Int,
    val name : String,
    val species : String,
    val image : String,
)