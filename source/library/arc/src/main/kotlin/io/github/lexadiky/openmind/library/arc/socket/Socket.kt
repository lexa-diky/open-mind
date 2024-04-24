package io.github.lexadiky.openmind.library.arc.socket

import androidx.lifecycle.ViewModel
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
            commandHandlers: List<CommandHandler<TAction, TCommand>>,
            initCommands: List<TCommand> = emptyList()
        ): UiSocket<TState, TAction, TCommand> {
            return UiSocket(defaultState, reducer, commandHandlers, initCommands)
        }

        fun noop(): Socket<Unit, Unit> = object : Socket<Unit, Unit>, ViewModel() {
            override val state: StateFlow<Unit> = MutableStateFlow(Unit)
            override fun act(action: Unit) = Unit
        }
    }
}
