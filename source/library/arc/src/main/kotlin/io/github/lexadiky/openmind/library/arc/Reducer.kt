package io.github.lexadiky.openmind.library.arc

fun interface Reducer<TState, TAction, TCommand> {

    fun reduce(state: TState, action: TAction): Result<TState, TCommand>

    data class Result<TState, TCommand>(
        val state: TState? = null,
        val commands: List<TCommand> = emptyList(),
    )
}

fun <TState, TAction, TCommand> Reducer<TState, TAction, TCommand>.state(block: () -> TState): Reducer.Result<TState, TCommand> {
    return Reducer.Result(state = block())
}

fun <TState, TAction, TCommand> Reducer<TState, TAction, TCommand>.command(block: () -> TCommand): Reducer.Result<TState, TCommand> {
    return Reducer.Result(commands = listOf(block()))
}

fun <TState, TAction, TCommand> Reducer<TState, TAction, TCommand>.result(block: () -> Pair<TState, TCommand>): Reducer.Result<TState, TCommand> {
    val (state, command) = block()
    return Reducer.Result(
        state = state,
        commands = listOf(command)
    )
}
