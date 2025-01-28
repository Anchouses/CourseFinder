package com.silaeva.coursefinder.data.retrofit_api

import com.silaeva.coursefinder.data.data_model.AuthUser
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthApi {

    @GET("/auth/by-email")
    suspend fun authByEmail(@Query("email") email: String, @Query("password") password: String): Response<Void>

    @GET("/recovery/by-email")
    suspend fun recoveryByEmail(@Query("email") email: String): Response<Void>

    @GET("/recovery")
    suspend fun recoveryCode(@Query("code") code: Int): Response<Void>

    @POST("/auth/new-user")
    suspend fun authNewUser(@Body authUser: AuthUser): Response<AuthUser>
}