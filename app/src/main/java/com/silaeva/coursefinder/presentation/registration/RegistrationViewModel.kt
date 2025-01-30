package com.silaeva.coursefinder.presentation.registration

import androidx.lifecycle.viewModelScope
import com.silaeva.coursefinder.domain.domain_model.AuthUserModel
import com.silaeva.coursefinder.domain.interactor.AuthInteractor
import com.silaeva.coursefinder.presentation.base.BaseViewModel
import com.silaeva.coursefinder.presentation.presentation_model.Direction
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class RegistrationViewModel(
    private val authInteractor: AuthInteractor
): BaseViewModel() {

    private var requestJob: Job? = null

    fun authNewUser(authUserModel: AuthUserModel) {
        requestJob?.cancel()
        requestJob = viewModelScope.launch {
            authInteractor.authNewUser(authUserModel)
        }
    }

    fun onPreviousScreenClick() {
        updateDirection(Direction.ONBOARDING)
    }
    fun onEnterScreenClick() {
        updateDirection(direction = Direction.ENTER)
    }
    override fun updateDirection(direction: Direction) {
        _navigation.tryEmit(direction)
    }
}