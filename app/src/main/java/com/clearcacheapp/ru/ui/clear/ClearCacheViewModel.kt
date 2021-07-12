package com.clearcacheapp.ru.ui.clear

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.clearcacheapp.ru.data.AppsDataSource
import com.clearcacheapp.ru.models.AppModel
import com.heliostech.realoptimizer.core.ui.BaseViewModel

class ClearCacheViewModel(private val appsDataSource: AppsDataSource): BaseViewModel() {

    private val _appList = MutableLiveData<Boolean>()

    val appList: LiveData<ArrayList<AppModel>> = _appList.switchMap {
        return@switchMap liveData {
            val value = appsDataSource.getApps()
            emit(value)
        }
    }

    fun getApps() {
        _appList.postValue(true)
    }
}