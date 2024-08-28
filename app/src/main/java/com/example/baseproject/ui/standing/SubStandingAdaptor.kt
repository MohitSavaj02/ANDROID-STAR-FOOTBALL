package com.example.baseproject.ui.standing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseproject.R
import com.example.baseproject.data.StandingResponse
import com.example.baseproject.databinding.ItemSubStandingBinding
import com.example.baseproject.utils.load

class SubStandingAdaptor : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var dataList: ArrayList<StandingResponse.Response.League.Standing> = ArrayList()

    class StandingHolder(var binding: ItemSubStandingBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemSubStandingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StandingHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataList[position]
        if (holder is StandingHolder) {
            holder.apply {
                binding.apply {
                    txtIndex.text = item.rank.toString()
                    imgFlag.load(item.team?.logo)
                    txtTeamName.text = item.team?.name
                    txtMatchPlayed.text = item.all?.played.toString()
                    txtWin.text = item.all?.win.toString()
                    txtDraw.text = item.all?.draw.toString()
                    txtlose.text = item.all?.lose.toString()
                    txtPoints.text = item.points.toString()
                    txtGf.text = item.all?.goals?.forX.toString()
                    txtGa.text = item.all?.goals?.against.toString()
                    txtGd.text = item.goalsDiff.toString()
                    val last5 = item.form?.toCharArray()
                    imgLast1.load(getImageResource(last5?.getOrNull(0)))
                    imgLast2.load(getImageResource(last5?.getOrNull(1)))
                    imgLast3.load(getImageResource(last5?.getOrNull(2)))
                    imgLast4.load(getImageResource(last5?.getOrNull(3)))
                    imgLast5.load(getImageResource(last5?.getOrNull(4)))
                }
            }
        }
    }

    private fun getImageResource(str: Char?): Int {
        return when (str) {
            'W' -> {
                R.drawable.ic_win_score
            }

            'D' -> {
                R.drawable.ic_draw_score
            }

            'L' -> {
                R.drawable.ic_lose_score
            }

            else -> R.drawable.ic_blank_score
        }
    }

    fun setDataList(list: ArrayList<StandingResponse.Response.League.Standing>) {
        dataList = list
    }
}