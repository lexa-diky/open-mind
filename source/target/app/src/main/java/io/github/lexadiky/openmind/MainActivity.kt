package io.github.lexadiky.openmind

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.auto.service.AutoService
import io.github.lexadiky.openmind.library.navigation.Destination
import io.github.lexadiky.openmind.library.navigation.LocalNavHostController
import io.github.lexadiky.openmind.library.navigation.NavigationHost
import io.github.lexadiky.openmind.library.uikit.component.DefaultScaffold
import io.github.lexadiky.openmind.library.uikit.theme.OpenMindTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            OpenMindTheme {
                DefaultScaffold {
                    NavigationHost()
                }
            }
        }
    }
}

@AutoService(Destination::class)
class RootDestination : Destination {
    override val route: String = "/"

    @Composable
    override fun Content() {
        val controller = LocalNavHostController.current
        Text(text = "Hello World", modifier = Modifier.clickable { controller.navigate("/nested") })
    }
}

@AutoService(Destination::class)
class NestedDestination : Destination {
    override val route: String = "/nested"

    @Composable
    override fun Content() {
        Text(text = "Goodbye World")
    }
}
