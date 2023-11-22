package com.example.fragment_lab_1fr.data.remote.model



sealed class Resultus<out T> {

        data class Success<out T>(val data: T) : Resultus<T>()

        data class Error(val code: Int, val msg: String) : Resultus<Nothing>()

        object ErrorTimeOut : Resultus<Nothing>()

        object ErrorUnknown : Resultus<Nothing>()

        object ErrorParseJson : Resultus<Nothing>()
}