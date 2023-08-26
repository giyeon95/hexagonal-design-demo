package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.adapter.`in`.web.user.model

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model.LoginType

data class UserLoginReq(
    val email: String,
    val password: String,
    val type: LoginType
)
