package com.arpinesevanyan.apiresponse.api

import com.arpinesevanyan.apiresponse.data.Entries
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("entries")
    fun getEntries(): Call<Entries>
}