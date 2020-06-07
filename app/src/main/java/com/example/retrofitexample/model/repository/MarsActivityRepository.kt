package com.example.retrofitexample.model.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.retrofitexample.model.api.MarsServiceClient
import com.example.retrofitexample.model.vo.MarsDataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarsActivityRepository(val application: Application) {
    val showProgress = MutableLiveData<Boolean>()
    val marsData = MutableLiveData<List<MarsDataItem>>()

    fun getMarsData() {
        showProgress.value = true

        val retrofitService = MarsServiceClient.getClient()
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




            }

        })

    }

}