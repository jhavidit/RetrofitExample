package com.example.retrofitexample.model.api

import com.example.retrofitexample.model.vo.MarsDataItem
import retrofit2.Call
import retrofit2.http.GET

const val BASE_URL = "https://mars.udacity.com/"


interface MarsService {
    @GET("realestate")
    fun getMarsData(): Call<List<MarsDataItem>>
}

