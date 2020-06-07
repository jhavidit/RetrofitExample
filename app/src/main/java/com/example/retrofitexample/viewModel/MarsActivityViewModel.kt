package com.example.retrofitexample.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.retrofitexample.model.repository.MarsActivityRepository
import com.example.retrofitexample.model.vo.MarsDataItem

class MarsActivityViewModel(application: Application) : AndroidViewModel(application) {
    val showProgress: LiveData<Boolean>
    val marsData: LiveData<List<MarsDataItem>>
    private val repository = MarsActivityRepository(application)

    init {
        this.showProgress = repository.showProgress
        this.marsData = repository.marsData
    }

        fun getMarsData() {
            repository.getMarsData()
        }
    }