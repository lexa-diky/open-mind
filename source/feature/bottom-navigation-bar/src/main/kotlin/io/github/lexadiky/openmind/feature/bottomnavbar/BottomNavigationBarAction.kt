package io.github.lexadiky.openmind.feature.bottomnavbar

import io.github.lexadiky.openmind.feature.bottomnavbar.entity.BottomNavigationBarItem

internal sealed interface BottomNavigationBarAction {

    class ItemClicked(val item: BottomNavigationBarItem): BottomNavigationBarAction
    class Navigated(val item: BottomNavigationBarItem): BottomNavigationBarAction
}