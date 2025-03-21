package com.example.composetestapplication.presentation.list_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetestapplication.domain.model.CharacterListing
import com.example.composetestapplication.domain.repository.CharacterRepository
import com.example.composetestapplication.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    var state by mutableStateOf(CharacterListState())
        private set

    private var job : Job? = null

    init {
        getCharacters()
    }


    fun onEvent(event: CharacterListEvent) {
        when (event) {
            is CharacterListEvent.Refresh -> {
                getCharacters(fetchFromRemote = true)
            }

            is CharacterListEvent.OnSearchQueryChange -> {
                state = state.copy(searchQuery = event.query)
                job?.cancel()
                job = viewModelScope.launch {
                    delay(500L)
                    getCharacters()
                }
            }
        }
    }

    private fun getCharacters(
        fetchFromRemote: Boolean = false,
        query: String = state.searchQuery.orEmpty()
    ) {
        viewModelScope.launch {
            repository.getCharacters(
                fetchFromRemote,
                query
            ).collectLatest { result ->

                when (result) {
                    is Resource.Success -> {
                        state = state.copy(characters = result.data.orEmpty())
                    }

                    is Resource.Error -> { println("Error: ${result.error}") }

                    is Resource.Loading -> { state = state.copy(isLoading = result.isLoading) }
                }
            }
        }
    }
}