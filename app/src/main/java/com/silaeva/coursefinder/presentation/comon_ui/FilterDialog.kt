package com.silaeva.coursefinder.presentation.comon_ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.silaeva.coursefinder.presentation.comon_ui.common_buttons.PrimaryButton
import com.silaeva.coursefinder.presentation.comon_ui.theme.Dark
import com.silaeva.coursefinder.presentation.comon_ui.theme.Green
import com.silaeva.coursefinder.presentation.comon_ui.theme.Spacing
import com.silaeva.coursefinder.presentation.comon_ui.theme.Typography

@Composable
fun FilterDialog(
    openDialog: Boolean,
    onDismiss: (List<String>) -> Unit
) {
    val requestList: MutableList<String> = mutableListOf()

    if (openDialog) {
        Dialog(
            onDismissRequest = { onDismiss(emptyList()) }
        ) {
            Surface(
                modifier = Modifier.padding(Spacing.paddingMiddle),
                shape = MaterialTheme.shapes.medium,
                color = Dark
            ) {
                Column(
                    modifier = Modifier.padding(Spacing.paddingMiddle),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(Spacing.paddingExtraTiny)
                ) {
                    Text(
                        "Фильтры",
                        style = Typography.titleMedium
                    )
                    Spacer(
                        modifier = Modifier.height(Spacing.paddingTiny)
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Категория",
                        style = Typography.labelSmall
                    )
                    CheckboxRow(
                        text = "Kotlin",
                        isChecked = { requestList.add(it) }
                    )
                    CheckboxRow(
                        text = "Android SDK",
                        isChecked = { requestList.add(it) }
                    )
                    CheckboxRow(
                        text = "UX/UI",
                        isChecked = { requestList.add("UI UX") }
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Уровень сложности",
                        style = Typography.labelSmall
                    )
                    CheckboxRow(
                        text = "Beginner",
                        isChecked = { requestList.add(it) }
                    )
                    CheckboxRow(
                        text = "Intermediate",
                        isChecked = { requestList.add(it) }
                    )
                    CheckboxRow(
                        text = "Advanced",
                        isChecked = { requestList.add(it) }
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Бесплатный/платный",
                        style = Typography.labelSmall
                    )
                    CheckboxRow(
                        text = "Бесплатный",
                        isChecked = { requestList.add(it) }
                    )
                    CheckboxRow(
                        text = "Платный",
                        isChecked = { requestList.add(it) }
                    )
                    Spacer(
                        modifier = Modifier.height(Spacing.paddingTiny)
                    )
                    PrimaryButton(
                        text = "Применить",
                        onClick = { onDismiss(requestList.toList()) },
                        backgroundColor = Green
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilterDialogPreview() {
    FilterDialog(openDialog = true) {
    }
}