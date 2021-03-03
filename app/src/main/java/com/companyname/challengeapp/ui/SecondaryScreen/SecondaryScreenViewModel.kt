package com.companyname.challengeapp.ui.SecondaryScreen

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.companyname.challengeapp.data.repository.Repository
import com.companyname.challengeapp.utils.MenuFilter
import com.companyname.challengeapp.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class SecondaryScreenViewModel @ViewModelInject constructor(val repository: Repository) :
    ViewModel(), LifecycleObserver {

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    var baseData: MutableLiveData<Resource> = MutableLiveData()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun getData(id: String) {
        viewModelScope.launch {
            baseData.value = repository.getMovieData(getProviderName(id), id)
        }
    }

    fun getProviderName(id: String): String =
        if (id.startsWith("cw")) {
            MenuFilter.CINEMA_WORLD.value
        } else {
            MenuFilter.FILM_WORLD.value
        }
}