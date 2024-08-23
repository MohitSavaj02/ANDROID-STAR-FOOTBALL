package com.example.baseproject.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseproject.data.HomeOptions
import com.example.baseproject.databinding.ItemProductBinding
import com.example.baseproject.utils.load

class HomeAdaptor : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var dataList: ArrayList<HomeOptions> = ArrayList()
    private var listener: HomeListener? = null

    class HomeHolder(var binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataList[position]
        if (holder is HomeHolder) {
            holder.binding.imgIcon.load(item.icon)
            holder.itemView.setOnClickListener {
                listener?.onItemClick(item)
            }
        }
    }

    fun setListener(listener: HomeListener) {
        this.listener = listener
    }

    fun setDataList(list: ArrayList<HomeOptions>) {
        dataList = list
    }

    interface HomeListener {
        fun onItemClick(item: HomeOptions)
    }
}