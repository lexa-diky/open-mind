package io.github.lexadiky.openmind.feature.calendar.picker

import io.github.lexadiky.openmind.feature.calendar.picker.handler.CalendarDatePickerDialogDismissCommandHandler
import io.github.lexadiky.openmind.feature.calendar.picker.handler.CalendarDatePickerDialogSelectedCommandHandler
import io.github.lexadiky.openmind.library.arc.di.SocketComponent
import io.github.lexadiky.openmind.library.arc.socket.Socket
import io.github.lexadiky.openmind.library.navigation.NavigatorComponentHolder

internal interface CalendarDatePickerDialogComponent : SocketComponent<CalendarDatePickerDialogState, CalendarDatePickerDialogAction> {

    object Factory : SocketComponent.Factory<Unit, CalendarDatePickerDialogState, CalendarDatePickerDialogAction> {
        override fun createSocket(arguments: Unit): Socket<CalendarDatePickerDialogState, CalendarDatePickerDialogAction> {
            val navigator = NavigatorComponentHolder.get().navigator
            return Socket.ui(
                defaultState = CalendarDatePickerDialogState(),
                reducer = CalendarDatePickerDialogReducer(),
                commandHandlers = listOf(
                    CalendarDatePickerDialogDismissCommandHandler(navigator),
                    CalendarDatePickerDialogSelectedCommandHandler(navigator)
                )
            )
        }
    }
}