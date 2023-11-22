

package com.example.fragment_lab_1fr.data

import com.example.fragment_lab_1fr.data.remote.model.ApiFactory
import com.example.fragment_lab_1fr.data.local.model.WeatherApiModel
import com.example.fragment_lab_1fr.data.remote.model.Resultus
import retrofit2.Response
import java.net.SocketTimeoutException
import java.net.UnknownHostException


object WeatherRepository {

    private val api = ApiFactory.weatherApi
    private val API_KEY = "6d82c96911bb1d4c669519885b692ddb"

    suspend fun getWeather(lat: String = "33.44", lon: String = "-94.04"): WeatherApiModel?{

        val params = HashMap<String, String>()
        params.put("lat", lat)
        params.put("lot", lon)
        params.put("appid", API_KEY)
        params.put("units", "metric")
        params.put("exclude", "minutely")


        val dataFromInet = api.getWeather(params)



        if (dataFromInet.isSuccessful && dataFromInet.body()!=null){
            return dataFromInet.body()
        }else return null

        val resp = safetyCall { api.getWeather(params) }

        return when (resp){
            is Resultus.Success -> resp.data
            else -> null
        }
    }

    private suspend fun <T> safetyCall(call: suspend () -> Response<T>): Resultus<T>{
        val response: Resultus<T>
        try{
            val result = call.invoke()
            response = if (result.isSuccessful){
                Resultus.Success(result.body()!!)
            }else{
                Resultus.Error(result.code(), result.toString())
            }
            return response
        } catch (e: Exception){
            return when (e) {
                is SocketTimeoutException -> Resultus.ErrorTimeOut
                is UnknownHostException -> Resultus.ErrorUnknown

                else -> Resultus.ErrorUnknown
            }
        }
    }


}

