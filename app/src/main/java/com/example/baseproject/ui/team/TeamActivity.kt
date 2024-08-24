package com.example.baseproject.ui.team

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.baseproject.R
import com.example.baseproject.base.BaseActivity
import com.example.baseproject.data.TeamResponse
import com.example.baseproject.data.resource.Status
import com.example.baseproject.databinding.ActivityTeamBinding
import com.example.baseproject.utils.asString
import com.example.baseproject.viewmodel.APIViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@AndroidEntryPoint
class TeamActivity : BaseActivity(), View.OnClickListener, TeamAdaptor.TeamListener {
    private lateinit var binding: ActivityTeamBinding
    private lateinit var adaptor: TeamAdaptor
    private val viewModel: APIViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        setClicks()
        setObservers()
    }

    private fun setClicks() {
        binding.imgBack.setOnClickListener(this)
    }

    private fun initViews() {
        adaptor = TeamAdaptor()
        adaptor.setListener(this)
        binding.rvData.adapter = adaptor
        viewModel.getTeamData(6)
    }

    private fun setObservers() {
        viewModel.getTeamDataResponse.observe(this) { state ->
            when (state.status) {
                Status.LOADING -> {
                    binding.viewAnimator.displayedChild = 1
                }

                Status.SUCCESS -> {
                    val data = state.data?.response?.filterNotNull()
                    if (!data.isNullOrEmpty()) {
                        adaptor.setDataList(ArrayList(data))
                        binding.viewAnimator.displayedChild = 0
                    } else {
                        binding.viewAnimator.displayedChild = 2
                        binding.txtNoData.text = R.string.no_data.asString()
                    }
                }

                Status.ERROR -> {
                    binding.viewAnimator.displayedChild = 2
                    binding.txtNoData.text = R.string.something_went_wrong.asString()
                }
            }
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.imgBack -> {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }

    override fun onItemClick(item: TeamResponse.Response) {

    }
}