package com.example.composetestapplication.util

sealed class Resource<out T> {
    class Success<T>(data: T? = null) : Resource<T>()
    class Error (error : Exception) : Resource<Nothing>()
    class Loading<T>(isLoading: Boolean = true) : Resource<T>()
}