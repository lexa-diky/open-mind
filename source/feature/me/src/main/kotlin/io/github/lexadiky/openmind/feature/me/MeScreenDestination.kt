@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)

package io.github.lexadiky.openmind.feature.me

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.auto.service.AutoService
import io.github.lexadiky.openmind.feature.me.record.sleep.SleepRecordElement
import io.github.lexadiky.openmind.library.arc.socket.Socket
import io.github.lexadiky.openmind.library.navigation.desitnation.ComposeScreenDestination
import io.github.lexadiky.openmind.library.uikit.theme.OpenMindTheme
import io.github.lexadiky.openmind.library.uikit.util.OpenMindPreview
import io.github.lexadiky.openmind.library.uikit.util.noBottom

@AutoService(ComposeScreenDestination::class)
class MeScreenDestination : ComposeScreenDestination<Unit, MeScreenState, MeScreenAction> {
    override val route: String = "/me"

    @Composable
    override fun Content(state: MeScreenState, act: (MeScreenAction) -> Unit) {
        MeScreen(state, act)
    }

    override fun createSocket(arguments: Unit): Socket<MeScreenState, MeScreenAction> =
        MeScreenComponent.Factory.createSocket(arguments)
}

@Composable
private fun MeScreen(state: MeScreenState, act: (MeScreenAction) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Me") })
        },
        content = { padding ->
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(OpenMindTheme.size.x2),
                modifier = Modifier
                    .padding(padding.noBottom())
                    .fillMaxWidth()
            ) {
                item {
                    SleepRecordElement()
                }
            }
        }
    )
}


@Composable
@OpenMindPreview
private fun Preview_MeScreen() {
    OpenMindTheme {
        MeScreen(MeScreenState()) { }
    }
}
