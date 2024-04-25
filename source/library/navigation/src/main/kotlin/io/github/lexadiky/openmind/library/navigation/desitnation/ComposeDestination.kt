package io.github.lexadiky.openmind.library.navigation.desitnation

import androidx.compose.runtime.Composable
import io.github.lexadiky.openmind.library.arc.di.SocketComponent

typealias AnyComposeDestination = ComposeDestination<Any, Any, Any>

interface ComposeDestination<TArguments, TState, TAction> :
    SocketComponent.Factory<TArguments, TState, TAction> {

    val route: String

    @Composable
    fun Content(state: TState, act: (TAction) -> Unit)
}