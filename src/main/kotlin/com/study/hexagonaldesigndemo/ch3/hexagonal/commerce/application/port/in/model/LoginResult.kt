package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model

data class LoginResult(
    val id: Long,
    val email: String,
    val name: String,
    val token: String,
)
