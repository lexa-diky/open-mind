package io.github.lexadiky.openmind.feature.bottomnavbar

import io.github.lexadiky.openmind.feature.bottomnavbar.handler.BottomNavigationBarCommandListenToCurrentRoute
import io.github.lexadiky.openmind.feature.bottomnavbar.handler.BottomNavigationBarCommandNavigate
import io.github.lexadiky.openmind.library.arc.di.SocketComponent
import io.github.lexadiky.openmind.library.arc.socket.Socket
import io.github.lexadiky.openmind.library.navigation.NavigatorComponentHolder

internal interface BottomNavigationBarComponent : SocketComponent<BottomNavigationBarState, BottomNavigationBarAction> {

    object Factory : SocketComponent.Factory<Unit, BottomNavigationBarState, BottomNavigationBarAction> {
        override fun createSocket(arguments: Unit): Socket<BottomNavigationBarState, BottomNavigationBarAction> {
            val navigatorComponent = NavigatorComponentHolder.get()

            val handlers = listOf(
                BottomNavigationBarCommandNavigate(navigatorComponent.navigator),
                BottomNavigationBarCommandListenToCurrentRoute(navigatorComponent.navigator)
            )

            return Socket.ui(
                defaultState = BottomNavigationBarState(),
                reducer = BottomNavigationBarReducer(),
                commandHandlers = handlers,
                initCommands = listOf(BottomNavigationBarCommand.ListenToCurrentRoute)
            )
        }
    }
}

