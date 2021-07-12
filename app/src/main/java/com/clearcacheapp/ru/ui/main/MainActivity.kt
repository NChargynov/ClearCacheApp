package com.clearcacheapp.ru.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.clearcacheapp.ru.R
import com.clearcacheapp.ru.base.BaseActivity
import com.clearcacheapp.ru.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val viewModel: MainViewModel by viewModel()
    private var navController: NavController? = null

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavigationMenu()
    }

    private fun initNavigationMenu() {
        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.nav_host_fragment
        ) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun onBackPressed() {
        if (navController?.navigateUp() == false){
            super.onBackPressed()
        }
    }
}