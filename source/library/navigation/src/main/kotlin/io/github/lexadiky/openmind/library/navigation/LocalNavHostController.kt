package io.github.lexadiky.openmind.library.navigation

import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController

val LocalNavHostController = compositionLocalOf<NavHostController> {
    error("no ${NavHostController::class.java} is available")
}
