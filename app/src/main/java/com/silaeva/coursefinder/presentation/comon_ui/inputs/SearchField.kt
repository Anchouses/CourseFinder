package com.silaeva.coursefinder.presentation.comon_ui.inputs

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.silaeva.coursefinder.R
import com.silaeva.coursefinder.presentation.comon_ui.theme.Dark
import com.silaeva.coursefinder.presentation.comon_ui.theme.DarkGray
import com.silaeva.coursefinder.presentation.comon_ui.theme.Spacing
import com.silaeva.coursefinder.presentation.comon_ui.theme.Typography
import com.silaeva.coursefinder.presentation.comon_ui.theme.White
import com.silaeva.coursefinder.presentation.comon_ui.theme.WhiteHintText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    hint: String,
    getResult: (String) -> Unit,
    onFilterClick: () -> Unit
) {
    val text = remember { mutableStateOf("") }
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
        focusedBorderColor = Dark,
        unfocusedBorderColor = Dark,
    )
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BasicTextField(
            value = text.value,
            onValueChange = {
                text.value = it
                getResult(text.value)
            },
            modifier = Modifier
                .fillMaxWidth(0.8f),
            textStyle = Typography.bodyMedium
        ) {
            OutlinedTextFieldDefaults.DecorationBox(
                value = text.value,
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
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = null,
                        tint = White
                    )
                },
                interactionSource = interactionSource,
                contentPadding = OutlinedTextFieldDefaults.contentPadding(),
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

        IconButton(
            modifier = Modifier
                .padding(start = Spacing.paddingTiny)
                .size(Spacing.iconSize)
                .background(
                    color = DarkGray,
                    shape = CircleShape
                ),
            onClick = { onFilterClick() },
            content = {
                Icon(
                    modifier = Modifier,
                    painter = painterResource(id = R.drawable.ic_filter),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchTextFieldPreview() {
    SearchField(
        modifier = Modifier,
        hint = "(stringResource(id = R.string.search))",
        getResult = {},
        onFilterClick = {}
    )
}