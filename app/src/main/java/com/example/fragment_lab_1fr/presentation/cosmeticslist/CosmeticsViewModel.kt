package com.example.fragment_lab_1fr.presentation.cosmeticslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fragment_lab_1fr.domain.cosmetics.CosmeticsUseCase
import com.example.fragment_lab_1fr.domain.cosmetics.model.Cosmetica
import com.example.fragment_lab_1fr.domain.cosmetics.model.Cosmetics
import com.example.fragment_lab_1fr.domain.weather.WeatherUseCase
import kotlinx.coroutines.launch

class CosmeticsViewModel : ViewModel() {

    private val cosmeticsUseCase = CosmeticsUseCase
    private val weatherUseCase = WeatherUseCase

    val cosmeticsListLd = MutableLiveData<List<Cosmetica>>()
    val weatherLd = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()


    init {
        getAllData()
    }
    fun getAllData() {
        viewModelScope.launch {
            isLoading.postValue(true)

            val cosmeticsList = cosmeticsUseCase.getCosmetics()
            cosmeticsListLd.postValue(cosmeticsList)

            val data = weatherUseCase.getWeather()
            weatherLd.postValue(data)

            isLoading.postValue(false)
        }
    }
    fun getCosmeticsList() {

        viewModelScope.launch { doSuspend() }
        }

    suspend fun doSuspend(){

    }
}