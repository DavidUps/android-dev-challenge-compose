package com.example.androiddevchallenge

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.ui.theme.MyTheme

@ExperimentalStdlibApi
@Composable
fun PuppyApp() {
    MyTheme {
        Surface {
            NavGraph()
        }
    }
}