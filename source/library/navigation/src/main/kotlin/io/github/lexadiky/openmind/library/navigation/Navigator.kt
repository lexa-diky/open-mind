package io.github.lexadiky.openmind.library.navigation

import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

interface Navigator {
    val currentRoute: StateFlow<String>
    fun navigate(route: String)

    companion object {

        const val DEFAULT_ROUTE = "/"
    }
}

internal class JetpackNavigator(
    private val controller: NavHostController
) : Navigator {
    private val scope = CoroutineScope(Dispatchers.Main)

    override val currentRoute: MutableStateFlow<String> = MutableStateFlow(Navigator.DEFAULT_ROUTE)

    init {
        scope.launch {
            controller.currentBackStackEntryFlow.collectLatest { backStackEntry ->
                currentRoute.value = backStackEntry.destination.route ?: Navigator.DEFAULT_ROUTE
            }
        }
    }

    override fun navigate(route: String) {
        controller.currentBackStackEntryFlow.map { it.id }
        scope.launch {
            controller.navigate(route)
        }
    }
}