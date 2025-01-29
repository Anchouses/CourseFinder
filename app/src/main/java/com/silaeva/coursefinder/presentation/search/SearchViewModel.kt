package com.silaeva.coursefinder.presentation.search

import com.silaeva.coursefinder.domain.domain_model.CourseModel
import com.silaeva.coursefinder.domain.interactor.FavoriteCoursesInteractor
import com.silaeva.coursefinder.domain.repositories.GetCoursesRepository
import com.silaeva.coursefinder.presentation.base.BaseViewModel
import com.silaeva.coursefinder.presentation.data_source.Direction

class SearchViewModel(
    private val getCoursesRepository: GetCoursesRepository,
    private val favoriteCoursesInteractor: FavoriteCoursesInteractor
): BaseViewModel() {

    fun getCourses(searchText: String) = getCoursesRepository.getCourses(searchText)

    fun saveCourse(courseModel: CourseModel) {
        favoriteCoursesInteractor.saveFavoriteCourse(courseModel)
    }

    override fun updateDirection(direction: Direction) {}
}