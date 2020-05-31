package com.example.retrofitexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitexample.model.MarsDataItem
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val callApi = UserAPI.retrofitService.getMarsData()
        callApi.enqueue(object : Callback<List<MarsDataItem>> {
            override fun onFailure(call: Call<List<MarsDataItem>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<MarsDataItem>>,
                response: Response<List<MarsDataItem>>
            ) {
                val marsDataList = response.body()


                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                val marsDataAdapter = MarsDataAdapter(this@MainActivity, marsDataList!!)
                recyclerView.adapter = marsDataAdapter


            }

        })

    }

}