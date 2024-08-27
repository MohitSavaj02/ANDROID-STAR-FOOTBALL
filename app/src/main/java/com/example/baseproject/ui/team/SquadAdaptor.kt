package com.example.baseproject.ui.team

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseproject.data.SquadResponse.Response.Player
import com.example.baseproject.databinding.ItemSquadBinding
import com.example.baseproject.utils.load

class SquadAdaptor : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var dataList: ArrayList<Player> = ArrayList()

    class TeamHolder(var binding: ItemSquadBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemSquadBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataList[position]
        if (holder is TeamHolder) {
            holder.apply {
                binding.txtPlayerName.text = item.name
                binding.imgPlayerImage.load(item.photo)
            }
        }
    }

    fun setDataList(list: ArrayList<Player>) {
        dataList = list
    }
}