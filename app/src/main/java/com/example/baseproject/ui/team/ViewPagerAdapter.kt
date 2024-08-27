package com.example.baseproject.ui.team

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.baseproject.utils.AppConstant
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
class ViewPagerAdapter(activity: FragmentActivity, private var teamid: Int) : FragmentStateAdapter(activity) {

    private val fragments: List<Fragment> = listOf(
        MatchesFragment().apply {
            arguments = Bundle().apply { putInt(AppConstant.TEAM_ID, teamid) }
        },
        SquadFragment().apply {
            arguments = Bundle().apply { putInt(AppConstant.TEAM_ID, teamid) }
        }
    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}