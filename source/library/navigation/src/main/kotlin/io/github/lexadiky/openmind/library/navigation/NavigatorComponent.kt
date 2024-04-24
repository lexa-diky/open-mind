package io.github.lexadiky.openmind.library.navigation

import androidx.navigation.NavHostController
import io.github.lexadiky.openmind.library.arc.di.Component
import io.github.lexadiky.openmind.library.arc.di.StaticComponentHolder

interface NavigatorComponent : Component {
    val navigator: Navigator

    companion object {

        fun from(controller: NavHostController): NavigatorComponent = object : NavigatorComponent {
            override val navigator: Navigator = JetpackNavigator(controller)
        }
    }
}

object NavigatorComponentHolder : StaticComponentHolder<NavigatorComponent>()