package com.example.swapp.model


data class People(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)