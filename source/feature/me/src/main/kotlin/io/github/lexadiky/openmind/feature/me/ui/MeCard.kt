package io.github.lexadiky.openmind.feature.me.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import io.github.lexadiky.openmind.library.uikit.R as UiKitR
import io.github.lexadiky.openmind.library.uikit.component.CardHeader
import io.github.lexadiky.openmind.library.uikit.component.CollapsableCard
import io.github.lexadiky.openmind.library.uikit.theme.OpenMindTheme


@Composable
internal fun MeCard(
    icon: @Composable () -> Unit,
    header: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    var isCollapsed by remember {
        mutableStateOf(false)
    }

    CollapsableCard(
        isCollapsed = isCollapsed,
        header = {
            CardHeader(
                text = { header() },
                icon = { icon() },
                trailingIcon = {
                    val rotateAngle by animateFloatAsState(
                        targetValue = if (isCollapsed) 0f else 180f,
                        label = "drop-down-icon-rotate"
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = stringResource(id = UiKitR.string.lib_uikit_card_header_arrow_down_content),
                        modifier = Modifier.rotate(rotateAngle)
                    )
                },
                modifier = Modifier
                    .clickable { isCollapsed = !isCollapsed }
                    .padding(OpenMindTheme.size.x2)
            )
        },
        details = { content() },
        modifier = Modifier.padding(horizontal = OpenMindTheme.size.x2)
    )
}