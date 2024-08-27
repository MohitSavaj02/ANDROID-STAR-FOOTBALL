package com.example.baseproject.ui.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.baseproject.R
import com.example.baseproject.base.BaseFragment
import com.example.baseproject.data.resource.Status
import com.example.baseproject.databinding.FragmentSquadBinding
import com.example.baseproject.utils.AppConstant
import com.example.baseproject.utils.asString
import com.example.baseproject.viewmodel.APIViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class SquadFragment : BaseFragment() {
    lateinit var binding: FragmentSquadBinding
    private val viewModel: APIViewModel by viewModels()
    private lateinit var adaptor: SquadAdaptor
    var teamID: Int? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSquadBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        teamID = arguments?.getInt(AppConstant.TEAM_ID)
        initViews()
        setObservers()
    }

    private fun initViews() {
        adaptor = SquadAdaptor()
        binding.rvData.adapter = adaptor
        teamID?.let { viewModel.getSquadData(it) }
    }

    private fun setObservers() {
        viewModel.getSquadDataResponse.observeForever { state ->
            when (state.status) {
                Status.LOADING -> {
                    binding.viewAnimator.displayedChild = 1
                }

                Status.SUCCESS -> {
                    val data = state.data?.response?.firstOrNull()?.players?.filterNotNull()
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

}