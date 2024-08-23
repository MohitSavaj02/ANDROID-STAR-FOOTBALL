package com.example.baseproject.ui.main

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.baseproject.base.BaseActivity
import com.example.baseproject.data.HomeOptions
import com.example.baseproject.databinding.ActivityMainBinding
import com.example.baseproject.utils.ListUtils
import com.example.baseproject.viewmodel.APIViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@AndroidEntryPoint
class MainActivity : BaseActivity(), View.OnClickListener, HomeAdaptor.HomeListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptor: HomeAdaptor
    private val viewModel: APIViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        setClicks()
    }

    private fun setClicks() {

    }

    private fun initViews() {
        adaptor = HomeAdaptor()
        adaptor.setDataList(ListUtils.getHomeOption())
        adaptor.setListener(this)
        binding.rvOptions.adapter = adaptor
    }

    override fun onClick(v: View?) {
        when (v) {

        }
    }

    override fun onItemClick(item: HomeOptions) {

    }
}