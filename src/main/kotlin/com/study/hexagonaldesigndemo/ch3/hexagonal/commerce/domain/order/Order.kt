package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.order

data class Order(
    var id: Long? = null,
    val customerId: Long,
    val items: List<OrderItem>,
    val status: OrderStatus
)
