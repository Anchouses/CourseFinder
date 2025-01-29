package com.silaeva.coursefinder.utils

import retrofit2.Response

abstract class BaseApiResponse {

    suspend fun <T> safeApiCall(api: suspend () -> Response<T>): NetworkResult<T> {
        try {
            val response = api()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return NetworkResult.Success(body)
                } ?: return errorMassage("Body is empty")
            } else {
                return errorMassage("${response.code()} ${response.message()}")
            }
        } catch (e: Exception) {
            return errorMassage(e.message.toString())
        }
    }

    private fun <T> errorMassage(e: String): NetworkResult.Error<T> =
        NetworkResult.Error(data = null, massage = "Api call failed: $e")
}