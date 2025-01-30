package com.silaeva.coursefinder.presentation.profile

import com.silaeva.coursefinder.domain.interactor.FavoriteCoursesInteractor
import com.silaeva.coursefinder.presentation.base.BaseViewModel
import com.silaeva.coursefinder.presentation.data_source.Direction

class ProfileViewModel(
    private val favoriteCoursesInteractor: FavoriteCoursesInteractor
): BaseViewModel() {

    fun getCourses() = favoriteCoursesInteractor.getFavoriteCourses()

    override fun updateDirection(direction: Direction) {}
}