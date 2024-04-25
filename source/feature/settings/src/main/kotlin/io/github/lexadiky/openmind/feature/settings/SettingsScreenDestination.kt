@file:OptIn(ExperimentalMaterial3Api::class)

package io.github.lexadiky.openmind.feature.settings

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import com.google.auto.service.AutoService
import io.github.lexadiky.openmind.library.arc.socket.Socket
import io.github.lexadiky.openmind.library.navigation.desitnation.ComposeScreenDestination
import io.github.lexadiky.openmind.library.uikit.theme.OpenMindTheme
import io.github.lexadiky.openmind.library.uikit.util.OpenMindPreview
import io.github.lexadiky.openmind.library.uikit.util.noBottom

@AutoService(ComposeScreenDestination::class)
class SettingsScreenDestination : ComposeScreenDestination<Unit, Unit, Unit> {
    override val route: String = "/settings"

    @Composable
    override fun Content(state: Unit, act: (Unit) -> Unit) {
        SettingsScreen()
    }

    override fun createSocket(arguments: Unit): Socket<Unit, Unit> =
        Socket.noop()
}

@Composable
private fun SettingsScreen() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.feature_settings_title)) },
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
                    ListItem(
                        headlineContent = {
                            Text(text = stringResource(id = R.string.feature_settings_item_theme_title))
                        },
                        supportingContent = {
                            Text(text = stringResource(id = R.string.feature_settings_item_theme_explain))
                        },
                        leadingContent = {
                            Icon(Icons.Default.Star, stringResource(id = R.string.feature_settings_item_theme_title))
                        },
                        modifier = Modifier.clickable { }
                    )
                }
                item {
                    ListItem(
                        headlineContent = {
                            Text(text = stringResource(id = R.string.feature_settings_item_backup_title))
                        },
                        supportingContent = {
                            Text(text = stringResource(id = R.string.feature_settings_item_backup_explain))
                        },
                        leadingContent = {
                            Icon(Icons.Default.Send, stringResource(id = R.string.feature_settings_item_backup_title))
                        },
                        modifier = Modifier.clickable { }
                    )
                }
                item {
                    ListItem(
                        headlineContent = {
                            Text(text = stringResource(id = R.string.feature_settings_item_share_title))
                        },
                        supportingContent = {
                            Text(text = stringResource(id = R.string.feature_settings_item_share_explain))
                        },
                        leadingContent = {
                            Icon(Icons.Default.Share, stringResource(id = R.string.feature_settings_item_share_title))
                        },
                        modifier = Modifier.clickable { }
                    )
                }
            }
        }
    )
}

@Composable
@OpenMindPreview
private fun Preview_SettingsScreenDestination() {
    OpenMindTheme {
        SettingsScreen()
    }
}