package com.example.composetestapplication.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.composetestapplication.presentation.list_screen.CharacterListingScreen
import com.example.composetestapplication.presentation.navigation.AppNavigation
import com.example.composetestapplication.presentation.theme.ComposeTestApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navHostController = rememberNavController()
            ComposeTestApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.tertiary).padding(vertical = 20.dp)) {
                    Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.tertiary).padding(10.dp), contentAlignment = Alignment.Center) {
                        AppNavigation(navHostController = navHostController)
                    }
                }
            }
        }
    }
}
