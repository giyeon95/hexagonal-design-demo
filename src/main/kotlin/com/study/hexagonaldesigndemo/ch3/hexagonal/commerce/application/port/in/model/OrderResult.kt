package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.order.Order
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.order.OrderStatus

data class OrderResult(
    val id: Long,
    val status: OrderStatus,
    val items: List<OrderItemResult>
) {
    companion object {
        fun of(order: Order): OrderResult {
            return OrderResult(
                id = order.id!!,
                status = order.status,
                items = order.items.map { item ->
                    OrderItemResult.of(item)
                }.toList()
            )
        }
    }
}
