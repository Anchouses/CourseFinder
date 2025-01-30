package com.silaeva.coursefinder.domain.interactor_impl

import androidx.paging.PagingData
import com.silaeva.coursefinder.data.data_model.CourseOwner
import com.silaeva.coursefinder.data.data_model.CourseReview
import com.silaeva.coursefinder.domain.domain_model.CourseModel
import com.silaeva.coursefinder.domain.interactor.GetCoursesInteractor
import com.silaeva.coursefinder.domain.repositories.GetCoursesRepository
import kotlinx.coroutines.flow.Flow

class GetCoursesInteractorImpl(
    private val getCoursesRepository: GetCoursesRepository
): GetCoursesInteractor {

    override fun getCourses(searchText: String): Flow<PagingData<CourseModel>> {
        return getCoursesRepository.getCourses(searchText)
    }

    override suspend fun getReview(id: Long): CourseReview {
        return getCoursesRepository.getReview(id)
    }

    override suspend fun getOwner(id: Long): CourseOwner {
        return getCoursesRepository.getOwner(id)
    }
}