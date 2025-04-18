package com.example.feature.presentation.detail_screen


sealed class CharacterDetailEvent{
    data class OnGetCharacter(val charId : String) : CharacterDetailEvent()
}