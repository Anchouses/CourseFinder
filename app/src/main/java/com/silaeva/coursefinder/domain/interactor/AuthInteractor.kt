package com.silaeva.coursefinder.domain.interactor

import com.silaeva.coursefinder.domain.domain_model.AuthUserModel

interface AuthInteractor {

    suspend fun authByEmail(email: String, password: String)

    suspend fun recoveryByEmail(email: String)

    suspend fun recoveryCode(code: Int)

    suspend fun authNewUser(authUser: AuthUserModel): AuthUserModel?
}