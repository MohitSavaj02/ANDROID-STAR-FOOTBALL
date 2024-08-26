package com.example.baseproject.ui.result

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseproject.data.FixturesResponse
import com.example.baseproject.databinding.ItemResultBinding
import com.example.baseproject.utils.load

class ResultAdaptor : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var dataList: ArrayList<FixturesResponse.Response> = ArrayList()
    private var listener: ResultListener? = null

    class ResultHolder(var binding: ItemResultBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResultHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataList[position]
        if (holder is ResultHolder) {
            holder.apply {
                binding.txtScoreHome.text = item.goals?.home?.toString()
                binding.txtScoreAway.text = item.goals?.away?.toString()
                binding.imgHomeLogo.load(item.teams?.home?.logo)
                binding.imgAwayLogo.load(item.teams?.away?.logo)
                binding.txtTeamHome.text = item.teams?.home?.name
                binding.txtTeamAway.text = item.teams?.away?.name
                itemView.setOnClickListener {
                    listener?.onItemClick(item)
                }
            }
        }
    }

    fun setListener(listener: ResultListener) {
        this.listener = listener
    }

    fun setDataList(list: ArrayList<FixturesResponse.Response>) {
        dataList = list
    }

    interface ResultListener {
        fun onItemClick(item: FixturesResponse.Response)
    }
}