@file:OptIn(ExperimentalMaterial3Api::class)

package io.github.lexadiky.openmind.feature.calendar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.google.auto.service.AutoService
import io.github.lexadiky.openmind.library.arc.socket.Socket
import io.github.lexadiky.openmind.library.navigation.Navigator
import io.github.lexadiky.openmind.library.navigation.desitnation.ComposeScreenDestination
import io.github.lexadiky.openmind.library.navigation.NavigatorComponentHolder
import io.github.lexadiky.openmind.library.navigation.NoopNavigator
import io.github.lexadiky.openmind.library.uikit.component.MonthVisualizer
import io.github.lexadiky.openmind.library.uikit.theme.OpenMindTheme
import io.github.lexadiky.openmind.library.uikit.util.OpenMindPreview
import io.github.lexadiky.openmind.library.uikit.util.noBottom

@AutoService(ComposeScreenDestination::class)
class CalendarScreenDestination : ComposeScreenDestination<Unit, Unit, Unit> {

    override val route: String = "/calendar"

    @Composable
    override fun Content(state: Unit, act: (Unit) -> Unit) {
        val navigator = remember {
            NavigatorComponentHolder.get().navigator
        }

        CalendarScreen(navigator)
    }

    override fun createSocket(arguments: Unit): Socket<Unit, Unit> =
        Socket.noop()
}


@Composable
private fun CalendarScreen(navigator: Navigator) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Calendar") },
                actions = {
                    IconButton(
                        onClick = { navigator.navigate("/calendar/pick-date") },
                        content = { Icon(Icons.Default.MoreVert, "More") }
                    )
                },
                scrollBehavior = scrollBehavior,
                modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
            )
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier
                    .padding(padding.noBottom())
                    .nestedScroll(scrollBehavior.nestedScrollConnection)
            ) {
                item {
                    MonthVisualizer(
                        modifier = Modifier
                            .padding(horizontal = OpenMindTheme.size.x2)
                    )
                }
                item {
                    Spacer(modifier = Modifier.size(OpenMindTheme.size.x2))
                    Divider(modifier = Modifier.padding(horizontal = OpenMindTheme.size.x))
                    Spacer(modifier = Modifier.size(OpenMindTheme.size.x))
                }
                items(10) { idx ->
                    ListItem(
                        leadingContent = { Icon(Icons.Default.DateRange, "DateRange") },
                        overlineContent = { Text(text = "Thu, 1 May, 2024") },
                        headlineContent = { Text(text = "Thing $idx") },
                        supportingContent = { Text(text = "I feel really bad this day") },
                        trailingContent = {
                            Icon(Icons.Default.KeyboardArrowRight, "DateRange")
                        },
                        modifier = Modifier.clickable { }
                    )
                }
                item {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .padding(OpenMindTheme.size.x2)
                            .fillMaxWidth()
                    ) {
                        OutlinedButton(
                            onClick = { navigator.navigate("/calendar/pick-date") },
                            modifier = Modifier.fillMaxWidth(fraction = 0.75f)
                        ) {
                            Text(text = "More")
                        }
                    }
                }
            }
        }
    )
}

@Composable
@OpenMindPreview
private fun Preview_CalendarScreen() {
    OpenMindTheme {
        CalendarScreen(NoopNavigator())
    }
}