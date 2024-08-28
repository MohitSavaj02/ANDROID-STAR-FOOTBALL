package com.example.baseproject.ui.channel

import android.os.Bundle
import android.view.View
import com.example.baseproject.R
import com.example.baseproject.base.BaseActivity
import com.example.baseproject.databinding.ActivityCommonBinding
import com.example.baseproject.utils.ListUtils
import com.example.baseproject.utils.asString
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@AndroidEntryPoint
class ChannelActivity : BaseActivity(), View.OnClickListener {
    private lateinit var binding: ActivityCommonBinding
    private lateinit var adaptor: ChannelAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        setClicks()
    }

    private fun setClicks() {
        binding.imgBack.setOnClickListener(this)
    }

    private fun initViews() {
        binding.txtTitle.text = R.string.channel.asString()
        adaptor = ChannelAdaptor()
        binding.rvData.adapter = adaptor
        adaptor.setDataList(ListUtils.getChannelData())
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.imgBack -> {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }
}