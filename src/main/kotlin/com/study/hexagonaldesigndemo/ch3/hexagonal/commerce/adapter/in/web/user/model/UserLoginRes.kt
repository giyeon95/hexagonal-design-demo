package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.adapter.`in`.web.user.model

data class UserLoginRes(
    val id: Long,
    val name: String,
    val email: String,
    val token: String
)
