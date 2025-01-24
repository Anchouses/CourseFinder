package com.silaeva.coursefinder.presentation.base

import androidx.lifecycle.ViewModel
import com.silaeva.coursefinder.presentation.data_source.Direction
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

abstract class BaseViewModel: ViewModel() {

    private val _navigation = MutableSharedFlow<Direction>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    val navigation: SharedFlow<Direction> = _navigation.asSharedFlow()
}