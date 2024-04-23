package io.github.lexadiky.openmind.library.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationHost() {
    val destinations by rememberDestinationList()
    val controller = rememberNavController()

    if (!destinations.isNullOrEmpty()) {
        CompositionLocalProvider(LocalNavHostController provides controller) {
            NavHost(navController = controller, startDestination = "/") {
                destinations?.forEach { destination ->
                    composable(
                        destination.route,
                        content = { destination.Content() }
                    )
                }
            }
        }
    }
}
