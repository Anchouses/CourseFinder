package com.silaeva.coursefinder.presentation.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
fun FavoritesScreen(
    onCourseClick: (CourseModel) -> Unit
) {

    val viewModel: FavoritesViewModel = koinViewModel()
    val courses = viewModel.getCourses().collectAsState(initial = emptyList())

    FavoritesScreenUI(
        courses = courses.value,
        onCourseClick = { onCourseClick(it) }
    )
}

@Composable
fun FavoritesScreenUI(
    courses: List<CourseModel>,
    onCourseClick:(CourseModel) -> Unit
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
                    description = courses[it].summary,
                    price = courses[it].price,
                    onCourseClick = { onCourseClick(courses[it]) },
                    rating = courses[it].review,
                    date = courses[it].date,
                    isSaved = courses[it].isSaved
                )
            }
            item{
                Spacer(modifier = Modifier.height(Spacing.screenBottomMargin * 2))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritesScreenPreview() {
    FavoritesScreenUI(
        courses = emptyList(),
        onCourseClick = {}
    )
}