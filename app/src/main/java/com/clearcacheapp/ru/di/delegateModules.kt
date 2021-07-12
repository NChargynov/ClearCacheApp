package com.clearcacheapp.ru.di

import com.clearcacheapp.ru.data.AppsDataSource
import com.clearcacheapp.ru.data.InfoApps
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val delegateModules : Module = module {
    single { InfoApps(androidContext()) }
    single { AppsDataSource(get()) }
}