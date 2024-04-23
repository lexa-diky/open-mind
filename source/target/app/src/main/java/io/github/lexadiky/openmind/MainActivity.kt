package io.github.lexadiky.openmind

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import io.github.lexadiky.openmind.library.uikit.component.DefaultScaffold
import io.github.lexadiky.openmind.library.uikit.theme.OpenMindTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            OpenMindTheme {
                DefaultScaffold()
            }
        }
    }
}
