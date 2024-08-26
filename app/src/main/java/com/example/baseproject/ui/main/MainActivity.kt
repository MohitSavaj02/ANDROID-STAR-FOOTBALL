package com.example.baseproject.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.example.baseproject.R
import com.example.baseproject.base.BaseActivity
import com.example.baseproject.data.HomeOptions
import com.example.baseproject.databinding.ActivityCommonBinding
import com.example.baseproject.ui.live.LiveActivity
import com.example.baseproject.ui.prediction.PredictionActivity
import com.example.baseproject.ui.result.ResultActivity
import com.example.baseproject.ui.schedule.ScheduleActivity
import com.example.baseproject.ui.team.TeamActivity
import com.example.baseproject.ui.winner.WinnerActivity
import com.example.baseproject.utils.AppConstant
import com.example.baseproject.utils.ListUtils
import com.example.baseproject.utils.asString
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@AndroidEntryPoint
class MainActivity : BaseActivity(), HomeAdaptor.HomeListener {
    private lateinit var binding: ActivityCommonBinding
    private lateinit var adaptor: HomeAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        adaptor = HomeAdaptor()
        adaptor.setDataList(ListUtils.getHomeOption())
        adaptor.setListener(this)
        binding.rvData.layoutManager = GridLayoutManager(this, 2)
        binding.rvData.adapter = adaptor
        binding.imgBack.isVisible = false
        binding.txtTitle.text = R.string.app_name.asString()
    }


    override fun onItemClick(item: HomeOptions) {
        when (item.title) {
            AppConstant.LIVE -> {
                startActivity(Intent(this, LiveActivity::class.java))
            }

            AppConstant.TEAM -> {
                startActivity(Intent(this, TeamActivity::class.java))
            }

            AppConstant.PREDICTION -> {
                startActivity(Intent(this, PredictionActivity::class.java))
            }

            AppConstant.RESULT -> {
                startActivity(Intent(this, ResultActivity::class.java))
            }

            AppConstant.FIXTURE -> {
                startActivity(Intent(this, ScheduleActivity::class.java))
            }

            AppConstant.WINNER -> {
                startActivity(Intent(this, WinnerActivity::class.java))
            }
        }
    }
}