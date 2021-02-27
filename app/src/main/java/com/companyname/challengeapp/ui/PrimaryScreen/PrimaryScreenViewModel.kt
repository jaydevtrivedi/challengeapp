package com.companyname.challengeapp.ui.PrimaryScreen

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.companyname.challengeapp.data.entities.BaseJson
import com.companyname.challengeapp.data.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class PrimaryScreenViewModel @ViewModelInject constructor(val repository: Repository) : ViewModel(), LifecycleObserver {

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    var baseData: MutableLiveData<BaseJson> = MutableLiveData()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun getData(){
        viewModelScope.launch {
            baseData.value = repository.getData()
        }
    }
}