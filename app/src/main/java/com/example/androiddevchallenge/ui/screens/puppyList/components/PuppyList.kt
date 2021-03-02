/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screens.puppyList.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.popUpTo
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.model.Puppy.Companion.Gender.MALE
import com.example.androiddevchallenge.ui.theme.blue
import com.example.androiddevchallenge.ui.theme.purple
import com.google.gson.Gson
import dev.chrisbanes.accompanist.coil.CoilImage

@ExperimentalStdlibApi
@Composable
fun PuppyList(puppy: Puppy, navController: NavController, index: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(top = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            Column(
                Modifier
                    .weight(0.70f)
            ) {}
            Column(
                Modifier
                    .weight(0.40f)
            ) {
                ListRowCard(puppy)
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clickable {
                    navController.navigate("puppyDetail/${Gson().toJson(puppy)}") {
                        popUpTo(route = "puppyList") {}
                    }
                }
        ) {
            Box(
                modifier = Modifier
                    .weight(0.90f)
                    .fillMaxWidth()
            ) {
                ListPuppyImg(puppy = puppy)
            }
            Spacer(modifier = Modifier.weight(0.10f))
        }
    }
}

@ExperimentalStdlibApi
@Composable
fun ListRowCard(puppy: Puppy) {

    val topLeftRad = 12.dp
    val topRightRad = 12.dp
    val bottomLeftRad = 12.dp
    val bottomRightRad = 12.dp

    Card(
        Modifier
            .height(height = 150.dp),
        shape = RoundedCornerShape(
            topStart = topLeftRad,
            topEnd = topRightRad,
            bottomStart = bottomLeftRad,
            bottomEnd = bottomRightRad
        ),
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(16.dp)
                    .weight(0.70f)
            ) {
                Text(
                    text = puppy.name,
                    style = MaterialTheme.typography.h5
                )
                Text(
                    text = puppy.gender.name.lowercase().capitalize(),
                    style = MaterialTheme.typography.body2,
                    color = if (puppy.gender == MALE) blue
                    else purple,
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .padding(16.dp)
                    .weight(0.30f)
            ) {
                Text(
                    text = "Age: ${puppy.age}",
                    style = MaterialTheme.typography.subtitle2
                )
            }
        }
    }
}

@Composable
fun ListPuppyImg(puppy: Puppy) {
    Surface(
        Modifier
            .fillMaxWidth()
            .size(width = 0.dp, height = 200.dp)
            .padding(start = 24.dp, end = 24.dp),
        shape = RoundedCornerShape(size = 12.dp),
        color = MaterialTheme.colors.secondary,
        elevation = 5.dp
    ) {
        CoilImage(
            data = puppy.photo,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            fadeIn = true,
            modifier = Modifier
                .size(width = 150.dp, height = 200.dp)
                .clip(RoundedCornerShape(size = 12.dp)),
            loading = {
                Box(Modifier.matchParentSize()) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            },
            error = { error ->
                Log.w("PuppyAvatar", error.throwable)
            }
        )
    }
}

@ExperimentalStdlibApi
@Preview
@Composable
fun preview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        Column(
            Modifier
                .weight(0.70f)
        ) {}
        Column(
            Modifier
                .weight(0.40f)
        ) {
            ListRowCard(
                Puppy(
                    "Polla",
                    "https://www.anicura.es/globalassets/group/breed-tool/images-dogs/cocker-spaniel.jpg",
                    MALE,
                    2
                )
            )
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(0.90f)
                .fillMaxWidth()
        ) {
            ListPuppyImg(
                Puppy(
                    "Polla",
                    "https://www.anicura.es/globalassets/group/breed-tool/images-dogs/cocker-spaniel.jpg",
                    MALE,
                    2
                )
            )
        }
        Spacer(modifier = Modifier.weight(0.10f))
    }
}
