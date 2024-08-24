package com.example.baseproject.ui.live

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseproject.data.FixturesResponse
import com.example.baseproject.databinding.ItemLiveBinding
import com.example.baseproject.databinding.ItemLiveTitleBinding
import com.example.baseproject.utils.formatDate
import com.example.baseproject.utils.load

class LiveAdaptor : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var dataList: ArrayList<FixturesResponse.Response> = ArrayList()
    private var listener: LiveListener? = null

    class LiveHolder(var binding: ItemLiveBinding) : RecyclerView.ViewHolder(binding.root)
    class LiveTitleHolder(var binding: ItemLiveTitleBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 0) {
            val binding = ItemLiveTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return LiveTitleHolder(binding)
        } else {
            val binding = ItemLiveBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return LiveHolder(binding)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = dataList[position]
        if (item.isTitle) return 0 else return 1
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataList[position]
        if (holder is LiveHolder) {
            holder.apply {
                binding.txtDate.text = item.fixture?.date?.formatDate()
                binding.txtStatus.text = item.fixture?.status?.short
                binding.imgHomeLogo.load(item.teams?.home?.logo)
                binding.imgAwayLogo.load(item.teams?.away?.logo)
                binding.txtHomeScore.text = item.goals?.home?.toString()
                binding.txtAwayScore.text = item.goals?.away?.toString()
                binding.txtTeamHome.text = item.teams?.home?.name
                binding.txtTeamAway.text = item.teams?.away?.name
                itemView.setOnClickListener {
                    listener?.onItemClick(item)
                }
            }
        } else if (holder is LiveTitleHolder) {
            holder.apply {
                binding.txtTitle.text = item.league?.round
            }
        }
    }

    fun setListener(listener: LiveListener) {
        this.listener = listener
    }

    fun setDataList(list: ArrayList<FixturesResponse.Response>) {
        dataList = list
    }

    interface LiveListener {
        fun onItemClick(item: FixturesResponse.Response)
    }
}