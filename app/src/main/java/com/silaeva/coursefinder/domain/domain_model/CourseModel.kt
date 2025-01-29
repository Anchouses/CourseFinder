package com.silaeva.coursefinder.domain.domain_model

data class CourseModel(
    val id: Long,
    val name: String,
    val owner: Long,
    val description: String,
    val rating: Long,
    val date: String,
    val price: String,
    val imageUrl: String
)
