package com.nobeldhar.blooddonation.data.remote.responses


import com.nobeldhar.blooddonation.data.local.entities.Group
import com.google.gson.annotations.SerializedName

data class GroupResponse(
    @SerializedName("auto_image")
    val autoImage: String,
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: Group,
    @SerializedName("image")
    val image: Any,
    @SerializedName("message")
    val message: List<String>,
    @SerializedName("status")
    val status: Boolean
) {

}