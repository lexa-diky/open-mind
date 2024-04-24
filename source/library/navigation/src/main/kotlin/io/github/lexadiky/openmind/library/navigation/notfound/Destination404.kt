package io.github.lexadiky.openmind.library.navigation.notfound

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import io.github.lexadiky.openmind.library.arc.socket.Socket
import io.github.lexadiky.openmind.library.navigation.ComposeDestination

class Destination404 : ComposeDestination<Unit, Unit, Unit> {
    override val route: String = ".*"

    @Composable
    override fun Content(state: Unit, act: (Unit) -> Unit) {
        Text(text = "404 Not Found")
    }

    override fun createSocket(arguments: Unit): Socket<Unit, Unit> =
        Socket.noop()
}