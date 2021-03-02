package com.example.androiddevchallenge.ui.screens.puppyList

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.screens.puppyList.components.PuppyList
import com.example.androiddevchallenge.ui.screens.puppyList.components.Search

@ExperimentalStdlibApi
@Composable
fun PuppyListScreen(navController: NavController) {

    val petList = Puppy.generate()

    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                Search(filtered = { filter ->
                    petList.filter { it.name == filter }
                })
            },
            content = {
                LazyColumn(modifier = Modifier.fillMaxHeight(), contentPadding = PaddingValues(16.dp)) {
                    itemsIndexed(petList) { index, item ->
                        key(index) {
                            PuppyList(puppy = item, navController = navController, index = index)
                        }
                    }
                }
            },
        )
    }
}