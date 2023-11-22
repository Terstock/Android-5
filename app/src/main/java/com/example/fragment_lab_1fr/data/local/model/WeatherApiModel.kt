package com.example.fragment_lab_1fr.data.local.model

import android.media.Image
import com.google.gson.annotations.SerializedName

data class WeatherApiModel (
    val lat: Float?,
    val long: Float?,
    val timezone: String?,
    val linkToImage: String?,
    @SerializedName("timezone_offset") val timezoneOffset: Long?,
    val current: CurrentApiModel?,
    val hourly: List<HourlyApiModel>?,
    val daily: List<DailyApiModel>?,
)