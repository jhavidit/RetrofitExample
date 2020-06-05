package com.example.retrofitexample.model.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.retrofitexample.model.api.BASE_URL
import com.example.retrofitexample.model.api.MarsService
import com.example.retrofitexample.model.vo.MarsDataItem
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MarsActivityRepository(val application: Application) {
    val showProgress = MutableLiveData<Boolean>()
    val marsData = MutableLiveData<List<MarsDataItem>>()

//    fun changeState() {
//        showProgress.value = !(showProgress.value != null && showProgress.value!!)
//    }

    fun getMarsData() {
        showProgress.value = true

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
        val callApi = retrofitService.getMarsData()


        callApi.enqueue(object : Callback<List<MarsDataItem>> {
            override fun onFailure(call: Call<List<MarsDataItem>>, t: Throwable) {

                showProgress.value = false
                Toast.makeText(application, "Error", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<MarsDataItem>>,
                response: Response<List<MarsDataItem>>
            ) {
                showProgress.value = false
                val marsDataList = response.body()
                marsData.value = marsDataList

                Log.d("MarsData", marsData.value.toString())


            }

        })

    }

}