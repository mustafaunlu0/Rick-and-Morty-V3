package com.example.composetestapplication.presentation.list_screen

sealed class CharacterListEvent {
    data object Refresh : CharacterListEvent()
    data class OnSearchQueryChange(val query : String) : CharacterListEvent()
}