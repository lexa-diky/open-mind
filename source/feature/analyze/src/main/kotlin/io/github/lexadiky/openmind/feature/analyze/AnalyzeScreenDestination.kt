package io.github.lexadiky.openmind.feature.analyze

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.auto.service.AutoService
import com.patrykandpatrick.vico.compose.cartesian.CartesianChartHost
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberBottomAxis
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberStartAxis
import com.patrykandpatrick.vico.compose.cartesian.layer.rememberLineCartesianLayer
import com.patrykandpatrick.vico.compose.cartesian.rememberCartesianChart
import com.patrykandpatrick.vico.compose.cartesian.rememberVicoScrollState
import com.patrykandpatrick.vico.core.cartesian.CartesianChart
import com.patrykandpatrick.vico.core.cartesian.data.CartesianChartModel
import com.patrykandpatrick.vico.core.cartesian.data.LineCartesianLayerModel
import io.github.lexadiky.openmind.library.arc.socket.Socket
import io.github.lexadiky.openmind.library.navigation.desitnation.ComposeScreenDestination
import io.github.lexadiky.openmind.library.uikit.util.OpenMindPreview

@AutoService(ComposeScreenDestination::class)
class AnalyzeScreenDestination : ComposeScreenDestination<Unit, Unit, Unit> {
    override val route: String = "/analyze"

    @Composable
    override fun Content(state: Unit, act: (Unit) -> Unit) {
        AnalyzeScreen()
    }

    override fun createSocket(arguments: Unit): Socket<Unit, Unit> =
        Socket.noop()
}

@Composable
private fun AnalyzeScreen() {
    val model = remember {
        CartesianChartModel(LineCartesianLayerModel.build { series(1, 2, 4, 8, 3) })
    }
    CartesianChartHost(
        chart =
        rememberCartesianChart(
            rememberLineCartesianLayer(),
        ),
        model = model,
        scrollState = rememberVicoScrollState(),
    )
}

@Composable
@OpenMindPreview
private fun Preview_AnalyzeScreen() {
    AnalyzeScreen()
}