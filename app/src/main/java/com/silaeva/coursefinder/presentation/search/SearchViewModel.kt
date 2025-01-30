package com.silaeva.coursefinder.presentation.search

import androidx.lifecycle.viewModelScope
import com.silaeva.coursefinder.data.data_model.CourseOwner
import com.silaeva.coursefinder.data.data_model.CourseReview
import com.silaeva.coursefinder.domain.domain_model.CourseModel
import com.silaeva.coursefinder.domain.interactor.FavoriteCoursesInteractor
import com.silaeva.coursefinder.domain.repositories.GetCoursesRepository
import com.silaeva.coursefinder.presentation.base.BaseViewModel
import com.silaeva.coursefinder.presentation.data_source.Direction
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SearchViewModel(
    private val getCoursesRepository: GetCoursesRepository,
    private val favoriteCoursesInteractor: FavoriteCoursesInteractor
): BaseViewModel() {

    private var _review = MutableStateFlow(CourseReview(0L, 0L, .0))
    val review: Flow<CourseReview> = _review
        private val _owner = MutableStateFlow(CourseOwner(0L, ""))
    val owner: StateFlow<CourseOwner> = _owner
    private var requestJob: Job? = null

    fun getCourses(searchText: String) = getCoursesRepository.getCourses(searchText)

    fun saveCourse(courseModel: CourseModel, review: String, owner: String) {
        favoriteCoursesInteractor.saveFavoriteCourse(courseModel, owner, review)
    }

    fun getOwnerAndReview(ownerId: Long, reviewId: Long) {
        requestJob?.cancel()
        requestJob = viewModelScope.launch {
            _owner.value = getCoursesRepository.getOwner(ownerId)
            _review.value = getCoursesRepository.getReview(reviewId)
        }
    }

    override fun updateDirection(direction: Direction) {}
}