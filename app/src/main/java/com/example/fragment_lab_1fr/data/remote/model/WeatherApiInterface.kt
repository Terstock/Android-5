package com.example.fragment_lab_1fr.data.remote.model

import com.example.fragment_lab_1fr.data.local.model.WeatherApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface WeatherApiInterface {


    @GET("onecall")
    suspend fun getWeather(@QueryMap params: Map<String, String>): Response<WeatherApiModel>
}