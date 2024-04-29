package io.github.lexadiky.openmind.feature.me

import io.github.lexadiky.openmind.library.arc.di.SocketComponent
import io.github.lexadiky.openmind.library.arc.socket.Socket
import io.github.lexadiky.openmind.library.navigation.NavigatorComponentHolder

internal interface MeScreenComponent : SocketComponent<MeScreenState, MeScreenAction> {

    object Factory : SocketComponent.Factory<Unit, MeScreenState, MeScreenAction> {
        override fun createSocket(arguments: Unit): Socket<MeScreenState, MeScreenAction> {
            val navigatorComponent = NavigatorComponentHolder.get()

            return Socket.ui(
                defaultState = MeScreenState(),
                reducer = MeScreenReducer(),
                commandHandlers = emptyList(),
            )
        }
    }
}

