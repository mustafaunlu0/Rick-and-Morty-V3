package com.example.composetestapplication.util

inline fun <T> callSafeApi(block : () -> Resource<T>) : Resource<T> =
    try {
        block()
    }catch (e : Exception){
        Resource.Error(e)
    }
