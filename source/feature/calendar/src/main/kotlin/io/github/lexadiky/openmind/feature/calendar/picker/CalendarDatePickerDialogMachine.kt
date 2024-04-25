package io.github.lexadiky.openmind.feature.calendar.picker

import io.github.lexadiky.openmind.library.arc.Reducer
import io.github.lexadiky.openmind.library.arc.command
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class CalendarDatePickerDialogState

internal sealed interface CalendarDatePickerDialogAction {
    data object OnDismiss : CalendarDatePickerDialogAction
    data class ConfirmDate(val selectedDateMillis: Long?) : CalendarDatePickerDialogAction
}

internal sealed interface CalendarDatePickerDialogCommand {
    data object Dismiss : CalendarDatePickerDialogCommand
    data class SelectDate(val date: LocalDate) : CalendarDatePickerDialogCommand
}

internal class CalendarDatePickerDialogReducer :
    Reducer<CalendarDatePickerDialogState, CalendarDatePickerDialogAction, CalendarDatePickerDialogCommand> {

    override fun reduce(
        state: CalendarDatePickerDialogState,
        action: CalendarDatePickerDialogAction,
    ): Reducer.Result<CalendarDatePickerDialogState, CalendarDatePickerDialogCommand> {
        return when (action) {
            CalendarDatePickerDialogAction.OnDismiss -> command { CalendarDatePickerDialogCommand.Dismiss }
            is CalendarDatePickerDialogAction.ConfirmDate -> command {
                val instant = action.selectedDateMillis?.let { Instant.fromEpochMilliseconds(it) }
                    ?: Clock.System.now()
                CalendarDatePickerDialogCommand.SelectDate(
                    instant.toLocalDateTime(TimeZone.currentSystemDefault()).date
                )
            }
        }
    }
}
