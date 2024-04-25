package io.github.lexadiky.openmind.feature.calendar.picker.handler

import io.github.lexadiky.openmind.feature.calendar.picker.CalendarDatePickerDialogAction
import io.github.lexadiky.openmind.feature.calendar.picker.CalendarDatePickerDialogCommand
import io.github.lexadiky.openmind.library.arc.CommandHandler
import io.github.lexadiky.openmind.library.arc.util.react
import io.github.lexadiky.openmind.library.navigation.Navigator
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.LocalDate
import kotlinx.datetime.format

internal class CalendarDatePickerDialogSelectedCommandHandler(
    private val navigator: Navigator,
) : CommandHandler<CalendarDatePickerDialogAction, CalendarDatePickerDialogCommand> {

    override fun handle(flow: Flow<CalendarDatePickerDialogCommand>): Flow<CalendarDatePickerDialogAction> {
        return flow.react<CalendarDatePickerDialogCommand.SelectDate, _> { command ->
            val dateFormat = command.date.format(LocalDate.Formats.ISO_BASIC)
            navigator.navigate("/calendar/$dateFormat")
        }
    }
}