package io.github.lexadiky.openmind.feature.bottomnavbar.entity

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import io.github.lexadiky.openmind.feature.bottomnavigationbar.R

internal enum class BottomNavigationBarItem(
    val icon: ImageVector,
    @StringRes val label: Int
) {
    Me(Icons.Default.Face, R.string.feature_bottom_navigation_bar_item_me),
    Calendar(Icons.Default.DateRange, R.string.feature_bottom_navigation_bar_item_calendar),
    Analyze(Icons.Default.Search, R.string.feature_bottom_navigation_bar_item_analyze),
    Settings(Icons.Default.Settings, R.string.feature_bottom_navigation_bar_item_settings)
}
