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
package com.example.androiddevchallenge.ui.screens.puppyDetail.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.feature.puppy.model.Puppy
import com.example.androiddevchallenge.ui.theme.blue
import com.example.androiddevchallenge.ui.theme.purple
import dev.chrisbanes.accompanist.coil.CoilImage

@ExperimentalStdlibApi
@Composable
fun PuppyDetail(puppy: Puppy, navController: NavController) {

    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        CoilImage(
            data = puppy.photo,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            fadeIn = true,
            modifier = Modifier
                .clip(RoundedCornerShape(bottomEnd = 12.dp, bottomStart = 12.dp))
                .weight(0.45f),
            loading = {
                Box(Modifier.matchParentSize()) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            },
            error = { error ->
                Log.w("PuppyAvatar", error.throwable)
            }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.55f)
                .padding(16.dp)
        ) {
            Text(text = puppy.name, style = MaterialTheme.typography.h3)
            Text(
                text = puppy.gender.name.lowercase().capitalize(),
                style = MaterialTheme.typography.body2,
                color = if (puppy.gender == Puppy.Companion.Gender.MALE) blue
                else purple,
            )
            Text(text = puppy.name, style = MaterialTheme.typography.body1)
        }
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(0.47f)
                .fillMaxWidth()
                .padding(end = 16.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            OutlinedButton(
                onClick = {
                    Toast.makeText(context, "Adopted", Toast.LENGTH_SHORT).show()
                    navController.navigateUp()
                },
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(text = "Adoption")
            }
        }
        Spacer(modifier = Modifier.weight(0.53f))
    }
}
