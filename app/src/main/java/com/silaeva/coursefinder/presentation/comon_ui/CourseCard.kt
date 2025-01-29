package com.silaeva.coursefinder.presentation.comon_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.silaeva.coursefinder.R
import com.silaeva.coursefinder.presentation.comon_ui.theme.DarkGray
import com.silaeva.coursefinder.presentation.comon_ui.theme.Glass
import com.silaeva.coursefinder.presentation.comon_ui.theme.Green
import com.silaeva.coursefinder.presentation.comon_ui.theme.Spacing
import com.silaeva.coursefinder.presentation.comon_ui.theme.Typography
import com.silaeva.coursefinder.presentation.comon_ui.theme.White
import com.silaeva.coursefinder.presentation.comon_ui.theme.WhiteDescribeText

@Composable
fun CourseCard(
    title: String,
    description: String,
    price: String,
    date: String,
    rating: String,
    onDescriptionClick: () -> Unit,
    addToFavorites: () -> Unit,
    isSaved: Boolean = true
) {
    Column(
        modifier = Modifier
            .padding(bottom = Spacing.paddingMiddle)
            .fillMaxWidth()
            .background(
                color = DarkGray,
                shape = RoundedCornerShape(Spacing.paddingMiddle)
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(Spacing.imageHeight)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(Spacing.paddingMiddle)),
                painter = painterResource(id = R.drawable.exampl),
                contentDescription = null
            )
            IconButton(
                modifier = Modifier
                    .padding(Spacing.paddingTiny)
                    .align(Alignment.TopEnd)
                    .background(
                        color = Glass,
                        shape = CircleShape
                    ),
                onClick = {
                    addToFavorites()
                },
                content = {
                    Icon(
                        modifier = Modifier
                            .padding(Spacing.paddingTiny),
                        painter = if (isSaved) {
                            painterResource(id = R.drawable.ic_bookmark)
                        } else {
                            painterResource(id = R.drawable.ic_bookmark_border)
                        },
                        contentDescription = null,
                        tint = if (isSaved) Green else White
                    )
                }
            )
            Row(
                modifier = Modifier
                    .padding(Spacing.paddingTiny)
                    .align(Alignment.BottomStart),
                horizontalArrangement = Arrangement.spacedBy(Spacing.paddingExtraTiny),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .background(
                            color = Glass,
                            shape = RoundedCornerShape(Spacing.commonRadius)
                        )
                        .padding(
                            vertical = Spacing.paddingExtraTiny,
                            horizontal = Spacing.paddingTiny
                        ),
                    horizontalArrangement = Arrangement.spacedBy(Spacing.paddingExtraTiny),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_star_fill),
                        contentDescription = null,
                        tint = Green
                    )
                    Text(
                        text = rating,
                        color = White
                    )
                }
                Row(
                    modifier = Modifier
                        .background(
                            color = Glass,
                            shape = RoundedCornerShape(Spacing.commonRadius)
                        )
                        .padding(
                            vertical = Spacing.paddingExtraTiny,
                            horizontal = Spacing.paddingTiny
                        )
                ) {
                    Text(
                        text = date,
                        color = White
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Spacing.paddingMiddle)
        ) {
            Text(
                text = title,
                style = Typography.titleMedium
            )
            Text(
                text = description,
                modifier = Modifier
                    .padding(
                        vertical = Spacing.paddingSmall
                    ),
                style = Typography.bodySmall,
                color = WhiteDescribeText
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = price,
                    style = Typography.titleMedium
                )
                Row(
                    modifier = Modifier.clickable {
                        onDescriptionClick()
                    }
                ) {
                    Text(
                        text = "Подробнее",
                        style = Typography.labelSmall,
                        color = Green
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_right),
                        contentDescription = null,
                        tint = Green
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CourseCardPreview() {
    CourseCard(
        title = "vcvzds",
        description = "afsdf",
        price = "6565",
        onDescriptionClick = {},
        addToFavorites = {},
        date = "",
        rating = "4,5",
        isSaved = true
    )
}