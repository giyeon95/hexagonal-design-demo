package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.user.Member

data class OrderRegisterCommand(
    val items: List<OrderItemRegisterCommand>,
    val customer: Member,
) {
    init {
        require(items.isNotEmpty()) { "items must not blank" }
    }
}

data class OrderItemRegisterCommand(
    val productId: Long,
    val quantity: Int,
) {
    init {
        require(productId > 0) { "productId must positive" }
        require(quantity > 0) { "quantity must positive" }
    }

}

