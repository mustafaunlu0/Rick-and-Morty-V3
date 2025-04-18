package com.example.feature.presentation.detail_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CharacterDetailScreen(
    charID : String,
    viewModel: CharacterDetailViewModel = hiltViewModel()
) {

    val state = viewModel.state

    LaunchedEffect(true) {
        viewModel.onEvent(CharacterDetailEvent.OnGetCharacter(charID))
    }


    state.character?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp),
        ) {

            GlideImage(
                model = it.image,
                contentDescription = "Character Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .width(250.dp)
                    .height(250.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .align(Alignment.CenterHorizontally)

            )

            Text(
                it.name,
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp),
                fontSize = 25.sp
            )

            Text(
                it.gender,
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp),
                fontSize = 25.sp
            )

            Text(
                it.species,
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp),
                fontSize = 25.sp
            )

            Text(
                it.status,
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp),
                fontSize = 25.sp
            )

        }
    }



}