package com.silaeva.coursefinder.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.silaeva.coursefinder.R
import com.silaeva.coursefinder.presentation.comon_ui.CourseCard
import com.silaeva.coursefinder.presentation.comon_ui.theme.Dark
import com.silaeva.coursefinder.presentation.comon_ui.theme.DarkGray
import com.silaeva.coursefinder.presentation.comon_ui.theme.Spacing
import com.silaeva.coursefinder.presentation.comon_ui.theme.Stroke
import com.silaeva.coursefinder.presentation.comon_ui.theme.Typography
import com.silaeva.coursefinder.presentation.comon_ui.theme.White
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen() {

    val viewModel: ProfileViewModel = koinViewModel()
    ProfileScreenUI()
}

@Composable
fun ProfileScreenUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Dark)
            .padding(horizontal = Spacing.paddingMiddle)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = Spacing.paddingMiddle
                ),
            text = "Профиль",
            style = Typography.headlineLarge
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = DarkGray,
                    shape = RoundedCornerShape(Spacing.paddingMiddle)
                )
                .padding(
                    horizontal = Spacing.paddingMiddle,
                    vertical = Spacing.paddingTiny
                ),
            verticalArrangement = Arrangement.spacedBy(Spacing.paddingTiny)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.clickable { },
                    text = "Написать в поддержку",
                    style = Typography.bodyMedium
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_forward),
                    contentDescription = null,
                    tint = White
                )
            }
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = Spacing.border,
                color = Stroke
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.clickable { },
                    text = "Настройки",
                    style = Typography.bodyMedium
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_forward),
                    contentDescription = null,
                    tint = White
                )
            }
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = Spacing.border,
                color = Stroke
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.clickable { },
                    text = "Выйти из аккаунта",
                    style = Typography.bodyMedium
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_forward),
                    contentDescription = null,
                    tint = White
                )
            }
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = Spacing.paddingMiddle
                ),
            text = "Ваши курсы",
            style = Typography.headlineLarge
        )
        LazyColumn {
            items(10) {
                CourseCard(
                    title = "",
                    description = "",
                    price = "",
                    onDescriptionClick = {  },
                    addToFavorites = {},
                    rating = "",
                    date = ""
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreenUI()
}