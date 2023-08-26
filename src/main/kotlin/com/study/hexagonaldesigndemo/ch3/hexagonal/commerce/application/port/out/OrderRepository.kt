package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.out

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.order.Order

interface OrderRepository {
    fun findAllByCustomerId(customerId: Long): List<Order>
    fun findByIdOrNull(id: Long): Order?
}
