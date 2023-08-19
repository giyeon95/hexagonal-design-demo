package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.order

data class Order(
    val id: Long,
    val customerId: Long,
    val items: List<OrderItem>,
    val status: OrderStatus
)
