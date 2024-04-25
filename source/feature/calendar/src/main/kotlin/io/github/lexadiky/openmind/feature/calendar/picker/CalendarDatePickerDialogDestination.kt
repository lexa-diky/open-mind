@file:OptIn(ExperimentalMaterial3Api::class)

package io.github.lexadiky.openmind.feature.calendar.picker

import android.content.res.Configuration
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.auto.service.AutoService
import io.github.lexadiky.openmind.feature.calendar.R
import io.github.lexadiky.openmind.library.arc.socket.Socket
import io.github.lexadiky.openmind.library.navigation.desitnation.ComposeDialogDestination
import io.github.lexadiky.openmind.library.uikit.theme.OpenMindTheme
import io.github.lexadiky.openmind.library.uikit.util.OpenMindPreview
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@AutoService(ComposeDialogDestination::class)
internal class CalendarDatePickerDialogDestination :
    ComposeDialogDestination<Unit, CalendarDatePickerDialogState, CalendarDatePickerDialogAction> {

    override val route: String = "/calendar/pick-date"

    @Composable
    override fun Content(state: CalendarDatePickerDialogState, act: (CalendarDatePickerDialogAction) -> Unit) {
        CalendarDatePickerDialog(act)
    }

    override fun createSocket(arguments: Unit): Socket<CalendarDatePickerDialogState, CalendarDatePickerDialogAction> =
        CalendarDatePickerDialogComponent.Factory.createSocket(arguments)
}

@Composable
private fun CalendarDatePickerDialog(act: (CalendarDatePickerDialogAction) -> Unit) {
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = remember {
            Clock.System.now().toEpochMilliseconds()
        },
        yearRange = remember {
            val currentDate = Clock.System.now()
                .toLocalDateTime(TimeZone.currentSystemDefault())
            (currentDate.year - 100)..currentDate.year
        }
    )
    DatePickerDialog(
        tonalElevation = OpenMindTheme.size.x2,
        onDismissRequest = { act(CalendarDatePickerDialogAction.OnDismiss) },
        confirmButton = {
            TextButton(
                onClick = { act(CalendarDatePickerDialogAction.ConfirmDate(datePickerState.selectedDateMillis)) },
                content = {
                    val text = if (datePickerState.selectedDateMillis != null) {
                        stringResource(id = R.string.feature_calendar_picker_confirm)
                    } else {
                        stringResource(id = R.string.feature_calendar_picker_today)
                    }
                    Text(text = text)
                }
            )
        },
        dismissButton = {
            TextButton(
                onClick = { act(CalendarDatePickerDialogAction.OnDismiss) },
                content = { Text(text = stringResource(id = R.string.feature_calendar_picker_cancel)) }
            )
        }
    ) {
        DatePicker(state = datePickerState)
    }
}

@Composable
@OpenMindPreview
private fun Preview_CalendarDatePickerDialog() {
    OpenMindTheme {
        CalendarDatePickerDialog(act = {})
    }
}
