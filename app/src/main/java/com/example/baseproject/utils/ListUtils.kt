package com.example.baseproject.utils

import com.example.baseproject.R
import com.example.baseproject.data.HomeOptions

class ListUtils {
    companion object {
        fun getHomeOption(): ArrayList<HomeOptions> {
            val optionList: ArrayList<HomeOptions> = ArrayList()
            optionList.add(HomeOptions(R.drawable.home_live, AppConstant.HOME))
            optionList.add(HomeOptions(R.drawable.home_team, AppConstant.TEAM))
            optionList.add(HomeOptions(R.drawable.home_fixture, AppConstant.FIXTURE))
            optionList.add(HomeOptions(R.drawable.home_channel, AppConstant.CHANNEL))
            optionList.add(HomeOptions(R.drawable.home_news, AppConstant.NEWS))
            optionList.add(HomeOptions(R.drawable.home_standings, AppConstant.STANDINGS))
            optionList.add(HomeOptions(R.drawable.home_prediction, AppConstant.PREDICTION))
            optionList.add(HomeOptions(R.drawable.home_winner, AppConstant.WINNER))
            optionList.add(HomeOptions(R.drawable.home_result, AppConstant.RESULT))
            return optionList
        }
    }
}