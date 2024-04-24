package io.github.lexadiky.openmind.feature.bottomnavbar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.lexadiky.openmind.library.arc.socket.Socket

@Composable
fun BottomNavigationBarFragment() {
    val socket = rememberBottomNavigationBarFragmentSocket()
    BottomNavigationBarFragmentImpl(socket.state.value, socket::act)
}

@Composable
private fun rememberBottomNavigationBarFragmentSocket() : Socket<BottomNavigationBarState, BottomNavigationBarAction> {
    return viewModel {
        Socket.ui(
            defaultState = BottomNavigationBarState(),
            reducer = BottomNavigationBarReducer(),
            commandHandlers = emptyList()
        )
    }
}

@Composable
private fun BottomNavigationBarFragmentImpl(
    state: BottomNavigationBarState,
    act: (BottomNavigationBarAction) -> Unit
) {
    NavigationBar {
        state.items.forEach { item ->
            NavigationBarItem(
                selected = item == state.selectedItem,
                onClick = { },
                icon = { Icon(item.icon, stringResource(id = item.label)) },
                label = { Text(text = stringResource(id = item.label)) }
            )
        }
    }
}
