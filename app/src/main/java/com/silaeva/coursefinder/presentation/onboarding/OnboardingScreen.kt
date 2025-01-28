package com.silaeva.coursefinder.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.silaeva.coursefinder.R
import com.silaeva.coursefinder.presentation.comon_ui.common_buttons.PrimaryButton
import com.silaeva.coursefinder.presentation.comon_ui.theme.Dark
import com.silaeva.coursefinder.presentation.comon_ui.theme.Green
import com.silaeva.coursefinder.presentation.comon_ui.theme.Spacing
import com.silaeva.coursefinder.presentation.comon_ui.theme.Typography
import org.koin.androidx.compose.koinViewModel


@Composable
fun OnboardingScreen() {
    val viewModel: OnboardingViewModel = koinViewModel()

    OnboardingScreenUI(
        onRegistrationScreen = {
            viewModel.onRegistrationScreenClick()
        }
    )
}
@Composable
fun OnboardingScreenUI(
    onRegistrationScreen: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Dark),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = Spacing.onboardingTop,
                        bottom = Spacing.paddingLarge,
                        start = Spacing.paddingLarge,
                        end = Spacing.paddingLarge
                    ),
                text = "Тысячи курсов\nв одном месте",
                style = Typography.headlineLarge,
                textAlign = TextAlign.Center
            )
            Image(
                modifier = Modifier
                    .height(Spacing.onboardingHeight),
                painter = painterResource(id = R.drawable.onboarding),
                contentDescription = null
            )
        }
        PrimaryButton(
            modifier = Modifier.padding(
                start = Spacing.paddingMiddle,
                end = Spacing.paddingMiddle,
                bottom = Spacing.onboardingBottom
            ),
            text = "Продолжить",
            backgroundColor = Green,
            onClick = onRegistrationScreen
        )
    }
}


@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreenUI(
        onRegistrationScreen = {}
    )
}