package io.github.lexadiky.openmind.feature.bottomnavbar

import io.github.lexadiky.openmind.feature.bottomnavbar.entity.BottomNavigationBarItem
import io.github.lexadiky.openmind.library.arc.Reducer
import io.github.lexadiky.openmind.library.arc.command
import io.github.lexadiky.openmind.library.arc.state

internal data class BottomNavigationBarState(
    val items: List<BottomNavigationBarItem> = BottomNavigationBarItem.entries,
    val selectedItem: BottomNavigationBarItem = BottomNavigationBarItem.Me
)

internal sealed interface BottomNavigationBarCommand {

    class Navigate(val item: BottomNavigationBarItem) : BottomNavigationBarCommand
    data object ListenToCurrentRoute : BottomNavigationBarCommand
}

internal sealed interface BottomNavigationBarAction {

    class ItemClicked(val item: BottomNavigationBarItem): BottomNavigationBarAction
    class Navigated(val item: BottomNavigationBarItem): BottomNavigationBarAction
}

internal class BottomNavigationBarReducer : Reducer<BottomNavigationBarState, BottomNavigationBarAction, BottomNavigationBarCommand> {

    override fun reduce(
        state: BottomNavigationBarState,
        action: BottomNavigationBarAction
    ): Reducer.Result<BottomNavigationBarState, BottomNavigationBarCommand> {
        return when (action) {
            is BottomNavigationBarAction.ItemClicked -> command {
                BottomNavigationBarCommand.Navigate(action.item)
                    .takeIf { action.item != state.selectedItem }
            }
            is BottomNavigationBarAction.Navigated -> state {
                state.copy(selectedItem = action.item)
            }
        }
    }
}