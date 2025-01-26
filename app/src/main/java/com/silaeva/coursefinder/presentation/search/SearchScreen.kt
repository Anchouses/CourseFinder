package com.silaeva.coursefinder.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.silaeva.coursefinder.presentation.comon_ui.CourseCard
import com.silaeva.coursefinder.presentation.comon_ui.SearchField
import com.silaeva.coursefinder.presentation.comon_ui.theme.Dark
import com.silaeva.coursefinder.presentation.comon_ui.theme.Spacing

@Composable
fun SearchScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Dark)
            .padding(horizontal = Spacing.paddingMiddle),
        verticalArrangement = Arrangement.spacedBy(Spacing.paddingMiddle)
    ) {
        SearchField(
            hint = "Search courses",
            getResult = { }
        )
        LazyColumn {
            items(10) {
                CourseCard(
                    title = "",
                    description = "",
                    price = "",
                    onDescriptionClick = {  },
                    addToFavorites = {}
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    SearchScreen()
}
