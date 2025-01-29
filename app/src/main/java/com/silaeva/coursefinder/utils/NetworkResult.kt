package com.silaeva.coursefinder.utils

sealed class NetworkResult<T>(
    val data: T? = null,
    val massage: String? = null
) {
    class Success<T>(data: T?): NetworkResult<T>(data)
    class Error<T>(data: T?, massage: String?): NetworkResult<T>(data, massage)
    class Loading<T>: NetworkResult<T>()
}