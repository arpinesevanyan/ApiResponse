package com.arpinesevanyan.apiresponse.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Entry(
    @SerializedName("API")
    val API: String,
    @SerializedName("Auth")
    val Auth: String,
    @SerializedName("Category")
    val Category: String,
    @SerializedName("Cors")
    val Cors: String,
    @SerializedName("Description")
    val Description: String,
    @SerializedName("HTTPS")
    val HTTPS: Boolean,
    @SerializedName("Link")
    val Link: String
) : Serializable