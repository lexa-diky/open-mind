package io.github.lexadiky.openmind.library.uikit.color

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp

fun Color.brighten(coefficient: Float = 1.2f): Color {
    val modVal = coefficient - 1f
    return copy(
        red = (red + modVal).coerceIn(0f..1f),
        green = (green + modVal).coerceIn(0f..1f),
        blue = (blue + modVal).coerceIn(0f..1f),
    )
}


class CoefficientPreviewParameterProvider : PreviewParameterProvider<Float> {
    override val values = sequenceOf(1.2f, 1.4f, 1.6f, 1.8f)
}


@Preview
@Composable
private fun Preview_brighten(
    @PreviewParameter(CoefficientPreviewParameterProvider::class) coefficient: Float
) {
   Row {
       Box(
           modifier = Modifier.size(100.dp)
               .background(Color.Red.brighten(coefficient))
       )
       Box(
           modifier = Modifier.size(100.dp)
               .background(Color.Red)
       )
   }
}