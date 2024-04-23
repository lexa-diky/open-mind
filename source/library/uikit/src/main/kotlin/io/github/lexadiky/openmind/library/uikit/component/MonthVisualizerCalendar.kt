package io.github.lexadiky.openmind.library.uikit.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import io.github.lexadiky.openmind.library.uikit.color.brighten
import io.github.lexadiky.openmind.library.uikit.theme.OpenMindTheme

@Composable
fun MonthVisualizer(modifier: Modifier = Modifier) {
    Matrix(
        columns = 4,
        rows = 7,
        spacing = OpenMindTheme.size.x,
        modifier = modifier,
        item = { _, row ->
            if (row == 0) {
                WeekDayLabel()
            } else {
                DayBox(Color.Red)
            }
        }
    )
}


@Composable
private fun RowScope.DayBox(color: Color) {
    val gradient = remember {

        Brush.radialGradient(
            colors = listOf(
                color,
                color.brighten()
            ),
        )
    }
    Box(
        modifier = Modifier
            .background(gradient, OpenMindTheme.shape.roundRectangle)
            .aspectRatio(1f)
            .weight(1f)
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