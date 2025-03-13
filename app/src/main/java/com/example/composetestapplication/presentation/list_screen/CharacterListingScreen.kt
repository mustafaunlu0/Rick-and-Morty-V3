package com.example.composetestapplication.presentation.list_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@Composable
fun CharacterListingScreen(
    viewModel : CharacterListViewModel = hiltViewModel()
){
    val state = viewModel.state
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = state.isRefreshing)

}