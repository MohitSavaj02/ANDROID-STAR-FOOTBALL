package com.example.baseproject.utils

import com.example.baseproject.R
import com.example.baseproject.app.StarFootballApp
import com.example.baseproject.data.ChannelModel
import com.example.baseproject.data.HomeOptions
import com.example.baseproject.data.WinnerModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader

class ListUtils {
    companion object {
        fun getHomeOption(): ArrayList<HomeOptions> {
            val optionList: ArrayList<HomeOptions> = ArrayList()
            optionList.add(HomeOptions(R.drawable.home_live, AppConstant.LIVE))
            optionList.add(HomeOptions(R.drawable.home_team, AppConstant.TEAM))
            optionList.add(HomeOptions(R.drawable.home_fixture, AppConstant.FIXTURE))
            optionList.add(HomeOptions(R.drawable.home_channel, AppConstant.CHANNEL))
//            optionList.add(HomeOptions(R.drawable.home_news, AppConstant.NEWS))
            optionList.add(HomeOptions(R.drawable.home_standings, AppConstant.STANDINGS))
            optionList.add(HomeOptions(R.drawable.home_prediction, AppConstant.PREDICTION))
            optionList.add(HomeOptions(R.drawable.home_winner, AppConstant.WINNER))
            optionList.add(HomeOptions(R.drawable.home_result, AppConstant.RESULT))
            return optionList
        }

        fun getWinnerData(): ArrayList<WinnerModel> {
            val list: ArrayList<WinnerModel> = ArrayList()
            val inputStream = StarFootballApp.getAppInstance().assets.open("winners.json")
            val listType = object : TypeToken<List<WinnerModel>>() {}.type
            list.addAll(Gson().fromJson(InputStreamReader(inputStream), listType))
            return list
        }

        fun getChannelData(): ArrayList<ChannelModel.Data> {
            val list: ArrayList<ChannelModel.Data> = ArrayList()
            val inputStream = StarFootballApp.getAppInstance().assets.open("channels_data.json")
            val data = Gson().fromJson(InputStreamReader(inputStream), ChannelModel::class.java)
            list.addAll(data.data?.filterNotNull() ?: ArrayList())
            return list
        }
    }
}