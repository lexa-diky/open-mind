package io.github.lexadiky.openmind.library.arc.socket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.lexadiky.openmind.library.arc.CommandHandler
import io.github.lexadiky.openmind.library.arc.Reducer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch

class UiSocket<TState : Any, TAction, TCommand>(
    defaultState: TState,
    private val reducer: Reducer<TState, TAction, TCommand>,
    private val commandHandlers: List<CommandHandler<TAction, TCommand>>,
    private val initCommands: List<TCommand>,
) : Socket<TState, TAction>, ViewModel() {
    private val actionQueue: Channel<TAction> = Channel()
    private val commandQueue: Channel<TCommand> = Channel()

    override val state: MutableStateFlow<TState> = MutableStateFlow(defaultState)

    init {
        viewModelScope.launch {
            initCommands.forEach { commandQueue.send(it) }
        }

        val sharedActions = commandQueue.consumeAsFlow()
            .shareIn(CoroutineScope(Dispatchers.IO + SupervisorJob()), SharingStarted.Eagerly)

        commandHandlers.forEach { handler ->
            viewModelScope.launch {
                handler.handle(sharedActions).collect { action ->
                    act(action)
                }
            }
        }

        viewModelScope.launch {
            for (action in actionQueue) {
                val reduction = reducer.reduce(state.value, action)
                reduction.state?.let { state.value = it }
                reduction.commands.forEach { commandQueue.send(it) }
            }
        }
    }

    override fun act(action: TAction) {
        viewModelScope.launch {
            actionQueue.send(action)
        }
    }
}