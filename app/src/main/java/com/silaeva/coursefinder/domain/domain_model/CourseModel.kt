package com.silaeva.coursefinder.domain.domain_model

import com.silaeva.coursefinder.data.data_model.Course

data class CourseModel(
    val id: Int,
    val name: String,
    val author: String,
    val description: String,
    val rating: String,
    val date: String,
    val price: String,
    val imageUrl: String
)

data class MetaModel(
    val page: Int,
    val hasNext: Boolean,
    val hasPrevious: Boolean
)

data class CourseResponseModel(
    val meta: MetaModel,
    val courses: List<CourseModel>
)
