package com.silaeva.coursefinder.presentation.enter

import androidx.lifecycle.viewModelScope
import com.silaeva.coursefinder.domain.repositories.AuthRepository
import com.silaeva.coursefinder.presentation.base.BaseViewModel
import com.silaeva.coursefinder.presentation.data_source.Direction
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class EnterViewModel(private val authRepository: AuthRepository): BaseViewModel() {

    private var requestJob: Job? = null

    fun authByEmail(email: String, password: String) {
        requestJob?.cancel()

        requestJob = viewModelScope.launch {
            authRepository.authByEmail(email, password)
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