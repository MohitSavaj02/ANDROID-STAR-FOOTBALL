package com.example.baseproject.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PredictionResponse(
    @SerializedName("response")
    var response: List<Response?>? = null
) : Parcelable {
    @Parcelize
    data class Response(
        @SerializedName("predictions")
        var predictions: Predictions? = null,
        @SerializedName("teams")
        var teams: Teams? = null
    ) : Parcelable {
        @Parcelize
        data class Predictions(
            @SerializedName("advice")
            var advice: String? = null,
            @SerializedName("goals")
            var goals: Goals? = null,
            @SerializedName("percent")
            var percent: Percent? = null,
            @SerializedName("win_or_draw")
            var winOrDraw: Boolean? = null,
            @SerializedName("winner")
            var winner: Winner? = null
        ) : Parcelable {
            @Parcelize
            data class Goals(
                @SerializedName("away")
                var away: String? = null,
                @SerializedName("home")
                var home: String? = null
            ) : Parcelable

            @Parcelize
            data class Percent(
                @SerializedName("away")
                var away: String? = null,
                @SerializedName("draw")
                var draw: String? = null,
                @SerializedName("home")
                var home: String? = null
            ) : Parcelable

            @Parcelize
            data class Winner(
                @SerializedName("comment")
                var comment: String? = null,
                @SerializedName("id")
                var id: Int? = null,
                @SerializedName("name")
                var name: String? = null
            ) : Parcelable
        }

        @Parcelize
        data class Teams(
            @SerializedName("away")
            var away: Away? = null,
            @SerializedName("home")
            var home: Home? = null
        ) : Parcelable {
            @Parcelize
            data class Away(
                @SerializedName("id")
                var id: Int? = null,
                @SerializedName("logo")
                var logo: String? = null,
                @SerializedName("name")
                var name: String? = null
            ) : Parcelable

            @Parcelize
            data class Home(
                @SerializedName("id")
                var id: Int? = null,
                @SerializedName("logo")
                var logo: String? = null,
                @SerializedName("name")
                var name: String? = null
            ) : Parcelable
        }
    }
}