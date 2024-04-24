package io.github.lexadiky.openmind.library.arc.di

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.lexadiky.openmind.library.arc.socket.Socket

interface SocketComponent<TState, TAction> {
    val socket: Socket<TState, TAction>

    interface Factory<TArguments, TState, TAction> {

        fun createSocket(arguments: TArguments): Socket<TState, TAction>
    }
}

@Composable
fun <TArguments, TState, TAction, R> SocketComponent.Factory<TArguments, TState, TAction>.createViewModelSocket(
    arguments: TArguments
): R where R: Socket<TState, TAction>, R: ViewModel {
    @Suppress("UNCHECKED_CAST")
    return viewModel { createSocket(arguments) as ViewModel } as R
}