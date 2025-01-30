package com.silaeva.coursefinder.presentation.comon_ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.silaeva.coursefinder.presentation.comon_ui.theme.Green
import com.silaeva.coursefinder.presentation.comon_ui.theme.Spacing
import com.silaeva.coursefinder.presentation.comon_ui.theme.Typography
import com.silaeva.coursefinder.presentation.comon_ui.theme.White

@Composable
fun BottomNavIcon(
    painterResource: Int,
    title: String,
    onClick: () -> Unit,
    isClicked: Boolean
) {
    val color = if (isClicked) Green else White

    TextButton(
        onClick = { onClick() }
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = Spacing.paddingTiny),
                painter = painterResource(painterResource),
                contentDescription = title,
                tint = color
            )
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = title,
                color = color,
                style = Typography.labelMedium
            )
        }
    }
}