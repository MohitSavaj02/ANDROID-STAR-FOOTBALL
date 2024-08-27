package com.example.baseproject.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SquadResponse(
    @SerializedName("response")
    var response: List<Response?>? = null,
    @SerializedName("results")
    var results: Int? = null
) : Parcelable {
    @Parcelize
    data class Paging(
        @SerializedName("current")
        var current: Int? = null,
        @SerializedName("total")
        var total: Int? = null
    ) : Parcelable

    @Parcelize
    data class Parameters(
        @SerializedName("team")
        var team: String? = null
    ) : Parcelable

    @Parcelize
    data class Response(
        @SerializedName("players")
        var players: List<Player?>? = null,
        @SerializedName("team")
        var team: Team? = null
    ) : Parcelable {
        @Parcelize
        data class Player(
            @SerializedName("age")
            var age: Int? = null,
            @SerializedName("id")
            var id: Int? = null,
            @SerializedName("name")
            var name: String? = null,
            @SerializedName("number")
            var number: Int? = null,
            @SerializedName("photo")
            var photo: String? = null,
            @SerializedName("position")
            var position: String? = null
        ) : Parcelable

        @Parcelize
        data class Team(
            @SerializedName("id")
            var id: Int? = null,
            @SerializedName("logo")
            var logo: String? = null,
            @SerializedName("name")
            var name: String? = null
        ) : Parcelable
    }
}