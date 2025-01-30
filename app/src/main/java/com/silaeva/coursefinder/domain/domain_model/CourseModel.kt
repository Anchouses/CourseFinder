package com.silaeva.coursefinder.domain.domain_model

data class CourseModel(
    val id: Long,
    val name: String,
    val owner: Long,
    val summary: String,
    val rating: String,
    val date: String,
    val price: String,
    val imageUrl: String
)
