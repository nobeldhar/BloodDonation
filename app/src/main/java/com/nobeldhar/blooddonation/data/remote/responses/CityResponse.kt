package com.nobeldhar.blooddonation.data.remote.responses

import com.nobeldhar.blooddonation.data.local.entities.City
import com.google.gson.annotations.SerializedName

data class CityResponse (
        @SerializedName("code")
        val code: Int,
        @SerializedName("data")
        val `data`: List<City>,
        @SerializedName("message")
        val messages: List<String>,
        @SerializedName("status")
        val status: Boolean
){
}