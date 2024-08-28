package com.example.baseproject.reposotory

import com.example.baseproject.api.AppApi
import com.example.baseproject.data.FixturesResponse
import com.example.baseproject.data.PredictionResponse
import com.example.baseproject.data.SquadResponse
import com.example.baseproject.data.StandingResponse
import com.example.baseproject.data.TeamResponse
import com.example.baseproject.data.error.ValidationException
import com.example.baseproject.data.resource.Resource
import com.example.baseproject.data.resource.ResponseHandler
import com.example.baseproject.utils.PrefUtils
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@ExperimentalCoroutinesApi
class APIRepository @Inject constructor(
    private val api: AppApi,
    private val responseHandler: ResponseHandler,
    private val mPrefUtils: PrefUtils,
) {
    suspend fun getFixturesData(league: Int): Flow<Resource<FixturesResponse>> = flow {
        emit(Resource.loading())
        try {
            val response = responseHandler.handleResponse(api.getFixturesData(league = league))
            emit(response)
        } catch (e: Exception) {
            emit(responseHandler.handleException(e))
        }
    }.catch {
        emit(responseHandler.handleException(ValidationException(it.message)))
    }

    suspend fun getTeamData(league: Int): Flow<Resource<TeamResponse>> = flow {
        emit(Resource.loading())
        try {
            val response = responseHandler.handleResponse(api.getTeamData(league = league))
            emit(response)
        } catch (e: Exception) {
            emit(responseHandler.handleException(e))
        }
    }.catch {
        emit(responseHandler.handleException(ValidationException(it.message)))
    }

    suspend fun getStandingData(league: Int): Flow<Resource<StandingResponse>> = flow {
        emit(Resource.loading())
        try {
            val response = responseHandler.handleResponse(api.getStandingData(league = league))
            emit(response)
        } catch (e: Exception) {
            emit(responseHandler.handleException(e))
        }
    }.catch {
        emit(responseHandler.handleException(ValidationException(it.message)))
    }

    suspend fun getPredictionScore(fixtureID: Int): Flow<Resource<PredictionResponse>> = flow {
        emit(Resource.loading())
        try {
            val response = responseHandler.handleResponse(api.getPredictionScore(fixtureID = fixtureID))
            emit(response)
        } catch (e: Exception) {
            emit(responseHandler.handleException(e))
        }
    }.catch {
        emit(responseHandler.handleException(ValidationException(it.message)))
    }

    suspend fun getSquadData(teamID: Int): Flow<Resource<SquadResponse>> = flow {
        emit(Resource.loading())
        try {
            val response = responseHandler.handleResponse(api.getSquadData(teamID = teamID))
            emit(response)
        } catch (e: Exception) {
            emit(responseHandler.handleException(e))
        }
    }.catch {
        emit(responseHandler.handleException(ValidationException(it.message)))
    }
}