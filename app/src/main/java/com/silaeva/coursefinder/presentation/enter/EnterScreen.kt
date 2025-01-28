package com.silaeva.coursefinder.presentation.enter

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.silaeva.coursefinder.R
import com.silaeva.coursefinder.presentation.comon_ui.InputTextField
import com.silaeva.coursefinder.presentation.comon_ui.common_buttons.PrimaryButton
import com.silaeva.coursefinder.presentation.comon_ui.theme.BlueVK
import com.silaeva.coursefinder.presentation.comon_ui.theme.Dark
import com.silaeva.coursefinder.presentation.comon_ui.theme.Green
import com.silaeva.coursefinder.presentation.comon_ui.theme.OrangeBottom
import com.silaeva.coursefinder.presentation.comon_ui.theme.OrangeTop
import com.silaeva.coursefinder.presentation.comon_ui.theme.Spacing
import com.silaeva.coursefinder.presentation.comon_ui.theme.Stroke
import com.silaeva.coursefinder.presentation.comon_ui.theme.Typography
import com.silaeva.coursefinder.presentation.comon_ui.theme.White
import org.koin.androidx.compose.koinViewModel

@Composable
fun EnterScreen() {

    val viewModel: EnterViewModel = koinViewModel()

    EnterScreenUI(
        onEnter = {
            viewModel.onBottomNavBar()
        },
        onRegistrationScreen = {
            viewModel.onRegistrationScreen()
        }
    )
}

@Composable
fun EnterScreenUI(
    onEnter: () -> Unit,
    onRegistrationScreen: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Dark)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Spacing.paddingMiddle),
            verticalArrangement = Arrangement.spacedBy(Spacing.paddingMiddle)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = Spacing.onboardingTop,
                        bottom = Spacing.paddingLarge
                    ),
                text = "Вход",
                style = Typography.headlineLarge
            )
            InputTextField(
                title = "Email",
                hint = "example@gmail.com",
                isError = false,
                onTextChange = {}
            )
            InputTextField(
                title = "Пароль",
                hint = "Введите пароль",
                isError = false,
                onTextChange = {}
            )

            PrimaryButton(
                modifier = Modifier.padding(top = Spacing.paddingTiny),
                text = "Вход",
                backgroundColor = Green,
                onClick = onEnter
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(Spacing.paddingTiny)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Нету аккаунта? ",
                        color = White,
                        style = Typography.labelSmall
                    )
                    Text(
                        modifier = Modifier.clickable { onRegistrationScreen() },
                        text = "Регистрация",
                        color = Green,
                        style = Typography.labelSmall
                    )
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {  },
                    textAlign = TextAlign.Center,
                    text = "Забыл пароль",
                    color = Green,
                    style = Typography.labelSmall
                )
            }
            HorizontalDivider(
                modifier = Modifier
                    .padding(vertical = Spacing.paddingMiddle)
                    .fillMaxWidth(),
                thickness = Spacing.border,
                color = Stroke
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(Spacing.paddingMiddle)
            ) {
                Button(
                    modifier = Modifier
                        .weight(0.5f)
                        .clip(RoundedCornerShape(Spacing.commonRadius))
                        .background(color = BlueVK),
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = BlueVK
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_vk),
                        contentDescription = null,
                        tint = White
                    )
                }
                Button(
                    modifier = Modifier
                        .weight(0.5f)
                        .clip(RoundedCornerShape(Spacing.commonRadius))
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    OrangeTop,
                                    OrangeBottom
                                )
                            )
                        ),
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_ok),
                        contentDescription = null,
                        tint = White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EnterScreenPreview() {
    EnterScreenUI(
        onEnter = {},
        onRegistrationScreen = {}
    )
}