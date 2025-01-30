package com.silaeva.coursefinder.presentation.enter

import androidx.lifecycle.viewModelScope
import com.silaeva.coursefinder.domain.interactor.AuthInteractor
import com.silaeva.coursefinder.presentation.base.BaseViewModel
import com.silaeva.coursefinder.presentation.presentation_model.Direction
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class EnterViewModel(
    private val authInteractor: AuthInteractor
): BaseViewModel() {

    private var requestJob: Job? = null

    fun authByEmail(email: String, password: String) {
        requestJob?.cancel()

        requestJob = viewModelScope.launch {
            authInteractor.authByEmail(email, password)
        }
    }

    fun onBottomNavBar() {
        updateDirection(Direction.MAIN)
    }

    fun onRegistrationScreen() {
        updateDirection(Direction.REGISTRATION)
    }

    override fun updateDirection(direction: Direction) {
        _navigation.tryEmit(direction)
    }
}