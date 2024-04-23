package io.github.lexadiky.openmind.library.uikit.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.lexadiky.openmind.library.uikit.theme.OpenMindTheme

@Composable
fun DefaultScaffold() {
    Scaffold(
        bottomBar = {
            DefaultNavigationBar()
        },
        content = { padding ->
            MonthVisualizer(
                modifier = Modifier.padding(padding)
                    .padding(OpenMindTheme.size.x2)
                    .fillMaxWidth()
            )
        }
    )
}