package com.example.composetestapplication.util

sealed class Resource<out T> {
    class Success<T>(val data: T? = null) : Resource<T>()
    class Error (val error : Exception) : Resource<Nothing>()
    class Loading<T>(val isLoading: Boolean = true) : Resource<T>()
}