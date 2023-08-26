package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model.OrderCancelCommand

interface OrderCancelUseCase {
    fun cancel(command: OrderCancelCommand)
}
