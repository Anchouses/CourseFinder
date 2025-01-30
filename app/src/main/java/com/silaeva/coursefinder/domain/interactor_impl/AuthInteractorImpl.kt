package com.silaeva.coursefinder.domain.interactor_impl

import com.silaeva.coursefinder.domain.domain_model.AuthUserModel
import com.silaeva.coursefinder.domain.interactor.AuthInteractor
import com.silaeva.coursefinder.domain.repositories.AuthRepository

class AuthInteractorImpl(
private val authRepository: AuthRepository
): AuthInteractor {

    override suspend fun authByEmail(email: String, password: String) {
        authRepository.authByEmail(email, password)
    }

    override suspend fun recoveryByEmail(email: String) {
        authRepository.recoveryByEmail(email)
    }

    override suspend fun recoveryCode(code: Int) {
        authRepository.recoveryCode(code)
    }

    override suspend fun authNewUser(authUser: AuthUserModel): AuthUserModel? {
        return authRepository.authNewUser(authUser)
    }
}