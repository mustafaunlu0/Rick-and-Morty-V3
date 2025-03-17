package com.example.composetestapplication.presentation.detail_screen

import com.example.composetestapplication.domain.model.CharacterDetail

sealed class CharacterDetailEvent{
    data class OnGetCharacter(val charId : String) : CharacterDetailEvent()
}