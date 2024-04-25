package io.github.lexadiky.openmind.library.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NoopNavigator : Navigator {
    override val currentRoute: StateFlow<String> = MutableStateFlow(Navigator.DEFAULT_ROUTE)

    override fun navigate(route: String) = Unit

    override fun back() = Unit
}