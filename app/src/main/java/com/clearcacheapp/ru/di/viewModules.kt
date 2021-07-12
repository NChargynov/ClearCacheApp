package com.clearcacheapp.ru.di

import com.clearcacheapp.ru.ui.clear.ClearCacheViewModel
import com.clearcacheapp.ru.ui.home.HomeViewModel
import com.clearcacheapp.ru.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModules: Module = module {
    viewModel { MainViewModel() }
    viewModel { HomeViewModel() }
    viewModel { ClearCacheViewModel(get()) }
}
