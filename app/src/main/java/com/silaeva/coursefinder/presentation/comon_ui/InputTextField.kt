package com.silaeva.coursefinder.presentation.comon_ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.tooling.preview.Preview
import com.silaeva.coursefinder.presentation.comon_ui.theme.Dark
import com.silaeva.coursefinder.presentation.comon_ui.theme.LightGray
import com.silaeva.coursefinder.presentation.comon_ui.theme.Spacing
import com.silaeva.coursefinder.presentation.comon_ui.theme.Typography
import com.silaeva.coursefinder.presentation.comon_ui.theme.WhiteHintText

@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    title: String,
    hint: String,
    isError: Boolean,
    onTextChange: (String) -> Unit
) {
    var text by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf(isError) }

    Column {
        Text(
            text = title,
            style = Typography.titleMedium,
            modifier = Modifier.padding(bottom = Spacing.paddingTiny)
        )
        OutlinedTextField(
            value = text,
            onValueChange = { newText ->
                text = newText
                onTextChange(text)
                error = newText.isBlank()
            },
            modifier = modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    expanded = focusState.isFocused
                },
            textStyle = Typography.bodyMedium,
            placeholder = {
                Text(
                    text = hint,
                    style = Typography.bodyMedium,
                    color = WhiteHintText
                )
            },
            isError = error,
            shape = RoundedCornerShape(Spacing.commonRadius),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = LightGray,
                unfocusedContainerColor = LightGray,
                focusedBorderColor = Dark,
                unfocusedBorderColor = Dark
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InputTextFieldPreview() {
    InputTextField(
        title = "nkjghjfhlk",
        hint = ";kjlkhl",
        isError = false,
        onTextChange = {}
    )
}