package com.silaeva.coursefinder.presentation.registration

import androidx.lifecycle.viewModelScope
import com.silaeva.coursefinder.domain.domain_model.AuthUserModel
import com.silaeva.coursefinder.domain.repositories.AuthRepository
import com.silaeva.coursefinder.presentation.base.BaseViewModel
import com.silaeva.coursefinder.presentation.data_source.Direction
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class RegistrationViewModel(private val authRepository: AuthRepository): BaseViewModel() {

    private var requestJob: Job? = null

    fun authNewUser(authUserModel: AuthUserModel) {
        requestJob?.cancel()

        requestJob = viewModelScope.launch {
            authRepository.authNewUser(authUserModel)
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