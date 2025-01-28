package com.silaeva.coursefinder.data.retrofit_api

import com.silaeva.coursefinder.data.data_model.CourseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CoursesApi {

    @GET("/api/courses?")
    suspend fun getCourses(
        @Query("page") page: Int,
        @Query("size") size: Int,
        @Query("language") language: String = "ru",
        @Query("public") public: Boolean = true
    ): Response<CourseResponse>
}