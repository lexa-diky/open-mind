package io.github.lexadiky.openmind.library.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import io.github.lexadiky.openmind.library.navigation.desitnation.AnyComposeDialogDestination
import io.github.lexadiky.openmind.library.navigation.desitnation.AnyComposeScreenDestination
import io.github.lexadiky.openmind.library.navigation.desitnation.ComposeDialogDestination
import io.github.lexadiky.openmind.library.navigation.desitnation.ComposeScreenDestination
import io.github.lexadiky.openmind.library.navigation.notfound.ScreenDestination404
import java.util.ServiceLoader

@Composable
@Suppress("UNCHECKED_CAST")
internal fun rememberComposeScreenDestinationList(): State<List<AnyComposeScreenDestination>?> {
    val state = remember {
        mutableStateOf(emptyList<ComposeScreenDestination<Any, Any, Any>>())
    }

    LaunchedEffect(Unit) {
        val composeDestinations = ServiceLoader.load(ComposeScreenDestination::class.java)
            .toList() as List<AnyComposeScreenDestination>
        val destination404 = ScreenDestination404() as AnyComposeScreenDestination

        state.value = composeDestinations + destination404
    }

    return state
}

@Composable
@Suppress("UNCHECKED_CAST")
internal fun rememberComposeDialogDestinationList(): State<List<AnyComposeDialogDestination>?> {
    val state = remember {
        mutableStateOf(emptyList<ComposeDialogDestination<Any, Any, Any>>())
    }

    LaunchedEffect(Unit) {
        state.value = ServiceLoader.load(ComposeDialogDestination::class.java)
            .toList() as List<AnyComposeDialogDestination>
    }

    return state
}