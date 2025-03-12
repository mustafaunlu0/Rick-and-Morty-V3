package com.example.composetestapplication.presentation.list_screen

import com.example.composetestapplication.domain.model.CharacterListing

data class CharacterListState(
    val characters : List<CharacterListing> = emptyList(),
    val isLoading : Boolean = false,
    val isRefreshing : Boolean = false,
    val searchQuery : String? = null
)