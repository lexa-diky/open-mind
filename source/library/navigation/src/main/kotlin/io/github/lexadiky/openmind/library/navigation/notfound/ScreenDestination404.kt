@file:OptIn(ExperimentalMaterial3Api::class)

package io.github.lexadiky.openmind.library.navigation.notfound

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import io.github.lexadiky.openmind.library.arc.socket.Socket
import io.github.lexadiky.openmind.library.navigation.desitnation.ComposeScreenDestination
import io.github.lexadiky.openmind.library.navigation.desitnation.ComposeDialogDestination
import io.github.lexadiky.openmind.library.navigation.Navigator
import io.github.lexadiky.openmind.library.navigation.R
import io.github.lexadiky.openmind.library.uikit.theme.OpenMindTheme

class ScreenDestination404 : ComposeScreenDestination<Unit, Unit, Unit> {
    override val route: String = Navigator.NOT_FOUND_ROUTE

    @Composable
    override fun Content(state: Unit, act: (Unit) -> Unit) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.library_navigation_404_title))
                    },
                )
            },
            content = { padding ->
                Column {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = OpenMindTheme.colorScheme
                                .errorContainer
                        ),
                        modifier = Modifier
                            .padding(padding)
                            .padding(OpenMindTheme.size.x2)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(OpenMindTheme.size.x2)
                        ) {
                            Text(
                                text = stringResource(id = R.string.library_navigation_404_message)
                            )
                        }
                    }
                }
            }
        )
    }

    override fun createSocket(arguments: Unit): Socket<Unit, Unit> =
        Socket.noop()
}
