package com.example.composetestapplication.presentation.list_screen

import android.widget.Switch
import android.widget.TextView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composetestapplication.presentation.list_screen.component.CharacterItem
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

        OutlinedTextField(
            value = state.searchQuery.orEmpty(),
            onValueChange = { query ->
                viewModel.onEvent(CharacterListEvent.OnSearchQueryChange(query))
            },
            modifier = Modifier.padding(0.dp).fillMaxWidth(),
            placeholder = {
                Text("Search..")
            },
            maxLines = 1,
            singleLine = true
        )
        SwipeRefresh(swipeRefreshState,
            onRefresh = { viewModel.onEvent(CharacterListEvent.Refresh) }) {

            LazyColumn(Modifier.fillMaxSize().padding(top = 8.dp)) {

                items(state.characters.size) { i ->

                    val character = state.characters[i]
                    CharacterItem(modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),characterListing = character){ charId ->
                        onCharacterClick(charId)
                    }

                    if (i < state.characters.size -1) {
                        HorizontalDivider(thickness = 2.dp, color = Color.Black, modifier = Modifier.padding(16.dp))
                    }
                }


            }


        }


    }

}