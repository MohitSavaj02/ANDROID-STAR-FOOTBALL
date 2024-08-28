package com.example.baseproject.ui.channel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseproject.data.ChannelModel
import com.example.baseproject.databinding.ItemChannelBinding
import com.example.baseproject.utils.load

class ChannelAdaptor : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var dataList: ArrayList<ChannelModel.Data> = ArrayList()

    class ChannelHolder(var binding: ItemChannelBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemChannelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChannelHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataList[position]
        if (holder is ChannelHolder) {
            holder.apply {
                binding.txtCountry.text = item.country
                binding.txtChannelName.text = item.channel
                binding.imgLogo.load("file:///android_asset/channel_icons/${item.logo}")
            }
        }
    }

    fun setDataList(list: ArrayList<ChannelModel.Data>) {
        dataList = list
    }
}