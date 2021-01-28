package com.nobeldhar.blooddonation.data.remote.responses

import com.nobeldhar.blooddonation.data.local.entities.Upazilla
import com.google.gson.annotations.SerializedName

data class UpaZillaResponse(
        @SerializedName("code")
        val code: Int,
        @SerializedName("data")
        val `data`: List<Upazilla>,
        @SerializedName("message")
        val messages: List<String>,
        @SerializedName("status")
        val status: Boolean
) {
}