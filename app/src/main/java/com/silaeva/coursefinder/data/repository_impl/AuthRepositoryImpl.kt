package com.silaeva.coursefinder.data.repository_impl

import com.silaeva.coursefinder.data.data_model.AuthUser
import com.silaeva.coursefinder.data.retrofit_api.AuthApi
import com.silaeva.coursefinder.data.retrofite_client.RetrofitClient
import com.silaeva.coursefinder.domain.domain_model.AuthUserModel
import com.silaeva.coursefinder.domain.repositories.AuthRepository

class AuthRepositoryImpl(private val retrofitClient: RetrofitClient): AuthRepository {

    private val api: AuthApi = retrofitClient.retrofit.create(AuthApi::class.java)

    override suspend fun authByEmail(email: String, password: String) {
        val result = api.authByEmail(email, password)
        try {
            if (result.isSuccessful) {

            } else {

            }
        } catch (e: Exception) {

        }
    }

    override suspend fun recoveryByEmail(email: String) {
        val result = api.recoveryByEmail(email)
        try {
            if (result.isSuccessful) {

            } else {

            }
        } catch (e: Exception) {

        }
    }

    override suspend fun recoveryCode(code: Int) {
        val result = api.recoveryCode(code)
        try {
            if (result.isSuccessful) {

            } else {

            }
        } catch (e: Exception) {

        }
    }

    override suspend fun authNewUser(authUserModel: AuthUserModel): AuthUserModel? {
        val authUser = AuthUser(
            email = authUserModel.email,
            password = authUserModel.password
        )
        val result = api.authNewUser(authUser)
        var resultModel: AuthUserModel? = null
        try {
            if (result.isSuccessful) {
                resultModel = result.body()?.let {
                    AuthUserModel(
                        email = it.email,
                        password = it.password,
                    )
                }
            } else {

            }
        } catch (e: Exception) {

        }
        return resultModel
    }
}