package io.github.lexadiky.openmind.library.uikit.util

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp

@Composable
fun PaddingValues.noBottom(): PaddingValues {
    val layoutDirection = LocalLayoutDirection.current
    return remember(this) {
        PaddingValues.Absolute(
            left = this.calculateLeftPadding(layoutDirection),
            right = this.calculateRightPadding(layoutDirection),
            top = this.calculateTopPadding(),
            bottom = 0.dp
        )
    }
}