package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model.LoginCommand
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model.LoginResult

interface UserLoginUseCase {
    fun login(loginCommand: LoginCommand): LoginResult
}
