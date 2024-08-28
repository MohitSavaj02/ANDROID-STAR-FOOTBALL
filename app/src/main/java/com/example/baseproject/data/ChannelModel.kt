package com.example.baseproject.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ChannelModel(
    @SerializedName("data")
    var `data`: List<Data?>? = null
) : Parcelable {
    @Parcelize
    data class Data(
        @SerializedName("channel")
        var channel: String? = null,
        @SerializedName("country")
        var country: String? = null,
        @SerializedName("logo")
        var logo: String? = null
    ) : Parcelable
}