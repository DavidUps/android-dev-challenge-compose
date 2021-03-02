/*
package com.example.androiddevchallenge.ui.screens.puppyList.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R

@Composable
fun DetailScreen() {

    Surface(color = MaterialTheme.colors.background) {

        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Box(
                Modifier
                    .weight(0.55f)
                    .fillMaxWidth()
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    painter = painterResource(R.drawable.cocker),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .weight(0.45f)
                    .padding(bottom = 56.dp, start = 24.dp, end = 24.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                Spacer(modifier = Modifier.height(height = 96.dp))
                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    text = "${"dog.name"} arrived to the shelter today.  is a puppy and... in true puppy fashion, will need your time and dedication."
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Box(
                modifier = Modifier
                    .weight(0.55f)
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Surface(
                    elevation = 2.dp,
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colors.surface,
                    modifier = Modifier
                        .height(height = 96.dp)
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .offset(y = 66.dp)
                ) {

                    Column(
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 24.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "dog.name",
                                style = TextStyle(
                                    color = MaterialTheme.colors.onSurface,
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start)
                        ) {

                            Text(
                                text = "dog.age",
                                style = TextStyle(
                                    color = Color.Gray,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium,
                                )
                            )
                            Text(
                                text = "dog.type",
                                style = TextStyle(
                                    color = MaterialTheme.colors.primary,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                )
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.Start)
                        ) {

                            */
/*Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.ic_outline_location_on_24),
                                tint = Color.Black,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(18.dp)
                            )*//*

                            Text(
                                text = "Çankaya",
                                style = TextStyle(
                                    color = Color.Gray,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium,
                                )
                            )
                            Text(
                                text = ", Ankara",
                                style = TextStyle(
                                    color = MaterialTheme.colors.onSurface,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                )
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.weight(0.45f))
        }

    }
}

@Preview
@Composable
fun PreviewPuppyListTest2() {
    Scaffold {
        DetailScreen()
    }
}*/
