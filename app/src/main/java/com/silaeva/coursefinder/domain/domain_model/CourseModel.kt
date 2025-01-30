package com.silaeva.coursefinder.domain.domain_model

data class CourseModel(
    val id: Long,
    val name: String,
    val owner: String = "",
    val summary: String,
    val review: String = "",
    val date: String,
    val price: String,
    val imageUrl: String,
    val isSaved: Boolean
)
