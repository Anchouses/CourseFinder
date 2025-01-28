package com.silaeva.coursefinder.presentation.search

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.LoadState
import androidx.paging.Pager
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.silaeva.coursefinder.domain.domain_model.CourseModel
import com.silaeva.coursefinder.presentation.comon_ui.CourseCard
import com.silaeva.coursefinder.presentation.comon_ui.SearchField
import com.silaeva.coursefinder.presentation.comon_ui.theme.Dark
import com.silaeva.coursefinder.presentation.comon_ui.theme.Spacing
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchScreen() {

    val viewModel: SearchViewModel = koinViewModel()
    Log.d("REQUEST_VM", "${viewModel.getPager().flow.collectAsLazyPagingItems().loadState}")
    val pager: Pager<Int, CourseModel> = viewModel.getPager()
    val lazyPagingItems = pager.flow.collectAsLazyPagingItems()
    SearchScreenUI(
        lazyPagingItems = lazyPagingItems
    )
}

@Composable
fun SearchScreenUI(
    modifier: Modifier = Modifier,
    lazyPagingItems: LazyPagingItems<CourseModel>
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Dark)
            .padding(Spacing.paddingMiddle),
        verticalArrangement = Arrangement.spacedBy(Spacing.paddingMiddle)
    ) {
        SearchField(
            hint = "Search courses",
            getResult = { }
        )
        when (lazyPagingItems.loadState.refresh) {
            is LoadState.Loading -> {

            }
            is LoadState.Error -> {

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
                                addToFavorites = { }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {

}
