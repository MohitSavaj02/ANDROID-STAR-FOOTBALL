package com.example.baseproject.ui.prediction

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseproject.data.FixturesResponse
import com.example.baseproject.databinding.ItemPredictionBinding
import com.example.baseproject.utils.load

class PredictionAdaptor : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var dataList: ArrayList<FixturesResponse.Response> = ArrayList()
    private var listener: PredictionListener? = null

    class PredictionHolder(var binding: ItemPredictionBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemPredictionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PredictionHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataList[position]
        if (holder is PredictionHolder) {
            holder.apply {
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

    fun setListener(listener: PredictionListener) {
        this.listener = listener
    }

    fun setDataList(list: ArrayList<FixturesResponse.Response>) {
        dataList = list
    }

    interface PredictionListener {
        fun onItemClick(item: FixturesResponse.Response)
    }
}