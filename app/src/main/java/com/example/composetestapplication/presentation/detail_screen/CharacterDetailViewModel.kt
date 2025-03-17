package com.example.composetestapplication.presentation.detail_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide.init
import com.example.composetestapplication.domain.repository.CharacterRepository
import com.example.composetestapplication.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    val repository : CharacterRepository
) : ViewModel () {

     var state by mutableStateOf(CharacterDetailState())
        private set

    init {
        getCharacter("1")
    }

    fun onEvent(event : CharacterDetailEvent){
        when(event){
            is CharacterDetailEvent.OnGetCharacter -> {
                getCharacter(event.charId)
            }
        }
    }


    private fun getCharacter(charId : String){
        viewModelScope.launch {
            repository.getCharacter(charId).collectLatest {  result ->
                when(result){
                    is Resource.Success -> {
                        state = state.copy(character = result.data)
                    }
                    is Resource.Error -> {
                        println("Error: ${result.error}")
                    }
                    is Resource.Loading -> {
                        state = state.copy(isLoading = result.isLoading)
                    }
                }
            }
        }
    }
}