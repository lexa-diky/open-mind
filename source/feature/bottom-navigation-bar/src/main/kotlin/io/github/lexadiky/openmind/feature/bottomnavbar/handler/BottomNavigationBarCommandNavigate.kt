package io.github.lexadiky.openmind.feature.bottomnavbar.handler

import io.github.lexadiky.openmind.feature.bottomnavbar.BottomNavigationBarAction
import io.github.lexadiky.openmind.feature.bottomnavbar.BottomNavigationBarCommand
import io.github.lexadiky.openmind.library.arc.CommandHandler
import io.github.lexadiky.openmind.library.navigation.Navigator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map

internal class BottomNavigationBarCommandNavigate(
    private val navigator: Navigator,
) : CommandHandler<BottomNavigationBarAction, BottomNavigationBarCommand> {

    override fun handle(flow: Flow<BottomNavigationBarCommand>): Flow<BottomNavigationBarAction> {
        return flow.filterIsInstance<BottomNavigationBarCommand.Navigate>()
            .distinctUntilChanged()
            .map { navigate ->
                navigator.navigate(navigate.item.route)
                BottomNavigationBarAction.Navigated(navigate.item)
            }
    }
}