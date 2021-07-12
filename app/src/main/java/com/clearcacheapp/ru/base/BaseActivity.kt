package com.clearcacheapp.ru.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.heliostech.realoptimizer.core.ui.BaseViewModel

abstract class BaseActivity<out VM : BaseViewModel, VB : ViewBinding>: AppCompatActivity() {

    protected abstract val viewModel: VM
    protected lateinit var viewBinding: VB

    protected abstract fun inflateViewBinding(inflater: LayoutInflater): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = inflateViewBinding(LayoutInflater.from(this))
        setContentView(viewBinding.root)
    }
}
