package com.example.baseproject.ui.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.baseproject.R
import com.example.baseproject.base.BaseFragment
import com.example.baseproject.data.resource.Status
import com.example.baseproject.databinding.FragmentMatchesBinding
import com.example.baseproject.utils.AppConstant
import com.example.baseproject.utils.asString
import com.example.baseproject.viewmodel.APIViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MatchesFragment : BaseFragment() {
    lateinit var binding: FragmentMatchesBinding
    var teamID: Int? = null
    lateinit var adaptor: MatchesAdaptor
    private val viewModel: APIViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMatchesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        teamID = arguments?.getInt(AppConstant.TEAM_ID)
        initViews()
        setObservers()
    }

    private fun initViews() {
        adaptor = MatchesAdaptor()
        binding.rvData.adapter = adaptor
        viewModel.getFixturesData(6)
    }

    private fun setObservers() {
        viewModel.getFixturesDataResponse.observeForever { state ->
            when (state.status) {
                Status.LOADING -> {
                    binding.viewAnimator.displayedChild = 1
                }

                Status.SUCCESS -> {
                    val data = state.data?.response?.filterNotNull()?.filter { it.teams?.home?.id == teamID || it.teams?.away?.id == teamID }
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