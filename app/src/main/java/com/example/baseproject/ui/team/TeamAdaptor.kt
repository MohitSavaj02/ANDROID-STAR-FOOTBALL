package com.example.baseproject.ui.team

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseproject.data.TeamResponse
import com.example.baseproject.databinding.ItemTeamsBinding
import com.example.baseproject.utils.load

class TeamAdaptor : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var dataList: ArrayList<TeamResponse.Response> = ArrayList()
    private var listener: TeamListener? = null

    class TeamHolder(var binding: ItemTeamsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemTeamsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataList[position]
        if (holder is TeamHolder) {
            holder.apply {
                binding.txtteamName.text = item.team?.name
                binding.imgLogo.load(item.team?.logo)
                itemView.setOnClickListener {
                    listener?.onItemClick(item)
                }
            }
        }
    }

    fun setListener(listener: TeamListener) {
        this.listener = listener
    }

    fun setDataList(list: ArrayList<TeamResponse.Response>) {
        dataList = list
    }

    interface TeamListener {
        fun onItemClick(item: TeamResponse.Response)
    }
}