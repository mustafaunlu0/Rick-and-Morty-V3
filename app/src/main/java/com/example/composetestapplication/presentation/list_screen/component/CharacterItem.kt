package com.example.composetestapplication.presentation.list_screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.composetestapplication.domain.model.CharacterListing

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CharacterItem(
    characterListing: CharacterListing,
    modifier: Modifier = Modifier,
    onCharacterClick : (String) -> Unit
) {

    Box(
        modifier = modifier.height(150.dp).clip(RoundedCornerShape(16.dp)).background(MaterialTheme.colorScheme.secondary).padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth().clickable {
                    onCharacterClick(characterListing.id.toString())
                },
            verticalAlignment = Alignment.CenterVertically,
        ) {

            GlideImage(
                model = characterListing.image,
                contentDescription = characterListing.name,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .clip(RoundedCornerShape(16.dp))
            )

            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 10.dp).weight(1f)
            ) {
                Text(characterListing.name, fontSize = 18.sp, maxLines =  1,   overflow = TextOverflow.Ellipsis )

                Text(characterListing.species, fontSize = 14.sp)

            }
            Text(text = characterListing.id.toString(), fontSize = 62.sp, modifier = Modifier.padding(end = 10.dp),)
        }

    }

}

