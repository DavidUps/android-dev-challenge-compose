package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.screens.puppyDetail.PuppyDetailScreen
import com.example.androiddevchallenge.ui.screens.puppyList.PuppyListScreen
import getPuppy

@ExperimentalStdlibApi
@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "puppyList") {
        composable(
            "puppyList"
        ) {
            PuppyListScreen(navController)
        }
        composable(
            "puppyList?puppyDetail={puppy}",
            arguments = listOf(navArgument("puppy") { defaultValue = "" })
        ) { backStackEntry ->
            PuppyDetailScreen(navController, backStackEntry.getPuppy())
        }
    }
}