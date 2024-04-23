package io.github.lexadiky.openmind.library.uikit.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import io.github.lexadiky.openmind.library.uikit.theme.OpenMindTheme

@Composable
fun Matrix(
    columns: Int,
    rows: Int,
    modifier: Modifier = Modifier,
    spacing: Dp = OpenMindTheme.size.zero,
    item: @Composable RowScope.(column: Int, row: Int) -> Unit,
) {
    Column(modifier, verticalArrangement = Arrangement.spacedBy(spacing)) {
        repeat(columns) { row ->
            Row(horizontalArrangement = Arrangement.spacedBy(spacing)) {
                repeat(rows) { col ->
                    item(col, row)
                }
            }
        }
    }
}