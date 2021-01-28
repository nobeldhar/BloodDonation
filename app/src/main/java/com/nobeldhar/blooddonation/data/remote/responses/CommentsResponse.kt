package com.nobeldhar.blooddonation.data.remote.responses


import com.nobeldhar.blooddonation.data.local.entities.TimeLinePost
import com.google.gson.annotations.SerializedName

data class CommentsResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("comments")
    val comments: List<com.nobeldhar.blooddonation.data.local.entities.Comment>,
    @SerializedName("message")
    val message: List<String>,
    @SerializedName("post")
    val post: TimeLinePost,
    @SerializedName("status")
    val status: Boolean
)