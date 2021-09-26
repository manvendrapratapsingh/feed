package com.know.androidnew.model


import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
@Keep
data class Data(
    @SerializedName("body") val body: String, // Seem bank about. Success culture answer up though.
    @SerializedName("id") val id: Int, // 1454
    @SerializedName("title") val title: String, // Factor learn air maintain pay base the.
    @SerializedName("user_id") val userId: Int // 1552
) : Parcelable