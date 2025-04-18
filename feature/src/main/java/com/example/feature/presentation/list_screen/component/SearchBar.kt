package com.example.feature.presentation.list_screen.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    query : String,
    onQueryChange : (String) -> Unit,
){
    OutlinedTextField(
        value = query,
        onValueChange = { query ->
            onQueryChange.invoke(query)
        },
        modifier = Modifier.padding(0.dp).fillMaxWidth(),
        placeholder = {
            Text("Search..")
        },
        maxLines = 1,
        singleLine = true
    )
}