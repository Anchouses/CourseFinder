package com.silaeva.coursefinder.presentation.course

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.silaeva.coursefinder.R
import com.silaeva.coursefinder.domain.domain_model.CourseModel
import com.silaeva.coursefinder.presentation.comon_ui.common_buttons.PrimaryButton
import com.silaeva.coursefinder.presentation.comon_ui.theme.Dark
import com.silaeva.coursefinder.presentation.comon_ui.theme.DarkGray
import com.silaeva.coursefinder.presentation.comon_ui.theme.Glass
import com.silaeva.coursefinder.presentation.comon_ui.theme.Green
import com.silaeva.coursefinder.presentation.comon_ui.theme.Spacing
import com.silaeva.coursefinder.presentation.comon_ui.theme.Typography
import com.silaeva.coursefinder.presentation.comon_ui.theme.White
import com.silaeva.coursefinder.presentation.comon_ui.theme.WhiteDescribeText

@Composable
fun CourseScreen(
    courseModel: CourseModel,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Dark)
            .padding(Spacing.paddingMiddle)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(Spacing.courseImageHeight)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.exampl),
                contentDescription = null
            )
            IconButton(
                modifier = Modifier
                    .padding(Spacing.paddingTiny)
                    .align(Alignment.TopEnd)
                    .background(
                        color = White,
                        shape = CircleShape
                    ),
                onClick = { },
                content = {
                    Icon(
                        modifier = Modifier
                            .padding(Spacing.paddingTiny),
                        painter = painterResource(id = R.drawable.ic_bookmark_border),
                        contentDescription = null,
                        tint = Dark
                    )
                }
            )
            IconButton(
                modifier = Modifier
                    .padding(Spacing.paddingTiny)
                    .align(Alignment.TopStart)
                    .background(
                        color = White,
                        shape = CircleShape
                    ),
                onClick = onBackClick,
                content = {
                    Icon(
                        modifier = Modifier
                            .padding(Spacing.paddingTiny),
                        painter = painterResource(id = R.drawable.ic_backspace),
                        contentDescription = null,
                        tint = Dark
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
                        text = courseModel.rating,
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
                        text = courseModel.date,
                        color = White
                    )
                }
            }
        }

        LazyColumn(
            modifier = Modifier
                .padding(horizontal = Spacing.paddingMiddle)
        ) {
            item {
                Text(
                    modifier = Modifier
                        .padding(vertical = Spacing.paddingMiddle),
                    text = courseModel.name,
                    style = Typography.titleLarge
                )
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.ic_star_fill),
                        contentDescription = null
                    )
                    Column {
                        Text(
                            text = "Author",
                            style = Typography.labelSmall,
                            color = WhiteDescribeText
                        )
                        Text(
                            modifier = Modifier.padding(bottom = Spacing.paddingLarge),
                            text = courseModel.owner.toString(),
                            style = Typography.titleMedium
                        )
                    }
                }
                PrimaryButton(
                    text = "Начать курс",
                    backgroundColor = Green,
                    onClick = { }
                )
                PrimaryButton(
                    modifier = Modifier.padding(top = Spacing.paddingTiny),
                    text = "Перейти на платформу",
                    backgroundColor = DarkGray,
                    onClick = { }
                )
                Text(
                    modifier = Modifier
                        .padding(
                            top = Spacing.commonRadius,
                            bottom = Spacing.paddingMiddle
                        ),
                    text = "О курсе",
                    style = Typography.titleLarge
                )
                Text(
                    text = courseModel.summary,
                    style = Typography.bodyMedium,
                    color = WhiteDescribeText
                )
                Spacer(modifier = Modifier.height(Spacing.screenBottomMargin))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseScreenPreview() {
    CourseScreen(
        CourseModel(
            id = 0L,
            name = "",
            owner = 0L,
            summary = "",
            rating = "",
            date = "",
            price = "",
            imageUrl = ""
        ),
        onBackClick = {}
    )
}