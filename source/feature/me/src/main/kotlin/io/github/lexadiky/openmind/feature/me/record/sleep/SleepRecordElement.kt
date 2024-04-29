@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)

package io.github.lexadiky.openmind.feature.me.record.sleep

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import io.github.lexadiky.openmind.feature.me.R
import io.github.lexadiky.openmind.feature.me.ui.MeCard
import io.github.lexadiky.openmind.library.uikit.theme.OpenMindTheme
import io.github.lexadiky.openmind.library.uikit.util.OpenMindPreview
import io.github.lexadiky.openmind.library.uikit.R as UiKitR

@Composable
fun SleepRecordElement() {
    MeCard(
        icon = {
            Icon(
                painter = painterResource(id = UiKitR.drawable.ic_bad_time),
                contentDescription = stringResource(id = R.string.feature_me_record_sleep_header_icon_content)
            )
        },
        header = {
            Text(text = stringResource(id = R.string.feature_me_record_sleep_header))
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(bottom = OpenMindTheme.size.x2)
            ) {
                val sliderState = remember {
                    SliderState(
                        steps = 47,
                        valueRange = 0f..24f
                    )
                }
                SectionHeader(
                    text = stringResource(id = R.string.feature_me_record_sleep_header_time_slept),
                    modifier = Modifier
                        .padding(horizontal = OpenMindTheme.size.x2)
                )

                SleepDurationSection(sliderState)

                SectionHeader(
                    text = stringResource(id = R.string.feature_me_record_sleep_quality_header),
                    modifier = Modifier
                        .padding(bottom = OpenMindTheme.size.x)
                        .padding(horizontal = OpenMindTheme.size.x2)
                )

                SleepQualitySection()

                SectionHeader(
                    text = stringResource(id = R.string.feature_me_record_sleep_property_header),
                    modifier = Modifier
                        .padding(vertical = OpenMindTheme.size.x)
                        .padding(horizontal = OpenMindTheme.size.x2)
                )

                SleepPropertiesSection()

                NoteSection()
            }
        }
    )
}

@Composable
private fun NoteSection() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        label = { Text(text = stringResource(id = R.string.feature_me_record_sleep_note_label)) },
        onValueChange = { text = it },
        shape = OpenMindTheme.shape.roundRectangle,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = OpenMindTheme.size.x2)
            .padding(top = OpenMindTheme.size.x)
    )
}

@Composable
private fun SleepPropertiesSection() {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(OpenMindTheme.size.x2),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = OpenMindTheme.size.x2)
    ) {
        stringArrayResource(id = R.array.feature_me_record_sleep_property_list).forEach { item ->
            FilterChip(
                selected = false,
                onClick = { /*TODO*/ },
                label = { Text(text = item) }
            )
        }
    }
}

@Composable
private fun SleepQualitySection() {
    SingleChoiceSegmentedButtonRow(
        modifier = Modifier
            .padding(horizontal = OpenMindTheme.size.x2)
    ) {
        SegmentedButton(
            selected = false,
            onClick = { /*TODO*/ },
            shape = SegmentedButtonDefaults.itemShape(0, 5)
        ) {
            Text(text = stringResource(id = R.string.feature_me_record_sleep_quality_awful))
        }
        SegmentedButton(
            selected = false,
            onClick = { /*TODO*/ },
            shape = SegmentedButtonDefaults.itemShape(1, 5)
        ) {
            Text(text = stringResource(id = R.string.feature_me_record_sleep_quality_bad))
        }
        SegmentedButton(
            selected = false,
            onClick = { /*TODO*/ },
            shape = SegmentedButtonDefaults.itemShape(2, 5)
        ) {
            Text(text = stringResource(id = R.string.feature_me_record_sleep_quality_ok))
        }
        SegmentedButton(
            selected = false,
            onClick = { /*TODO*/ },
            shape = SegmentedButtonDefaults.itemShape(3, 5)
        ) {
            Text(text = stringResource(id = R.string.feature_me_record_sleep_quality_good))
        }
        SegmentedButton(
            selected = false,
            onClick = { /*TODO*/ },
            shape = SegmentedButtonDefaults.itemShape(4, 5)
        ) {
            Text(text = stringResource(id = R.string.feature_me_record_sleep_quality_great))
        }
    }
}

@Composable
private fun SleepDurationSection(sliderState: SliderState) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.padding(
            start = OpenMindTheme.size.x2,
            end = OpenMindTheme.size.x
        )
    ) {
        Slider(
            state = sliderState,
            modifier = Modifier.weight(1f)
        )
        IconButton(
            onClick = { /*TODO*/ },
        ) {
            Icon(
                painter = painterResource(id = io.github.lexadiky.openmind.library.uikit.R.drawable.ic_clock),
                contentDescription = stringResource(id = R.string.feature_me_record_sleep_time_to_bad_icon_content)
            )
        }
    }
}

@Composable
private fun SectionHeader(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = OpenMindTheme.typography.labelLarge,
        modifier = modifier
    )
}

@Composable
@OpenMindPreview
private fun Preview_SleepRecordElement() {
    OpenMindTheme {
        SleepRecordElement()
    }
}
