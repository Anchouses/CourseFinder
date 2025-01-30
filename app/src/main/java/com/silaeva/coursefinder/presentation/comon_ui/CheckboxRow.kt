package com.silaeva.coursefinder.presentation.comon_ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.silaeva.coursefinder.presentation.comon_ui.theme.Dark
import com.silaeva.coursefinder.presentation.comon_ui.theme.Green
import com.silaeva.coursefinder.presentation.comon_ui.theme.Typography

@Composable
fun CheckboxRow(
    text: String,
    isChecked: (String) -> Unit
) {
    val checkedState = remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { isChecked ->
                checkedState.value = isChecked
                if (checkedState.value) isChecked(text)
            },
            colors =  CheckboxDefaults. colors(
                checkedColor = Green,
                checkmarkColor = Dark
            ),
        )
        Text(
            text = text,
            style = Typography.labelSmall
        )
    }
}