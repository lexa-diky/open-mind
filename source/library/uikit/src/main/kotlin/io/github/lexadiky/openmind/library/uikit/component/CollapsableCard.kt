package io.github.lexadiky.openmind.library.uikit.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CollapsableCard(
    header: @Composable () -> Unit,
    details: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    isCollapsed: Boolean = false,
) {
    Card(modifier = modifier) {
        Column {
            header()
            AnimatedVisibility(visible = !isCollapsed) {
                details()
            }
        }
    }
}