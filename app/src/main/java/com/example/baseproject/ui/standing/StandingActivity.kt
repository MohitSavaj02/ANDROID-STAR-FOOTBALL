package com.example.baseproject.ui.standing

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.baseproject.R
import com.example.baseproject.base.BaseActivity
import com.example.baseproject.data.StandingResponse.Response.League.Standing
import com.example.baseproject.data.resource.Status
import com.example.baseproject.databinding.ActivityCommonBinding
import com.example.baseproject.utils.asString
import com.example.baseproject.viewmodel.APIViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@AndroidEntryPoint
class StandingActivity : BaseActivity(), View.OnClickListener {
    private lateinit var binding: ActivityCommonBinding
    private lateinit var adaptor: StandingAdaptor
    private val viewModel: APIViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        setClicks()
        setObservers()
    }

    private fun setClicks() {
        binding.imgBack.setOnClickListener(this)
    }

    private fun initViews() {
        binding.txtTitle.text = R.string.standings.asString()
        adaptor = StandingAdaptor()
        binding.rvData.adapter = adaptor
        viewModel.getStandingData(6)
    }

    private fun setObservers() {
        viewModel.getStandingDataResponse.observe(this) { state ->
            when (state.status) {
                Status.LOADING -> {
                    binding.viewAnimator.displayedChild = 1
                }

                Status.SUCCESS -> {
                    val standings = state.data?.response?.filterNotNull()?.first()?.league?.standings?.filterNotNull() ?: ArrayList()
                    val list: ArrayList<Standing> = ArrayList()
                    for (item in standings) {
                        list.addAll(item.filterNotNull())
                    }
                    val data = list.groupBy { it.group }
                    if (data.isNotEmpty()) {
                        adaptor.setDataList(data)
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
}