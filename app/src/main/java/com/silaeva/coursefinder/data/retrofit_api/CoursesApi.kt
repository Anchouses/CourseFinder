package com.silaeva.coursefinder.data.retrofit_api

import com.silaeva.coursefinder.data.data_model.CourseResponse
import com.silaeva.coursefinder.data.data_model.OwnerResponse
import com.silaeva.coursefinder.data.data_model.ReviewResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CoursesApi {
    @GET("/api/courses?")
    suspend fun getCourses(
        @Query("page") page: Int,
        @Query("language") language: String = "ru",
        @Query("is_public") public: Boolean = true,
        @Query("search") search: String
    ): Response<CourseResponse>

    @GET("/api/course-review-summaries?")
    suspend fun getReview(
        @Query("id") reviewId: Long,
    ): Response<ReviewResponse>

    @GET("/api/users?")
    suspend fun getOwner(
        @Query("id") ownerId: Long,
    ): Response<OwnerResponse>
}