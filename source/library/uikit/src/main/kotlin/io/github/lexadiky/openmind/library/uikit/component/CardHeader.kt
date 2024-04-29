package io.github.lexadiky.openmind.library.uikit.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import io.github.lexadiky.openmind.library.uikit.theme.OpenMindTheme
import io.github.lexadiky.openmind.library.uikit.util.OpenMindPreview

@Composable
fun CardHeader(
    text: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    icon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.End
    ) {
        if (icon != null) {
            icon()
            Spacer(modifier = Modifier.size(OpenMindTheme.size.x))
        }
        CompositionLocalProvider(LocalTextStyle provides OpenMindTheme.typography.titleMedium) {
            Box(modifier = Modifier.weight(1f)) {
                text()
            }
        }

        if (trailingIcon != null) {
            trailingIcon()
        }
    }
}


@Composable
@OpenMindPreview
private fun Preview_CardHeader() {
    OpenMindTheme {
        Card(modifier = Modifier.fillMaxWidth()) {
            Column {
                CardHeader(
                    text = { Text(text = "Sample Card") },
                    icon = { Icon(Icons.Default.Star, "") },
                    modifier = Modifier.padding(OpenMindTheme.size.x2)
                )

                Text(
                    text = LoremIpsum(words = 10).values
                        .joinToString(separator = " "),
                    modifier = Modifier
                        .padding(horizontal = OpenMindTheme.size.x2)
                        .padding(bottom = OpenMindTheme.size.x2)
                )
            }
        }

    }
}

@Composable
@OpenMindPreview
private fun Preview_CardHeader_Long() {
    OpenMindTheme {
        Card(modifier = Modifier.fillMaxWidth()) {
            Column {
                CardHeader(
                    text = { Text(text = "Sample Card With Longer Text That Does Not Fit Into Screen") },
                    icon = { Icon(Icons.Default.Star, "") },
                    modifier = Modifier.padding(OpenMindTheme.size.x2)
                )

                Text(
                    text = LoremIpsum(words = 10).values
                        .joinToString(separator = " "),
                    modifier = Modifier
                        .padding(horizontal = OpenMindTheme.size.x2)
                        .padding(bottom = OpenMindTheme.size.x2)
                )
            }
        }

    }
}