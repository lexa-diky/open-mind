@file:OptIn(ExperimentalComposeUiApi::class)

package io.github.lexadiky.openmind.library.uikit.component

import android.view.MotionEvent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import io.github.lexadiky.openmind.library.uikit.color.brighten
import io.github.lexadiky.openmind.library.uikit.theme.OpenMindTheme

@Composable
fun MonthVisualizer(modifier: Modifier = Modifier) {
    Matrix(
        columns = 5,
        rows = 7,
        spacing = OpenMindTheme.size.x,
        modifier = modifier,
        item = { _, row ->
            if (row == 0) {
                WeekDayLabel()
            } else {
                DayBox(OpenMindTheme.colorScheme.primary.copy(alpha = 1f)) {

                }
            }
        }
    )
}


@Composable
private fun RowScope.DayBox(
    color: Color,
    onClick: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val boxScale by animateFloatAsState(
        targetValue = if (isPressed) 1.1f else 1.0f,
        label = "Box Scale"
    )

    val gradient = remember {
        Brush.radialGradient(
            colors = listOf(
                color,
                color.brighten(),
            ),
        )
    }

    Box(
        modifier = Modifier
            .scale(boxScale)
            .clip(OpenMindTheme.shape.roundRectangle)
            .background(gradient)
            .weight(1f)
            .aspectRatio(1f)
            .clickable(interactionSource, LocalIndication.current) {
                onClick()
            }
    )
}

@Composable
private fun RowScope.WeekDayLabel() {
    Text(
        text = "M",
        style = OpenMindTheme.typography.labelLarge,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .weight(1f)
    )
}