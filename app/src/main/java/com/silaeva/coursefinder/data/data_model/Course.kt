package com.silaeva.coursefinder.data.data_model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

data class CourseResponse(
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("courses")
    val courses: List<Course>
)

data class ReviewResponse(
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("course-review-summaries")
    val reviews: List<CourseReview>
)

data class OwnerResponse(
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("users")
    val users: List<CourseOwner>
)

data class Meta(
    @SerializedName("page")
    val page: Int,
    @SerializedName("hasNext")
    val hasNext: Boolean,
    @SerializedName("hasPrevious")
    val hasPrevious: Boolean
)

data class CourseReview(
    @SerializedName("id")
    val id: Long,
    @SerializedName("course")
    val courseId: Long,
    @SerializedName("average")
    val average: Double
)

data class CourseOwner(
    @SerializedName("id")
    val id: Long,
    @SerializedName("full_name")
    val fullName: String? = null
)

@Keep
data class Course(
    @SerializedName("authors")
    val authors: List<Long?>,
    @SerializedName("begin_date")
    val beginDate: String? = null,
    @SerializedName("canonical_url")
    val canonicalUrl: String? = null,
    @SerializedName("cover")
    val cover: String? = null,
    @SerializedName("create_date")
    val createDate: String? = null,
    @SerializedName("currency_code")
    val currencyCode: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("id")
    val id: Long? = null,
    @SerializedName("intro")
    val intro: String? = null,
    @SerializedName("owner")
    val owner: Long? = null,
    @SerializedName("price")
    val price: String? = null,
    @SerializedName("proctor_url")
    val proctorUrl: String? = null,
    @SerializedName("referral_link")
    val referralLink: String? = null,
    @SerializedName("requirements")
    val requirements: String? = null,
    @SerializedName("review_summary")
    val reviewSummary: Long? = null,
    @SerializedName("summary")
    val summary: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("difficulty")
    val difficulty: String? = null,
)
