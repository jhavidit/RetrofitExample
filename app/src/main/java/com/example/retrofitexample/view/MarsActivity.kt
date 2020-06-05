package com.example.retrofitexample.view


import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitexample.R
import com.example.retrofitexample.adapter.MarsDataAdapter
import com.example.retrofitexample.viewModel.MarsActivityViewModel
import kotlinx.android.synthetic.main.activity_mars.*


class MarsActivity : AppCompatActivity() {
    private lateinit var viewModel: MarsActivityViewModel
    private lateinit var adapter: MarsDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mars)

        viewModel = ViewModelProvider(this).get(MarsActivityViewModel::class.java)

        if (viewModel.marsData.value == null)
            viewModel.getMarsData()


        adapter = MarsDataAdapter(this)
        recyclerView.adapter = adapter


        viewModel.showProgress.observe(this, Observer {
            if (it)
                progressBar.visibility = VISIBLE
            else
                progressBar.visibility = GONE

        })

        viewModel.marsData.observe(this, Observer {
            adapter.setMarsData(it)

        })


    }

}