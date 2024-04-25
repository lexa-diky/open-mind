@file:OptIn(ExperimentalCoroutinesApi::class)

package io.github.lexadiky.openmind.library.arc.util

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.flatMapLatest

inline fun <reified E, O> Flow<Any>.react(
    noinline block: suspend (E) -> Unit
): Flow<O> {
    return filterIsInstance<E>()
        .flatMapLatest { command ->
            block(command)
            emptyFlow()
        }
}