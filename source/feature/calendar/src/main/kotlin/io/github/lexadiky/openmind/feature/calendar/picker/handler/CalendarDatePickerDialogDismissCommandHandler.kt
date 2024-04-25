package io.github.lexadiky.openmind.feature.calendar.picker.handler

import io.github.lexadiky.openmind.feature.calendar.picker.CalendarDatePickerDialogAction
import io.github.lexadiky.openmind.feature.calendar.picker.CalendarDatePickerDialogCommand
import io.github.lexadiky.openmind.library.arc.CommandHandler
import io.github.lexadiky.openmind.library.arc.util.react
import io.github.lexadiky.openmind.library.navigation.Navigator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.flatMapConcat

internal class CalendarDatePickerDialogDismissCommandHandler(
    private val navigator: Navigator,
) : CommandHandler<CalendarDatePickerDialogAction, CalendarDatePickerDialogCommand> {

    override fun handle(flow: Flow<CalendarDatePickerDialogCommand>): Flow<CalendarDatePickerDialogAction> {
        return flow.react<CalendarDatePickerDialogCommand.Dismiss, _> {
            navigator.back()
        }
    }
}