package com.clearcacheapp.ru.ui.clear.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.clearcacheapp.ru.databinding.ItemAppBinding
import com.clearcacheapp.ru.models.AppModel

class AppsAdapter(private val list: ArrayList<AppModel>): RecyclerView.Adapter<AppsAdapter.AppsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppsViewHolder {
        val binding = ItemAppBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AppsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AppsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class AppsViewHolder(private val viewBinding: ItemAppBinding):
        RecyclerView.ViewHolder(viewBinding.root){
        fun bind(item: AppModel){
            viewBinding.tvTitle.text = item.name
        }
    }
}