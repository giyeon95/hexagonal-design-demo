package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.order

data class Order(
    var id: Long? = null,
    val customerId: Long,
    var items: MutableList<OrderItem>,
    val status: OrderStatus
)
