package com.example.baseproject.ui.winner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseproject.data.WinnerModel
import com.example.baseproject.databinding.ItemWinnerBinding
import com.example.baseproject.utils.load

class WinnerAdaptor : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var dataList: ArrayList<WinnerModel> = ArrayList()
    private var listener: WinnerListener? = null

    class ResultHolder(var binding: ItemWinnerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemWinnerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResultHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataList[position]
        if (holder is ResultHolder) {
            holder.apply {
                binding.txtYear.text = item.year?.toString()
                binding.txtScoreHome.text = item.winnerScore
                binding.txtScoreAway.text = item.runnerUpScore
                binding.imgHomeLogo.load(item.winnerFlag)
                binding.imgAwayLogo.load(item.runnerUpFlag)
                binding.txtTeamHome.text = item.winner
                binding.txtTeamAway.text = item.runnerUp
                itemView.setOnClickListener {
                    listener?.onItemClick(item)
                }
            }
        }
    }

    fun setListener(listener: WinnerListener) {
        this.listener = listener
    }

    fun setDataList(list: ArrayList<WinnerModel>) {
        dataList = list
    }

    interface WinnerListener {
        fun onItemClick(item: WinnerModel)
    }
}