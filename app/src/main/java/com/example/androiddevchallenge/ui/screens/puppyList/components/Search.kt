package com.example.androiddevchallenge.ui.screens.puppyList.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.purple700

@Composable
fun Search(filtered: (String) -> Unit) {
    val (text, etSearch) = remember {
        mutableStateOf("")
    }
    Card(
        elevation = 0.dp,
        shape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 0.dp,
            bottomStart = 16.dp,
            bottomEnd = 16.dp,
        ),
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = purple700
    ) {
        Card(
            backgroundColor = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp),
        ) {
            Box {
                TextField(
                    value = text,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    label = { Text(text = "Search") },
                    onValueChange = {
                        etSearch(it)
                        filtered(it)
                    }
                )
            }
        }
    }
}