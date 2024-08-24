package com.example.baseproject.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class FixturesResponse(
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
        @SerializedName("fixture")
        var fixture: Fixture? = null,
        @SerializedName("goals")
        var goals: Goals? = null,
        @SerializedName("league")
        var league: League? = null,
        @SerializedName("score")
        var score: Score? = null,
        @SerializedName("teams")
        var teams: Teams? = null,
        var isTitle: Boolean = false
    ) : Parcelable {
        @Parcelize
        data class Fixture(
            @SerializedName("date")
            var date: String? = null,
            @SerializedName("id")
            var id: Int? = null,
            @SerializedName("periods")
            var periods: Periods? = null,
            @SerializedName("referee")
            var referee: String? = null,
            @SerializedName("status")
            var status: Status? = null,
            @SerializedName("timestamp")
            var timestamp: Int? = null,
            @SerializedName("timezone")
            var timezone: String? = null,
            @SerializedName("venue")
            var venue: Venue? = null
        ) : Parcelable {
            @Parcelize
            data class Periods(
                @SerializedName("first")
                var first: Int? = null,
                @SerializedName("second")
                var second: Int? = null
            ) : Parcelable

            @Parcelize
            data class Status(
                @SerializedName("elapsed")
                var elapsed: Int? = null,
                @SerializedName("long")
                var long: String? = null,
                @SerializedName("short")
                var short: String? = null
            ) : Parcelable

            @Parcelize
            data class Venue(
                @SerializedName("city")
                var city: String? = null,
                @SerializedName("id")
                var id: Int? = null,
                @SerializedName("name")
                var name: String? = null
            ) : Parcelable
        }

        @Parcelize
        data class Goals(
            @SerializedName("away")
            var away: Int? = null,
            @SerializedName("home")
            var home: Int? = null
        ) : Parcelable

        @Parcelize
        data class League(
            @SerializedName("country")
            var country: String? = null,
            @SerializedName("flag")
            var flag: String? = null,
            @SerializedName("id")
            var id: Int? = null,
            @SerializedName("logo")
            var logo: String? = null,
            @SerializedName("name")
            var name: String? = null,
            @SerializedName("round")
            var round: String? = null,
            @SerializedName("season")
            var season: Int? = null
        ) : Parcelable

        @Parcelize
        data class Score(
            @SerializedName("extratime")
            var extratime: Extratime? = null,
            @SerializedName("fulltime")
            var fulltime: Fulltime? = null,
            @SerializedName("halftime")
            var halftime: Halftime? = null,
            @SerializedName("penalty")
            var penalty: Penalty? = null
        ) : Parcelable {
            @Parcelize
            data class Extratime(
                @SerializedName("away")
                var away: Int? = null,
                @SerializedName("home")
                var home: Int? = null
            ) : Parcelable

            @Parcelize
            data class Fulltime(
                @SerializedName("away")
                var away: Int? = null,
                @SerializedName("home")
                var home: Int? = null
            ) : Parcelable

            @Parcelize
            data class Halftime(
                @SerializedName("away")
                var away: Int? = null,
                @SerializedName("home")
                var home: Int? = null
            ) : Parcelable

            @Parcelize
            data class Penalty(
                @SerializedName("away")
                var away: Int? = null,
                @SerializedName("home")
                var home: Int? = null
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
                var name: String? = null,
                @SerializedName("winner")
                var winner: Boolean? = null
            ) : Parcelable

            @Parcelize
            data class Home(
                @SerializedName("id")
                var id: Int? = null,
                @SerializedName("logo")
                var logo: String? = null,
                @SerializedName("name")
                var name: String? = null,
                @SerializedName("winner")
                var winner: Boolean? = null
            ) : Parcelable
        }
    }
}