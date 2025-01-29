package com.silaeva.coursefinder.presentation.search

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
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
import com.silaeva.coursefinder.domain.domain_model.CourseModel
import com.silaeva.coursefinder.presentation.comon_ui.CourseCard
import com.silaeva.coursefinder.presentation.comon_ui.FilterDialog
import com.silaeva.coursefinder.presentation.comon_ui.SearchField
import com.silaeva.coursefinder.presentation.comon_ui.theme.Dark
import com.silaeva.coursefinder.presentation.comon_ui.theme.Spacing
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchScreen() {
    val viewModel: SearchViewModel = koinViewModel()
    val searchText = remember {
        mutableStateOf("")
    }
    val pager = viewModel.getCourses(searchText.value)
    val lazyPagingItems = pager.collectAsLazyPagingItems()

    SearchScreenUI(
        lazyPagingItems = lazyPagingItems,
        addSearchText = {
            searchText.value = it
        }
    )
}

@Composable
fun SearchScreenUI(
    modifier: Modifier = Modifier,
    lazyPagingItems: LazyPagingItems<CourseModel>,
    addSearchText: (String) -> Unit
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
                            CourseCard(
                                title = item.name,
                                description = item.description,
                                price = item.price,
                                onDescriptionClick = { },
                                addToFavorites = { },
                                rating = "",
                                date = item.date,

                            )
                        }
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