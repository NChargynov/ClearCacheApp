package com.clearcacheapp.ru.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.viewbinding.ViewBinding
import com.clearcacheapp.ru.R
import com.heliostech.realoptimizer.core.ui.BaseViewModel

abstract class BaseFragment<VM: BaseViewModel, VB: ViewBinding> : Fragment() {

    protected abstract val viewModel: VM
    protected lateinit var viewBinding: VB
    private var _view: View? = null //cached view

    private var _navController: NavController? = null

    protected abstract fun inflateViewBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): VB
    protected abstract fun bindViewBinding(view: View): VB

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        if(_view == null) {
            viewBinding = inflateViewBinding(inflater, container, savedInstanceState)
            _view = viewBinding.root
        } else {
            viewBinding = bindViewBinding(_view!!)
        }
        return _view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _navController = activity?.findNavController(R.id.nav_host_fragment)

        initView()
        initListeners()
        initViewModels()
    }

    fun navigate(directions: NavDirections) {
        _navController?.navigate(directions)
    }

    open fun initView() {}
    open fun initListeners() {}
    open fun initViewModels() {}
}
