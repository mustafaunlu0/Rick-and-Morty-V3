package com.example.composetestapplication.presentation.list_screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.composetestapplication.domain.model.CharacterListing

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CharacterItem(
    characterListing: CharacterListing,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier.height(150.dp).clip(RoundedCornerShape(16.dp)).background(MaterialTheme.colorScheme.secondary).padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
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
                    .padding(horizontal = 10.dp)
            ) {
                Text(characterListing.name, fontSize = 18.sp)

                Text(characterListing.species, fontSize = 14.sp)

                //Text(characterListing., fontSize = 12.sp)
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(text = characterListing.id.toString(), fontSize = 62.sp, modifier = Modifier.padding(end = 10.dp),)

        }

    }

}

