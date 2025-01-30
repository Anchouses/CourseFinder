package com.silaeva.coursefinder.presentation.comon_ui.inputs

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.silaeva.coursefinder.presentation.comon_ui.theme.DarkGray
import com.silaeva.coursefinder.presentation.comon_ui.theme.Spacing
import com.silaeva.coursefinder.presentation.comon_ui.theme.Typography
import com.silaeva.coursefinder.presentation.comon_ui.theme.White
import com.silaeva.coursefinder.presentation.comon_ui.theme.WhiteHintText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextField(
    title: String,
    hint: String,
    isError: Boolean,
    onTextChange: (String) -> Unit
) {
    var text by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf(isError) }
    val interactionSource = remember { MutableInteractionSource() }
    val enabled = true
    val singleLine = false
    val colors = OutlinedTextFieldDefaults.colors(
        focusedContainerColor = DarkGray,
        unfocusedContainerColor = DarkGray,
        focusedTextColor = White,
        unfocusedTextColor = White,
        focusedPlaceholderColor = WhiteHintText,
        unfocusedPlaceholderColor = WhiteHintText,
        focusedBorderColor = DarkGray,
        unfocusedBorderColor = DarkGray,
    )

    Column {
        Text(
            text = title,
            style = Typography.titleMedium,
            modifier = Modifier.padding(bottom = Spacing.paddingTiny)
        )
        BasicTextField(
            value = text,
            onValueChange = {newText ->
                text = newText
                onTextChange(text)
                error = newText.isBlank()
            },
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    expanded = focusState.isFocused
                },
            textStyle = Typography.bodyMedium
        ) {
            OutlinedTextFieldDefaults.DecorationBox(
                value = text,
                visualTransformation = VisualTransformation.None,
                innerTextField = it,
                singleLine = singleLine,
                enabled = enabled,
                placeholder = {
                    Text(
                        text = hint,
                        maxLines = 1,
                        style = Typography.bodyMedium,
                        color = WhiteHintText
                    )
                },
                interactionSource = interactionSource,
                contentPadding = OutlinedTextFieldDefaults.contentPadding(
                    start = Spacing.paddingMiddle,
                    top= Spacing.paddingSmall,
                    end = Spacing.paddingMiddle,
                    bottom = Spacing.paddingSmall
                ),
                colors = colors,
                container = {
                    OutlinedTextFieldDefaults.ContainerBox(
                        enabled = enabled,
                        isError = false,
                        colors = colors,
                        interactionSource = interactionSource,
                        shape = RoundedCornerShape(Spacing.commonRadius)
                    )
                }
            )
        }
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