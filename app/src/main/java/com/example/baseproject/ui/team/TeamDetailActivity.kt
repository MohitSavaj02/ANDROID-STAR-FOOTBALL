package com.example.baseproject.ui.team

import android.os.Bundle
import android.view.View
import com.example.baseproject.R
import com.example.baseproject.base.BaseActivity
import com.example.baseproject.databinding.ActivityTeamDetailBinding
import com.example.baseproject.utils.AppConstant
import com.example.baseproject.utils.asString
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@AndroidEntryPoint
class TeamDetailActivity : BaseActivity(), View.OnClickListener {
    private lateinit var binding: ActivityTeamDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        setClicks()
    }

    private fun setClicks() {
        binding.imgBack.setOnClickListener(this)
    }

    private fun initViews() {
        val title = intent.getStringExtra(AppConstant.TEAM_NAME)
        val teamID = intent.getIntExtra(AppConstant.TEAM_ID, -1)
        binding.txtTitle.text = title
        printData("TEAM_ID", teamID)
        val adapter = ViewPagerAdapter(this, teamID)
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = R.string.matches.asString()
                1 -> tab.text = R.string.squad.asString()
            }
        }.attach()
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.imgBack -> {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }
}