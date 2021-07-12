package com.clearcacheapp.ru.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clearcacheapp.ru.base.BaseFragment
import com.clearcacheapp.ru.databinding.HomeFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<HomeViewModel, HomeFragmentBinding>(){

    override val viewModel: HomeViewModel by viewModel()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): HomeFragmentBinding {
        return HomeFragmentBinding.inflate(inflater, container, false)
    }

    override fun bindViewBinding(view: View): HomeFragmentBinding {
        return HomeFragmentBinding.bind(view)
    }

    override fun initView() {
        super.initView()
        viewBinding.layoutClear.setOnClickListener {
            navigate(HomeFragmentDirections.actionHomeFragmentToClearCacheFragment())
        }
    }
}