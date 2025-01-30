package com.silaeva.coursefinder.presentation.search

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.silaeva.coursefinder.data.data_model.CourseReview
import com.silaeva.coursefinder.domain.domain_model.CourseModel
import com.silaeva.coursefinder.presentation.comon_ui.CourseCard
import com.silaeva.coursefinder.presentation.comon_ui.FilterDialog
import com.silaeva.coursefinder.presentation.comon_ui.inputs.SearchField
import com.silaeva.coursefinder.presentation.comon_ui.theme.Dark
import com.silaeva.coursefinder.presentation.comon_ui.theme.Spacing
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchScreen(
    onCourseClick: (CourseModel) -> Unit
) {
    val viewModel: SearchViewModel = koinViewModel()
    val searchText = remember { mutableStateOf("") }
    val pager = viewModel.getCourses(searchText.value)
    val lazyPagingItems = pager.collectAsLazyPagingItems()

    SearchScreenUI(
        viewModel = viewModel,
        lazyPagingItems = lazyPagingItems,
        addSearchText = {
            searchText.value = it
        },
        addCourseToFavorites = {course, review, owner ->
            viewModel.saveCourse(course, review, owner)
        },
        onCourseClick = { course, review, owner ->
            val correctCourse = course.copy(review = review, owner = owner)
            onCourseClick(correctCourse)
        }
    )
}

@Composable
fun SearchScreenUI(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel,
    lazyPagingItems: LazyPagingItems<CourseModel>,
    addSearchText: (String) -> Unit,
    addCourseToFavorites: (CourseModel, String, String) -> Unit,
    onCourseClick: (CourseModel, String, String) -> Unit
) {
    var openDialog by remember { mutableStateOf(false) }
    var searchText = ""

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Dark)
            .padding(Spacing.paddingMiddle),
        verticalArrangement = Arrangement.spacedBy(Spacing.paddingMiddle),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchField(
            hint = "Search courses",
            getResult = { },
            onFilterClick = {
                openDialog = true
            }
        )
        when (lazyPagingItems.loadState.refresh) {
            is LoadState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            is LoadState.Error -> {
                Log.d("LOAD_ERROR", "Loading error")
            }
            is LoadState.NotLoading -> {
                LazyColumn {
                    items(
                        count = lazyPagingItems.itemCount,
                        key = lazyPagingItems.itemKey { it.id }
                    ) {
                        lazyPagingItems[it]?.let { item ->
                            viewModel.getOwnerAndReview(ownerId = item.owner.toLong(), reviewId = item.review.toLong())
                            val owner = viewModel.owner.collectAsState()
                            val review = viewModel.review.collectAsState(initial = CourseReview(0L, 0L, .0))
                            CourseCard(
                                title = item.name,
                                description = item.summary,
                                price = item.price,
                                onCourseClick = {
                                    onCourseClick(item, review.value.average.toString(), owner.value.fullName ?: "")
                                },
                                addToFavorites = {
                                    addCourseToFavorites(item, review.value.average.toString(), owner.value.fullName ?: "")
                                },
                                rating = review.value.average.toString(),
                                date = item.date,
                                isSaved = false
                            )
                        }
                    }
                    item {
                        Spacer(modifier = Modifier.height(Spacing.screenBottomMargin))
                    }
                }
            }
        }
    }
    FilterDialog(
        openDialog = openDialog,
        onDismiss = {
            it.forEach {
                searchText += " " + it
            }
            addSearchText(searchText)
            openDialog = false
        }
    )
}