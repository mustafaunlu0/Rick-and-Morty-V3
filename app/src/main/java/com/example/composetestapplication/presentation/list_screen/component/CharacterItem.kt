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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
        modifier = modifier.height(150.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            GlideImage(
                model = "https://picsum.photos/200/300",
                contentDescription = characterListing.name,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .background(Color.Black)
            )

            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 10.dp)
                    .background(Color.Red)
            ) {
                Text("Rick Sanchez", fontSize = 18.sp)

                Text("Male", fontSize = 14.sp)

                Text("Human", fontSize = 12.sp)
            }

            Spacer(modifier = Modifier.weight(1f))

            Text("1", fontSize = 62.sp, modifier = Modifier.padding(end = 10.dp))

        }

    }

}

