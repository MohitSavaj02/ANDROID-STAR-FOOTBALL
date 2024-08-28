package com.example.baseproject.ui.standing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseproject.data.StandingResponse
import com.example.baseproject.databinding.ItemStandingBinding

class StandingAdaptor : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var dataMap: Map<String?, List<StandingResponse.Response.League.Standing>> = HashMap()
    private var keyList: ArrayList<String?> = ArrayList()

    class StandingHolder(var binding: ItemStandingBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemStandingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StandingHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataMap.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val key = keyList[position]
        val item = dataMap[key]
        if (holder is StandingHolder) {
            holder.apply {
                val adaptor = SubStandingAdaptor()
                adaptor.setDataList(ArrayList(item ?: ArrayList()))
                binding.rvData.adapter = adaptor
                binding.txtGroupName.text = key
            }
        }
    }

    fun setDataList(map: Map<String?, List<StandingResponse.Response.League.Standing>>) {
        dataMap = map
        keyList = ArrayList(map.keys)
    }
}