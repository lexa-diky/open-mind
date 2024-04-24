package io.github.lexadiky.openmind.library.arc.socket

import io.github.lexadiky.openmind.library.arc.CommandHandler
import io.github.lexadiky.openmind.library.arc.Reducer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface Socket<TState, TAction> {

    val state: StateFlow<TState>

    fun act(action: TAction)

    companion object {

        fun <TState: Any, TAction, TCommand> ui(
            defaultState: TState,
            reducer: Reducer<TState, TAction, TCommand>,
            commandHandlers: List<CommandHandler<TAction, TCommand>>
        ): UiSocket<TState, TAction, TCommand> {
            return UiSocket(defaultState, reducer, commandHandlers)
        }

        fun noop(): Socket<Unit, Unit> = object : Socket<Unit, Unit> {
            override val state: StateFlow<Unit> = MutableStateFlow(Unit)
            override fun act(action: Unit) = Unit
        }
    }
}

