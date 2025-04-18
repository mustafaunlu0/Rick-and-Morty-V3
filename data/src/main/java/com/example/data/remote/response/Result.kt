package com.example.composetestapplication.data.remote.response

data class Result(
    val info: Info,
    val results: List<CharacterResponse>
)