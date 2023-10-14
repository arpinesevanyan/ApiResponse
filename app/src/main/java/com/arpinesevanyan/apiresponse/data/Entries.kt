package com.arpinesevanyan.apiresponse.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Entries(
    @SerializedName("count")
    val count: Int,
    @SerializedName("entries")
    val entries: List<Entry>
) : Serializable