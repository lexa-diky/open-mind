package io.github.lexadiky.openmind.library.navigation

import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

interface Navigator {
    fun navigate(route: String)
}

internal class JetpackNavigator(
    private val controller: NavHostController
) : Navigator {
    private val scope = CoroutineScope(Dispatchers.Main)

    override fun navigate(route: String) {
        scope.launch {
            controller.navigate(route)
        }
    }
}