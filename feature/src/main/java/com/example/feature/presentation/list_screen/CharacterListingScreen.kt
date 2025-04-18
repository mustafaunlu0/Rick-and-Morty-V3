package com.example.feature.presentation.list_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feature.presentation.list_screen.component.CharacterList
import com.example.feature.presentation.list_screen.component.SearchBar
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@Composable
fun CharacterListingScreen(
    viewModel : CharacterListViewModel = hiltViewModel(),
    onCharacterClick : (String) -> Unit
) {

    val state = viewModel.state
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = state.isRefreshing)

    Column(modifier = Modifier.fillMaxSize()) {

        SearchBar(
            query = state.searchQuery ?: ""
        ) {
            viewModel.onEvent(CharacterListEvent.OnSearchQueryChange(it))
        }

        SwipeRefresh(swipeRefreshState,
            onRefresh = { viewModel.onEvent(CharacterListEvent.Refresh) }) {
            CharacterList(
                state.characters,
            ){ characterId ->
                onCharacterClick(characterId)
            }
        }

    }

}