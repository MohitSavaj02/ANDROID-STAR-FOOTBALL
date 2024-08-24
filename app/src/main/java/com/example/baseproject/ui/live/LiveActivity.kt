package com.example.baseproject.ui.live

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.baseproject.R
import com.example.baseproject.base.BaseActivity
import com.example.baseproject.data.FixturesResponse
import com.example.baseproject.data.resource.Status
import com.example.baseproject.databinding.ActivityLiveBinding
import com.example.baseproject.utils.asString
import com.example.baseproject.viewmodel.APIViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@AndroidEntryPoint
class LiveActivity : BaseActivity(), View.OnClickListener, LiveAdaptor.LiveListener {
    private lateinit var binding: ActivityLiveBinding
    private lateinit var adaptor: LiveAdaptor
    private val viewModel: APIViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLiveBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        setClicks()
        setObservers()
    }

    private fun setClicks() {
        binding.imgBack.setOnClickListener(this)
    }

    private fun initViews() {
        adaptor = LiveAdaptor()
        adaptor.setListener(this)
        binding.rvData.adapter = adaptor
        viewModel.getFixturesData(6)
    }

    private fun setObservers() {
        viewModel.getFixturesDataResponse.observe(this) { state ->
            when (state.status) {
                Status.LOADING -> {
                    binding.viewAnimator.displayedChild = 1
                }

                Status.SUCCESS -> {
                    val data = state.data?.response?.filterNotNull()
                    if (!data.isNullOrEmpty()) {
                        val map = data.groupBy { it.league?.round }.filter { it.value.isNotEmpty() }
                        val list: ArrayList<FixturesResponse.Response> = ArrayList()
                        for (item in map) {
                            list.add(FixturesResponse.Response(league = FixturesResponse.Response.League(round = item.key), isTitle = true))
                            list.addAll(item.value)
                        }
                        adaptor.setDataList(list)
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

    override fun onItemClick(item: FixturesResponse.Response) {

    }
}