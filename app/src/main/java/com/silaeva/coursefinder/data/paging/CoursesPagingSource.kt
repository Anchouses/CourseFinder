package com.silaeva.coursefinder.data.paging

import android.annotation.SuppressLint
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.silaeva.coursefinder.data.retrofit_api.CoursesApi
import com.silaeva.coursefinder.domain.domain_model.CourseModel
import java.text.SimpleDateFormat

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
            val courses: List<CourseModel> = body?.courses?.map { it ->
                CourseModel(
                    id = it.id ?: 0,
                    name = it.title ?: "",
                    owner = it.owner.toString() ?: "",
                    summary = it.summary ?: "",
                    review = it.reviewSummary.toString() ?: "",
                    date = it.createDate?.let { date -> getDate(date) } ?: "",
                    price = it.price?.let { price -> "$price ₽" } ?: "Бесплатно",
                    imageUrl = it.proctorUrl ?: "",
                    isSaved = false
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

    @SuppressLint("SimpleDateFormat")
    fun getDate(date: String): String? {
        val inputDate = date.take(10)
        val inputFormat = SimpleDateFormat("yyyy-MM-dd")
        val outputFormat = SimpleDateFormat("dd MMMM yyyy")
        val transDate = inputFormat.parse(inputDate)
        return transDate?.let { outputFormat.format(it) }
    }

}