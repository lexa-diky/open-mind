package io.github.lexadiky.openmind.library.arc

fun interface Reducer<TState, TAction, TCommand> {

    fun reduce(state: TState, action: TAction): Reducer.Result<TState, TCommand>

    data class Result<TState, TCommand>(
        val state: TState? = null,
        val action: TCommand? = null,
    )
}
