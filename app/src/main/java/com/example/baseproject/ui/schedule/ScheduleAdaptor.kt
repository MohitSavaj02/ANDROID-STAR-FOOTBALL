package com.example.baseproject.ui.schedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseproject.data.FixturesResponse
import com.example.baseproject.databinding.ItemScheduleBinding
import com.example.baseproject.utils.formatDate
import com.example.baseproject.utils.load

class ScheduleAdaptor : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var dataList: ArrayList<FixturesResponse.Response> = ArrayList()
    private var listener: ScheduleListener? = null

    class ScheduleHolder(var binding: ItemScheduleBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemScheduleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScheduleHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataList[position]
        if (holder is ScheduleHolder) {
            holder.apply {
                binding.txtDate.text = item.fixture?.date?.formatDate("MMM dd       HH:ss")
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

    fun setListener(listener: ScheduleListener) {
        this.listener = listener
    }

    fun setDataList(list: ArrayList<FixturesResponse.Response>) {
        dataList = list
    }

    interface ScheduleListener {
        fun onItemClick(item: FixturesResponse.Response)
    }
}