package io.github.lexadiky.openmind.feature.bottomnavbar

import io.github.lexadiky.openmind.feature.bottomnavbar.entity.BottomNavigationBarItem

internal class BottomNavigationBarState(
    val items: List<BottomNavigationBarItem> = BottomNavigationBarItem.entries,
    val selectedItem: BottomNavigationBarItem = BottomNavigationBarItem.Me
)