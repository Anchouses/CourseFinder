package com.silaeva.coursefinder.data.repository_impl

import android.util.Log
import com.silaeva.coursefinder.data.retrofit_api.CoursesApi
import com.silaeva.coursefinder.data.retrofite_client.RetrofitClient
import com.silaeva.coursefinder.domain.domain_model.CourseModel
import com.silaeva.coursefinder.domain.domain_model.CourseResponseModel
import com.silaeva.coursefinder.domain.domain_model.MetaModel
import com.silaeva.coursefinder.domain.repositories.CoursesRepository

class CoursesRepositoryImpl(private val retrofitClient: RetrofitClient): CoursesRepository {

    private val api: CoursesApi = retrofitClient.retrofit.create(CoursesApi::class.java)

    override suspend fun getCourses(page: Int, size: Int): CourseResponseModel {
        val result = api.getCourses(page, size)
        Log.d("REQUEST", "${result.body()}")
        var resultModel: CourseResponseModel? = null
        try {
            if (result.isSuccessful) {
                resultModel = result.body()?.let {
                    CourseResponseModel(
                        courses = it.courses.map { course ->
                            CourseModel(
                                id = course.id,
                                name = course.title,
                                author = course.owner,
                                description = course.description,
                                rating = course.reviewSummary,
                                date = course.createDate,
                                price = course.price,
                                imageUrl = course.cover
                            )
                        },
                        meta = MetaModel(
                            page = it.meta.page,
                            hasNext = it.meta.hasNext,
                            hasPrevious = it.meta.hasPrevious
                        )
                    )
                }
            } else {
                Log.e("REQUEST", "Error fetching courses: ${result.errorBody()?.string()}")
            }
        } catch (e: Exception) {
            Log.e("REQUEST", "Error fetching courses: $e")
        }
        Log.d("REQUEST", "$resultModel")
        return resultModel ?: CourseResponseModel(courses = emptyList(), meta = MetaModel(page = 0, hasNext = false, hasPrevious = false))
    }
}