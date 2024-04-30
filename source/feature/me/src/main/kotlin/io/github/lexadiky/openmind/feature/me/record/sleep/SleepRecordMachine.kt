package io.github.lexadiky.openmind.feature.me.record.sleep

import io.github.lexadiky.openmind.library.arc.Reducer
import io.github.lexadiky.openmind.library.arc.state
import kotlin.time.Duration

internal data class SleepRecordState(
    val sleepTime: Duration? = null
) {

    val sleepTimeFloat: Float get() {
        val duration = sleepTime ?: Duration.ZERO
        return duration.inWholeMinutes.toFloat() / 60f
    }
}

internal sealed interface SleepRecordAction {
    class UpdateSleepTime(val duration: Duration): SleepRecordAction
}

internal sealed interface SleepRecordCommand {

}

internal class SleepRecordReducer : Reducer<SleepRecordState, SleepRecordAction, SleepRecordCommand> {
    override fun reduce(state: SleepRecordState, action: SleepRecordAction): Reducer.Result<SleepRecordState, SleepRecordCommand> {
        return when(action) {
            is SleepRecordAction.UpdateSleepTime -> state {
                state.copy(sleepTime = action.duration)
            }
        }
    }
}