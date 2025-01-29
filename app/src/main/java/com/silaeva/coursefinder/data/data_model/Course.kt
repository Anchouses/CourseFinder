package com.silaeva.coursefinder.data.data_model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

data class Meta(
    val page: Int,
    val hasNext: Boolean,
    val hasPrevious: Boolean
)

data class CourseResponse(
    val meta: Meta,
    val courses: List<Course>
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
)
