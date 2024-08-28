package com.example.baseproject.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class StandingResponse(
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
        @SerializedName("league")
        var league: League? = null
    ) : Parcelable {
        @Parcelize
        data class League(
            @SerializedName("country")
            var country: String? = null,
            @SerializedName("id")
            var id: Int? = null,
            @SerializedName("logo")
            var logo: String? = null,
            @SerializedName("name")
            var name: String? = null,
            @SerializedName("season")
            var season: Int? = null,
            @SerializedName("standings")
            var standings: List<List<Standing?>?>? = null
        ) : Parcelable {
            @Parcelize
            data class Standing(
                @SerializedName("all")
                var all: All? = null,
                @SerializedName("away")
                var away: Away? = null,
                @SerializedName("description")
                var description: String? = null,
                @SerializedName("form")
                var form: String? = null,
                @SerializedName("goalsDiff")
                var goalsDiff: Int? = null,
                @SerializedName("group")
                var group: String? = null,
                @SerializedName("home")
                var home: Home? = null,
                @SerializedName("points")
                var points: Int? = null,
                @SerializedName("rank")
                var rank: Int? = null,
                @SerializedName("status")
                var status: String? = null,
                @SerializedName("team")
                var team: Team? = null,
                @SerializedName("update")
                var update: String? = null
            ) : Parcelable {
                @Parcelize
                data class All(
                    @SerializedName("draw")
                    var draw: Int? = null,
                    @SerializedName("goals")
                    var goals: Goals? = null,
                    @SerializedName("lose")
                    var lose: Int? = null,
                    @SerializedName("played")
                    var played: Int? = null,
                    @SerializedName("win")
                    var win: Int? = null
                ) : Parcelable {
                    @Parcelize
                    data class Goals(
                        @SerializedName("against")
                        var against: Int? = null,
                        @SerializedName("for")
                        var forX: Int? = null
                    ) : Parcelable
                }

                @Parcelize
                data class Away(
                    @SerializedName("draw")
                    var draw: Int? = null,
                    @SerializedName("goals")
                    var goals: Goals? = null,
                    @SerializedName("lose")
                    var lose: Int? = null,
                    @SerializedName("played")
                    var played: Int? = null,
                    @SerializedName("win")
                    var win: Int? = null
                ) : Parcelable {
                    @Parcelize
                    data class Goals(
                        @SerializedName("against")
                        var against: Int? = null,
                        @SerializedName("for")
                        var forX: Int? = null
                    ) : Parcelable
                }

                @Parcelize
                data class Home(
                    @SerializedName("draw")
                    var draw: Int? = null,
                    @SerializedName("goals")
                    var goals: Goals? = null,
                    @SerializedName("lose")
                    var lose: Int? = null,
                    @SerializedName("played")
                    var played: Int? = null,
                    @SerializedName("win")
                    var win: Int? = null
                ) : Parcelable {
                    @Parcelize
                    data class Goals(
                        @SerializedName("against")
                        var against: Int? = null,
                        @SerializedName("for")
                        var forX: Int? = null
                    ) : Parcelable
                }

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
    }
}