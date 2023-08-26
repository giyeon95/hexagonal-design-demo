package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model

data class LoginCommand(
    val email: String,
    val password: String,
    val type: LoginType,
) {
    init {
        require(email.isNotBlank()) { "email must not be empty" }
        require(password.isNotBlank()) { "password must not be empty" }
    }
}
