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
    @SerializedName("actions")
    val actions: String,
    @SerializedName("announcements")
    val announcements: String,
    @SerializedName("assistants_group")
    val assistantsGroup: String,
    @SerializedName("authors")
    val authors: String,
    @SerializedName("became_paid_at")
    val becamePaidAt: String,
    @SerializedName("became_published_at")
    val becamePublishedAt: String,
    @SerializedName("begin_date")
    val beginDate: String,
    @SerializedName("begin_date_source")
    val beginDateSource: String,
    @SerializedName("canonical_url")
    val canonicalUrl: String,
    @SerializedName("challenges_count")
    val challengesCount: Int,
    @SerializedName("commission_basic")
    val commissionBasic: String,
    @SerializedName("commission_promo")
    val commissionPromo: String,
    @SerializedName("content_details")
    val contentDetails: String,
    @SerializedName("continue_url")
    val continueUrl: String,
    @SerializedName("course_format")
    val courseFormat: String,
    @SerializedName("course_type")
    val courseType: String,
    @SerializedName("cover")
    val cover: String,
    @SerializedName("create_date")
    val createDate: String,
    @SerializedName("currency_code")
    val currencyCode: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("display_price")
    val displayPrice: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("intro")
    val intro: String,

    @SerializedName("owner")
    val owner: String,

    @SerializedName("peer_reviews_count")
    val peerReviewsCount: Int,
    @SerializedName("position")
    val position: String,
    @SerializedName("possible_currencies")
    val possibleCurrencies: String,
    @SerializedName("possible_type")
    val possibleType: String,

    @SerializedName("price")
    val price: String,


    @SerializedName("proctor_url")
    val proctorUrl: String,
    @SerializedName("progress")
    val progress: String,
    @SerializedName("quizzes_count")
    val quizzesCount: Int,
    @SerializedName("readiness")
    val readiness: String,
    @SerializedName("referral_link")
    val referralLink: String,
    @SerializedName("requirements")
    val requirements: String,
    @SerializedName("review_summary")
    val reviewSummary: String,
    @SerializedName("schedule_link")
    val scheduleLink: String,
    @SerializedName("schedule_long_link")
    val scheduleLongLink: String,
    @SerializedName("schedule_type")
    val scheduleType: String,
    @SerializedName("sections")
    val sections: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("social_providers")
    val socialProviders: String,
    @SerializedName("soft_deadline")
    val softDeadline: String,
    @SerializedName("soft_deadline_source")
    val softDeadlineSource: String,

    @SerializedName("summary")
    val summary: String,

    @SerializedName("title")
    val title: String,

)
