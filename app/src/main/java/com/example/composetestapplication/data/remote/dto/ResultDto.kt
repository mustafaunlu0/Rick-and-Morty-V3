package com.example.composetestapplication.data.remote.dto

data class ResultDto(
    val info: InfoDto,
    val results: List<CharacterDto>
)