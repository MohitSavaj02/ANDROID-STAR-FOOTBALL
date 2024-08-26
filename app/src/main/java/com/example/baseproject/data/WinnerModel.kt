package com.example.baseproject.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class WinnerModel(
    @SerializedName("note")
    var note: String? = null,
    @SerializedName("runner_up")
    var runnerUp: String? = null,
    @SerializedName("runner_up_flag")
    var runnerUpFlag: String? = null,
    @SerializedName("runner_up_score")
    var runnerUpScore: String? = null,
    @SerializedName("winner")
    var winner: String? = null,
    @SerializedName("winner_flag")
    var winnerFlag: String? = null,
    @SerializedName("winner_score")
    var winnerScore: String? = null,
    @SerializedName("year")
    var year: Int? = null
) : Parcelable