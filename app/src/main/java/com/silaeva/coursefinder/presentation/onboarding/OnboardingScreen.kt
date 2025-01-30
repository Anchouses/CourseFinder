package com.silaeva.coursefinder.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
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
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Dark)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            verticalArrangement = Arrangement.Center
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
                    .fillMaxWidth()
                    .height(Spacing.onboardingHeight),
                painter = painterResource(id = R.drawable.onboarding),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        PrimaryButton(
            modifier = Modifier
                .padding(
                    start = Spacing.paddingMiddle,
                    end = Spacing.paddingMiddle,
                    bottom = Spacing.onboardingBottom
                )
                .align(Alignment.BottomCenter),
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