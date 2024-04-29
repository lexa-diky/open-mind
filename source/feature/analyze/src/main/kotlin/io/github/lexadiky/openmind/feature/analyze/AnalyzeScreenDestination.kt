@file:OptIn(ExperimentalMaterial3Api::class)

package io.github.lexadiky.openmind.feature.analyze

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.google.auto.service.AutoService
import io.github.lexadiky.openmind.library.arc.socket.Socket
import io.github.lexadiky.openmind.library.navigation.desitnation.ComposeScreenDestination
import io.github.lexadiky.openmind.library.uikit.theme.OpenMindTheme
import io.github.lexadiky.openmind.library.uikit.util.OpenMindPreview

@AutoService(ComposeScreenDestination::class)
class AnalyzeScreenDestination : ComposeScreenDestination<Unit, Unit, Unit> {
    override val route: String = "/analyze"

    @Composable
    override fun Content(state: Unit, act: (Unit) -> Unit) {
        AnalyzeScreen()
    }

    override fun createSocket(arguments: Unit): Socket<Unit, Unit> =
        Socket.noop()
}

@Composable
private fun AnalyzeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Analyze") }
            )
        },
        content = { padding ->

        }
    )
}

@Composable
@OpenMindPreview
private fun Preview_AnalyzeScreen() {
    OpenMindTheme {
        AnalyzeScreen()
    }
}