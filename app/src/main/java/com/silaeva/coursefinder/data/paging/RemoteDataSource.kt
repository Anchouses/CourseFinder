package com.silaeva.coursefinder.data.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.silaeva.coursefinder.data.retrofit_api.CoursesApi

class RemoteDataSource(
    private val coursesApi: CoursesApi
) {
    fun getCourses(searchText: String) = Pager(
        config = PagingConfig(pageSize = 20),
        pagingSourceFactory = { CoursesPagingSource(coursesApi, searchText) }
    ).flow
}