package com.clearcacheapp.ru.data
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import com.clearcacheapp.ru.models.AppModel

class InfoApps(private val context: Context) {

    fun getApps(): ArrayList<AppModel> {
        val pm: PackageManager = context.packageManager

        val packagesRun = pm.getInstalledApplications(PackageManager.GET_META_DATA)

        val apps = ArrayList<AppModel>()

        for (packageInfo in packagesRun) {
            val system = packageInfo.flags and ApplicationInfo.FLAG_SYSTEM > 0
            val stopped = packageInfo.flags and ApplicationInfo.FLAG_STOPPED > 0

            if (!stopped && !system) {
                apps.add(
                    AppModel(
                        packageInfo.packageName,
                        packageInfo.loadLabel(pm).toString(),
                        null,
                        null
                    )
                )
            }
        }
        return apps
    }
}