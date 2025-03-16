package com.example.composetestapplication.presentation.detail_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide.init
import com.example.composetestapplication.domain.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    val api : CharacterRepository
) : ViewModel () {


    var state by mutableStateOf(CharacterDetailState())
        private set



    init {
        getCharacter("1")
    }


    fun getCharacter(charId : String){
        println("hey")
    }

}