package com.silaeva.coursefinder.presentation.bottom_nav_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.silaeva.coursefinder.R
import com.silaeva.coursefinder.domain.domain_model.CourseModel
import com.silaeva.coursefinder.presentation.comon_ui.BottomNavIcon
import com.silaeva.coursefinder.presentation.comon_ui.theme.DarkGray
import com.silaeva.coursefinder.presentation.comon_ui.theme.Spacing
import com.silaeva.coursefinder.presentation.comon_ui.theme.Stroke
import com.silaeva.coursefinder.presentation.course.CourseScreen
import com.silaeva.coursefinder.presentation.data_source.Direction
import com.silaeva.coursefinder.presentation.favorites.FavoritesScreen
import com.silaeva.coursefinder.presentation.profile.ProfileScreen
import com.silaeva.coursefinder.presentation.search.SearchScreen


@Composable
fun BottomNavBar() {

    var direction by remember { mutableStateOf(Direction.SEARCH) }
    var courseState by remember {
        mutableStateOf(
            CourseModel(0L, "", "", "", "", "", "", "", false)
        )
    }
    var isShowCourse by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        when (direction) {
            Direction.SEARCH -> SearchScreen(
                onCourseClick = { course ->
                    courseState = course
                    isShowCourse = true
                }
            )

            Direction.FAVOURITES -> FavoritesScreen(
                onCourseClick = { course ->
                    courseState = course
                    isShowCourse = true
                }
            )

            Direction.PROFILE -> ProfileScreen(
                onCourseClick = { course ->
                    courseState = course
                    isShowCourse = true
                }
            )

            else -> SearchScreen(
                onCourseClick = { course ->
                    courseState = course
                    isShowCourse = true
                }
            )
        }
        if (isShowCourse) {
            CourseScreen(
                courseModel = courseState,
                onBackClick = {
                    isShowCourse = false
                }
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = Spacing.border,
                color = Stroke
            )
            Row(
                modifier = Modifier
                    .background(color = DarkGray)
                    .padding(
                        top = Spacing.paddingSmall,
                        bottom = Spacing.paddingMiddle
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

@Preview(showBackground = true)
@Composable
fun BottomNavBarPreview() {
    BottomNavBar()
}
