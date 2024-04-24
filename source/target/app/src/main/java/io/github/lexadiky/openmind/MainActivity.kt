package io.github.lexadiky.openmind

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.auto.service.AutoService
import io.github.lexadiky.openmind.feature.bottomnavbar.BottomNavigationBarFragment
import io.github.lexadiky.openmind.library.arc.CommandHandler
import io.github.lexadiky.openmind.library.arc.Reducer
import io.github.lexadiky.openmind.library.arc.socket.Socket
import io.github.lexadiky.openmind.library.navigation.ComposeDestination
import io.github.lexadiky.openmind.library.navigation.NavigationHost
import io.github.lexadiky.openmind.library.navigation.NavigatorComponentHolder
import io.github.lexadiky.openmind.library.uikit.component.DefaultScaffold
import io.github.lexadiky.openmind.library.uikit.theme.OpenMindTheme
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            OpenMindTheme {
                DefaultScaffold(
                    bottomBar = {
                        BottomNavigationBarFragment()
                    },
                    content = {
                        NavigationHost()
                    }
                )
            }
        }
    }
}

@AutoService(ComposeDestination::class)
class RootDestination : ComposeDestination<Unit, Unit, Unit> {
    override val route: String = "/"

    @Composable
    override fun Content(state: Unit, act: (Unit) -> Unit) {
        Text(
            text = "Hello World",
            modifier = Modifier.clickable {
              act(Unit)
            }
        )
    }

    override fun createSocket(arguments: Unit): Socket<Unit, Unit> {
        val navigatorComponent = NavigatorComponentHolder.get()
        val navigator = navigatorComponent.navigator

        return Socket.ui(
            defaultState = Unit,
            reducer = { state, action ->
                Reducer.Result(action = Unit)
            },
            commandHandlers = listOf(CommandHandler { input ->
                input.distinctUntilChanged().map {
                    navigator.navigate("/hello/Alex")
                }
            })
        )
    }
}

@Serializable
data class Args(val name: String)

@AutoService(ComposeDestination::class)
class ArgDestination : ComposeDestination<Args, Int, Int> {
    override val route: String = "/hello/{name}"

    @Composable
    override fun Content(state: Int, act: (Int) -> Unit) {
        Text(
            text = "Hello $state",
            modifier = Modifier.clickable { act(1) }
        )
    }

    override fun createSocket(arguments: Args): Socket<Int, Int> {
        return Socket.ui(
            defaultState = 0,
            reducer = { state, action ->
                if (state == 5 && action != 2) {
                    return@ui Reducer.Result(action = 1)
                }

                when (action) {
                    1 -> Reducer.Result(state = state + 1)
                    2 -> Reducer.Result(state = state + 100)
                    else -> error("unknow")
                }
            },
            commandHandlers = listOf(
                CommandHandler { input ->
                    input.map {
                        2
                    }
                }
            )
        )
    }
}