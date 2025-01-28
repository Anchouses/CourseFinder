package com.silaeva.coursefinder.presentation.onboarding

import com.silaeva.coursefinder.presentation.base.BaseViewModel
import com.silaeva.coursefinder.presentation.data_source.Direction

class OnboardingViewModel: BaseViewModel() {

    fun onRegistrationScreenClick() {
        updateDirection(Direction.REGISTRATION)
    }

    override fun updateDirection(direction: Direction) {
        _navigation.tryEmit(direction)
    }
}