package io.github.lexadiky.openmind.feature.settings

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.google.auto.service.AutoService
import io.github.lexadiky.openmind.library.arc.socket.Socket
import io.github.lexadiky.openmind.library.navigation.ComposeDestination

@AutoService(ComposeDestination::class)
class SettingsDestination : ComposeDestination<Unit, Unit, Unit> {
    override val route: String = "/settings"

    @Composable
    override fun Content(state: Unit, act: (Unit) -> Unit) {
        Text(text = "Settings")
    }

    override fun createSocket(arguments: Unit): Socket<Unit, Unit> =
        Socket.noop()
}