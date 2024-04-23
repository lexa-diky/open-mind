package io.github.lexadiky.openmind.library.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import java.util.ServiceLoader
import kotlinx.coroutines.delay

@Composable
fun rememberDestinationList(): State<List<Destination>?> {
    val state = remember {
        mutableStateOf(emptyList<Destination>())
    }

    LaunchedEffect(Unit) {
        state.value = ServiceLoader.load(Destination::class.java)
            .toList()
    }

    return state
}