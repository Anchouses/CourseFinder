package com.silaeva.coursefinder.data.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.silaeva.coursefinder.data.retrofit_api.CoursesApi
import com.silaeva.coursefinder.domain.domain_model.CourseModel

class CoursesPagingSource(
    private val coursesApi: CoursesApi,
    private val searchText: String
) : PagingSource<Int, CourseModel>() {
    override fun getRefreshKey(state: PagingState<Int, CourseModel>): Int? {
        return state.anchorPosition
    }
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CourseModel> {
        return try {
            val page = params.key ?: 1
            val response = coursesApi.getCourses(page, search = "Android $searchText")
            val body = response.body()
            val meta = body?.meta
            val courses: List<CourseModel> = body?.courses?.map {
                CourseModel(
                    id = it.id ?: 0,
                    name = it.title ?: "",
                    owner = it.owner ?: 0L,
                    description = it.summary ?: "",
                    rating = it.reviewSummary.toString() ?: "",
                    date = it.createDate ?: "",
                    price = it.price ?: "",
                    imageUrl = it.proctorUrl ?: ""
                )
            } ?: emptyList()
            if (response.isSuccessful) {
            LoadResult.Page(
                data = courses,
                prevKey = if (meta?.hasPrevious == true) page - 1 else null,
                nextKey = if (meta?.hasNext == true) page + 1 else null
            )
            } else {
                LoadResult.Error(Exception("Error fetching data"))
            }
        } catch (exception: Exception) {
            Log.d("EXCEPTION", exception.message.toString())
            LoadResult.Error(exception)
        }
    }
}