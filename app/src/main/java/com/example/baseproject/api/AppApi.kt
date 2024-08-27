package com.example.baseproject.api

import com.example.baseproject.data.FixturesResponse
import com.example.baseproject.data.PredictionResponse
import com.example.baseproject.data.SquadResponse
import com.example.baseproject.data.TeamResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AppApi {

    @GET("fixtures")
    suspend fun getFixturesData(@Query("league") league: Int, @Query("season") season: Int = 2023): Response<FixturesResponse>

    @GET("teams")
    suspend fun getTeamData(@Query("league") league: Int, @Query("season") season: Int = 2023): Response<TeamResponse>

    @GET("predictions")
    suspend fun getPredictionScore(@Query("fixture") fixtureID: Int): Response<PredictionResponse>

    @GET("players/squads")
    suspend fun getSquadData(@Query("team") teamID: Int): Response<SquadResponse>
}