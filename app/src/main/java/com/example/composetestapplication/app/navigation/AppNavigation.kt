package com.example.composetestapplication.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.feature.presentation.detail_screen.CharacterDetailScreen
import com.example.feature.presentation.list_screen.CharacterListingScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
){

    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = Screen.CharacterListing.route) {

        composable(
            route = Screen.CharacterListing.route
        ){
            CharacterListingScreen{
                navHostController.navigate(Screen.CharacterDetail.route + "/$it")
            }
        }

        composable(
            route = Screen.CharacterDetail.route + "/{charId}",
            arguments = listOf(
                navArgument("charId"){
                    type = NavType.StringType
                }
            )
        ){ backStackEntry ->
            val charId  = backStackEntry.arguments?.getString("charId")
            CharacterDetailScreen(charID = charId.orEmpty())
        }

    }

}

sealed class Screen(val route : String) {
    data object CharacterListing : Screen("character_listing")
    data object CharacterDetail : Screen("character_detail")
}
