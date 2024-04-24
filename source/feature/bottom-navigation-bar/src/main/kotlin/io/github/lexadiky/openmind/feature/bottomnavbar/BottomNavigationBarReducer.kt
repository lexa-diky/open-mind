package io.github.lexadiky.openmind.feature.bottomnavbar

import io.github.lexadiky.openmind.library.arc.Reducer
import io.github.lexadiky.openmind.library.arc.command
import io.github.lexadiky.openmind.library.arc.state

internal class BottomNavigationBarReducer : Reducer<BottomNavigationBarState, BottomNavigationBarAction, BottomNavigationBarCommand> {

    override fun reduce(
        state: BottomNavigationBarState,
        action: BottomNavigationBarAction
    ): Reducer.Result<BottomNavigationBarState, BottomNavigationBarCommand> {
        return when (action) {
            is BottomNavigationBarAction.ItemClicked -> command {
                BottomNavigationBarCommand.Navigate(action.item)
            }
            is BottomNavigationBarAction.Navigated -> state {
                state.copy(selectedItem = action.item)
            }
        }
    }
}