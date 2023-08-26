package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model.OrderRegisterCommand

interface OrderRegistrationUseCase {
    fun register(command: OrderRegisterCommand)
}
