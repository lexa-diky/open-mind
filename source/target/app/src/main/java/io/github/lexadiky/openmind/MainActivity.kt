package io.github.lexadiky.openmind

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.google.auto.service.AutoService
import io.github.lexadiky.openmind.feature.bottomnavbar.BottomNavigationBarElement
import io.github.lexadiky.openmind.library.arc.socket.Socket
import io.github.lexadiky.openmind.library.navigation.desitnation.ComposeScreenDestination
import io.github.lexadiky.openmind.library.navigation.NavigationHost
import io.github.lexadiky.openmind.library.navigation.Navigator
import io.github.lexadiky.openmind.library.navigation.NavigatorComponent
import io.github.lexadiky.openmind.library.navigation.NavigatorComponentHolder
import io.github.lexadiky.openmind.library.uikit.component.DefaultScaffold
import io.github.lexadiky.openmind.library.uikit.theme.OpenMindTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val controller = rememberNavController()
            NavigatorComponentHolder.init(
                NavigatorComponent.from(controller)
            )

            OpenMindTheme {
                DefaultScaffold(
                    bottomBar = {
                        BottomNavigationBarElement()
                    },
                    content = {
                        NavigationHost(controller)
                    }
                )
            }
        }
    }
}
