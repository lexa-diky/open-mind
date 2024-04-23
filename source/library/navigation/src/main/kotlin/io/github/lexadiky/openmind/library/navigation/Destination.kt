package io.github.lexadiky.openmind.library.navigation

import androidx.compose.runtime.Composable


interface Destination {
    val route: String

    @Composable
    fun Content()
}