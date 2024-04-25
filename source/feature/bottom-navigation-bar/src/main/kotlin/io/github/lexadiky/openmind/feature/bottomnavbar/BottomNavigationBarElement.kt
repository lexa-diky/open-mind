package io.github.lexadiky.openmind.feature.bottomnavbar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.lexadiky.openmind.library.arc.di.createViewModelSocket
import io.github.lexadiky.openmind.library.uikit.util.OpenMindPreview

@Composable
fun BottomNavigationBarElement() {
    val socket = BottomNavigationBarComponent.Factory.createViewModelSocket(Unit)
    val state by socket.state.collectAsState()
    BottomNavigationBarElementImpl(state, socket::act)
}

@Composable
private fun BottomNavigationBarElementImpl(
    state: BottomNavigationBarState,
    act: (BottomNavigationBarAction) -> Unit
) {
    NavigationBar {
        state.items.forEach { item ->
            NavigationBarItem(
                selected = item == state.selectedItem,
                onClick = { act(BottomNavigationBarAction.ItemClicked(item)) },
                icon = { Icon(item.icon, stringResource(id = item.label)) },
                label = { Text(text = stringResource(id = item.label)) }
            )
        }
    }
}

@Composable
@OpenMindPreview
fun Preview_BottomNavigationBarElement() {
    BottomNavigationBarElementImpl(
        state = BottomNavigationBarState(),
        act = {}
    )
}