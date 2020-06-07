package com.example.retrofitexample.model.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object MarsServiceClient {
    const val BASE_URL = "https://mars.udacity.com/"
    fun getClient():MarsService
    {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()

        val retrofitService: MarsService by lazy {
            retrofit.create(MarsService::class.java)
        }
        return retrofitService
    }
}