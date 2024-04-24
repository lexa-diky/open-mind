package io.github.lexadiky.openmind.library.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import io.github.lexadiky.openmind.library.navigation.notfound.Destination404
import java.util.ServiceLoader

@Composable
@Suppress("UNCHECKED_CAST")
fun rememberDestinationList(): State<List<AnyComposeDestination>?> {
    val state = remember {
        mutableStateOf(emptyList<ComposeDestination<Any, Any, Any>>())
    }

    LaunchedEffect(Unit) {
        val composeDestinations = ServiceLoader.load(ComposeDestination::class.java)
            .toList() as List<AnyComposeDestination>
        val destination404 = Destination404() as AnyComposeDestination

        state.value = composeDestinations + destination404
    }

    return state
}