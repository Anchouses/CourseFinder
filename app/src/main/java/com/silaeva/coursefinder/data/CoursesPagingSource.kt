package com.silaeva.coursefinder.data

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.silaeva.coursefinder.domain.domain_model.CourseModel
import com.silaeva.coursefinder.domain.repositories.CoursesRepository

class CoursesPagingSource(
    private val coursesRepository: CoursesRepository
) : PagingSource<Int, CourseModel>() {

    override fun getRefreshKey(state: PagingState<Int, CourseModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CourseModel> {
        val page = params.key ?: 1
        Log.d("REQUEST", "Loading page: $page with size: ${params.loadSize}")
        return try {
            val response = coursesRepository.getCourses(page, 20)
            val courses = response.courses
            Log.d("REQUEST", "${response.courses}")
            LoadResult.Page(
                data = courses,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.meta.hasNext) page + 1 else null
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}