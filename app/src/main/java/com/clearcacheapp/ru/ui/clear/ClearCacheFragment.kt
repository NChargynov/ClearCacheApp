package com.clearcacheapp.ru.ui.clear

import android.content.ComponentCallbacks2
import android.os.Bundle
import android.os.Process.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.clearcacheapp.ru.base.BaseFragment
import com.clearcacheapp.ru.databinding.ClearCacheFragmentBinding
import com.clearcacheapp.ru.models.AppModel
import com.clearcacheapp.ru.ui.clear.adapter.AppsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class ClearCacheFragment : BaseFragment<ClearCacheViewModel, ClearCacheFragmentBinding>(), ComponentCallbacks2 {

    override val viewModel: ClearCacheViewModel by viewModel()
    private val list: ArrayList<AppModel> = arrayListOf()
    private val adapter = AppsAdapter(list)

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ClearCacheFragmentBinding {
        return ClearCacheFragmentBinding.inflate(inflater, container, false)
    }

    override fun bindViewBinding(view: View): ClearCacheFragmentBinding {
        return ClearCacheFragmentBinding.bind(view)
    }

    override fun initView() {
        super.initView()
        viewModel.getApps()
        createRecycler()
    }

    override fun initViewModels() {
        super.initViewModels()
        viewModel.appList.observe(viewLifecycleOwner,{
            getApps(it)
        })
    }

    private fun getApps(items: ArrayList<AppModel>) {
        list.clear()
        list.addAll(items)
        adapter.notifyDataSetChanged()
        viewBinding.progressBar.visibility = View.GONE
    }

    private fun createRecycler() {
        viewBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@ClearCacheFragment.adapter
        }
    }

    override fun initListeners() {
        super.initListeners()
        viewBinding.icBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        viewBinding.btnClear.setOnClickListener {
            System.runFinalization()
            Runtime.getRuntime().gc()
            System.gc()
        }
    }

    override fun onTrimMemory(level: Int) {
    }
}