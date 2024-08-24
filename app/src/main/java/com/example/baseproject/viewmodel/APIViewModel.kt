package com.example.baseproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.baseproject.data.FixturesResponse
import com.example.baseproject.data.TeamResponse
import com.example.baseproject.data.resource.Resource
import com.example.baseproject.reposotory.APIRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class APIViewModel @Inject constructor(
    private val repository: APIRepository,
) : ViewModel() {

    val getFixturesDataResponse: MutableLiveData<Resource<FixturesResponse>> = MutableLiveData()
    fun getFixturesData(league: Int) {
        viewModelScope.launch {
            repository.getFixturesData(league).onEach { state ->
                getFixturesDataResponse.value = state
            }.launchIn(viewModelScope)
        }
    }
    val getTeamDataResponse: MutableLiveData<Resource<TeamResponse>> = MutableLiveData()
    fun getTeamData(league: Int) {
        viewModelScope.launch {
            repository.getTeamData(league).onEach { state ->
                getTeamDataResponse.value = state
            }.launchIn(viewModelScope)
        }
    }

}