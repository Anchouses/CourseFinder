package com.silaeva.coursefinder.data.repository_impl

import androidx.paging.PagingData
import com.silaeva.coursefinder.data.data_model.CourseOwner
import com.silaeva.coursefinder.data.data_model.CourseReview
import com.silaeva.coursefinder.data.data_model.ReviewResponse
import com.silaeva.coursefinder.data.paging.RemoteDataSource
import com.silaeva.coursefinder.data.retrofite_client.RetrofitClient
import com.silaeva.coursefinder.domain.domain_model.CourseModel
import com.silaeva.coursefinder.domain.repositories.GetCoursesRepository
import kotlinx.coroutines.flow.Flow

class GetCoursesRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val retrofitClient: RetrofitClient
) : GetCoursesRepository {

    override fun getCourses(searchText: String): Flow<PagingData<CourseModel>> =
        remoteDataSource.getCourses(searchText)

    override suspend fun getReview(id: Long): CourseReview {
        val response = retrofitClient.coursesApi.getReview(id)
        return try {
            if (response.isSuccessful) {
                response.body()?.let {
                    it.reviews[0]
                } ?: throw Exception("Response body is null")
            } else {
                throw Exception("Error: ${response.code()}")
            }
        } catch (e: Exception) {
            CourseReview(
                id = 0L,
                courseId = 0L,
                average = .0
            )
        }
    }

    override suspend fun getOwner(id: Long): CourseOwner {
        val response = retrofitClient.coursesApi.getOwner(id)
        return try {
            if (response.isSuccessful) {
                response.body()?.let {
                    it.users[0]
                } ?: throw Exception("Response body is null")
            } else {
                throw Exception("Error: ${response.code()}")
            }
        } catch (e: Exception) {
            CourseOwner(
                id = 0L,
                fullName = "",
            )
        }
    }
}