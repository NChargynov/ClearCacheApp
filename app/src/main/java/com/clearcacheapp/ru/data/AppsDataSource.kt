package com.clearcacheapp.ru.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppsDataSource(private val infoApps: InfoApps) {

    suspend fun getApps() = withContext(Dispatchers.IO) {
        return@withContext infoApps.getApps()
    }
}