package io.github.lexadiky.openmind.feature.bottomnavbar

import io.github.lexadiky.openmind.feature.bottomnavbar.entity.BottomNavigationBarItem

internal sealed interface BottomNavigationBarCommand {

    class Navigate(val item: BottomNavigationBarItem) : BottomNavigationBarCommand
    object ListenToCurrentRoute : BottomNavigationBarCommand
}