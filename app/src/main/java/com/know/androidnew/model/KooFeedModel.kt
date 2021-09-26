package com.know.androidnew.model


import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
@Keep
data class KooFeedModel(
    @SerializedName("data") val `data`: List<Data>,
) : Parcelable