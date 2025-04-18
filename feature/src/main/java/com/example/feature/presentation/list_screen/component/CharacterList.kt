package com.example.feature.presentation.list_screen.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composetestapplication.domain.model.CharacterListing

@Composable
fun CharacterList(
    characters : List<CharacterListing>,
    onCharacterClick : (String) -> Unit
){
    LazyColumn(Modifier.fillMaxSize().padding(top = 8.dp)) {
        itemsIndexed(characters, key = { _, item ->  item.id}) {  index, character ->
            CharacterItem(modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),characterListing = character){ charId ->
                onCharacterClick(charId)
            }

            if (index < characters.size -1) {
                HorizontalDivider(thickness = 2.dp, color = Color.Black, modifier = Modifier.padding(16.dp))
            }
        }

    }
}