package com.example.composetestapplication.presentation.detail_screen

import com.example.composetestapplication.domain.model.CharacterDetail

data class CharacterDetailState (
    val character : CharacterDetail? = null,
    val isLoading :Boolean = false
)