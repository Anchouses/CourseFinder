package com.silaeva.coursefinder.presentation.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.silaeva.coursefinder.domain.domain_model.CourseModel
import com.silaeva.coursefinder.presentation.comon_ui.CourseCard
import com.silaeva.coursefinder.presentation.comon_ui.theme.Dark
import com.silaeva.coursefinder.presentation.comon_ui.theme.Spacing
import com.silaeva.coursefinder.presentation.comon_ui.theme.Typography
import org.koin.androidx.compose.koinViewModel


@Composable
fun FavoritesScreen() {

    val viewModel: FavoritesViewModel = koinViewModel()
    val courses = viewModel.getCourses().collectAsState(initial = emptyList())

    FavoritesScreenUI(
        courses = courses.value
    )
}

@Composable
fun FavoritesScreenUI(
    courses: List<CourseModel>
) {
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
            text = "Избранное",
            style = Typography.headlineLarge
        )
        LazyColumn {
            items(courses.size) {
                CourseCard(
                    title = courses[it].name,
                    description = courses[it].description,
                    price = courses[it].price,
                    onDescriptionClick = {  },
                    rating = courses[it].rating,
                    date = courses[it].date
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritesScreenPreview() {
    FavoritesScreenUI(
        courses = emptyList()
    )
}