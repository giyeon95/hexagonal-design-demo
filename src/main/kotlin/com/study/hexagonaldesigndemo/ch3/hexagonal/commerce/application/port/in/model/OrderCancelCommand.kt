package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.user.Member

data class OrderCancelCommand(
    val customer: Member,
    val orderId: Long
) {
    init {
        require(orderId > 0) { "orderId must positive number" }

    }
}
