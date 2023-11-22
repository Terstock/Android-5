package com.example.fragment_lab_1fr.domain.weather

import com.example.fragment_lab_1fr.data.WeatherRepository

object WeatherUseCase {

    private val repo = WeatherRepository


    suspend fun getWeather(lat: String = "48.0", lon: String = "35.0"): String {
        val v = repo.getWeather(lat,lon)
        return v.toString()
    }
}