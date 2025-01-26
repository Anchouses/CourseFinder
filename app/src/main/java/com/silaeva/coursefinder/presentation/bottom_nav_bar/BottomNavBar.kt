package com.silaeva.coursefinder.presentation.bottom_nav_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.silaeva.coursefinder.R
import com.silaeva.coursefinder.presentation.comon_ui.BottomNavIcon
import com.silaeva.coursefinder.presentation.comon_ui.theme.DarkGray
import com.silaeva.coursefinder.presentation.comon_ui.theme.Spacing
import com.silaeva.coursefinder.presentation.comon_ui.theme.Stroke
import com.silaeva.coursefinder.presentation.data_source.Direction


@Composable
fun BottomNavBar() {

    var direction by remember { mutableStateOf(Direction.SEARCH) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .wrapContentHeight(),
//            contentAlignment = Alignment.TopCenter
//        ) {
////            when (direction) {
////                Direction.SEARCH -> SearchEventScreen()
////                Direction.FAVOURITES -> ChatListScreen()
////                Direction.PROFILE -> ProfileScreen()
////                else -> SearchEventScreen()
//            }
//        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentAlignment = Alignment.BottomCenter
        ) {
            HorizontalDivider(
                thickness = Spacing.border,
                color = Stroke
            )
            Row(
                modifier = Modifier
                    .background(color = DarkGray)
                    .padding(
//                        top = dimensionResource(id = R.dimen.common_margin_tiny),
//                        bottom = dimensionResource(id = R.dimen.common_margin_tiny)
                    )
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Top
            ) {
                BottomNavIcon(
                    painterResource = R.drawable.ic_house,
                    title = "Главная",
                    onClick = {
                        direction = Direction.SEARCH
                    },
                    isClicked = direction == Direction.SEARCH
                )

                BottomNavIcon(
                    painterResource = R.drawable.ic_bookmark_border,
                    title = "Избранное",
                    onClick = {
                        direction = Direction.FAVOURITES
                    },
                    isClicked = direction == Direction.FAVOURITES
                )

                BottomNavIcon(
                    painterResource = R.drawable.ic_person,
                    title = "Аккаунт",
                    onClick = {
                        direction = Direction.PROFILE
                    },
                    isClicked = direction == Direction.PROFILE
                )
            }
        }
    }
}
