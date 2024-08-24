package com.example.baseproject.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TeamResponse(
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
        @SerializedName("league")
        var league: String? = null,
        @SerializedName("season")
        var season: String? = null
    ) : Parcelable

    @Parcelize
    data class Response(
        @SerializedName("team")
        var team: Team? = null,
        @SerializedName("venue")
        var venue: Venue? = null
    ) : Parcelable {
        @Parcelize
        data class Team(
            @SerializedName("code")
            var code: String? = null,
            @SerializedName("country")
            var country: String? = null,
            @SerializedName("founded")
            var founded: Int? = null,
            @SerializedName("id")
            var id: Int? = null,
            @SerializedName("logo")
            var logo: String? = null,
            @SerializedName("name")
            var name: String? = null,
            @SerializedName("national")
            var national: Boolean? = null
        ) : Parcelable

        @Parcelize
        data class Venue(
            @SerializedName("address")
            var address: String? = null,
            @SerializedName("capacity")
            var capacity: Int? = null,
            @SerializedName("city")
            var city: String? = null,
            @SerializedName("id")
            var id: Int? = null,
            @SerializedName("image")
            var image: String? = null,
            @SerializedName("name")
            var name: String? = null,
            @SerializedName("surface")
            var surface: String? = null
        ) : Parcelable
    }
}