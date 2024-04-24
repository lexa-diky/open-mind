package io.github.lexadiky.openmind.library.arc

import kotlinx.coroutines.flow.Flow

fun interface CommandHandler<TAction, TCommand> {

    fun handle(flow: Flow<TCommand>): Flow<TAction>
}
