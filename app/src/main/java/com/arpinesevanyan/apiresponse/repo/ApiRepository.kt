package com.arpinesevanyan.apiresponse.repo

import com.arpinesevanyan.apiresponse.api.ApiService
import com.arpinesevanyan.apiresponse.data.Entries
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRepository {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.publicapis.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService: ApiService = retrofit.create(ApiService::class.java)

    fun getEntries(callback: (Entries?) -> Unit) {
        val call: Call<Entries> = apiService.getEntries()
        call.enqueue(object : Callback<Entries> {
            override fun onResponse(call: Call<Entries>, response: Response<Entries>) {
                if (response.isSuccessful) {
                    val apiEntry = response.body()
                    callback(apiEntry)
                } else {
                    callback(null)
                }
            }

            override fun onFailure(call: Call<Entries>, t: Throwable) {
                callback(null)
            }
        })
    }
}
