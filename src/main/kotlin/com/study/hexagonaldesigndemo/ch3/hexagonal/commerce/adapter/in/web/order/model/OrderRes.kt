package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.adapter.`in`.web.order.model

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model.OrderResult
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.order.OrderStatus

data class OrderRes(
    val id: Long,
    val items: List<OrderItemRes>,
    val status: OrderStatus,
) {
    companion object {
        fun of(order: OrderResult): OrderRes {
            return OrderRes(
                id = order.id,
                status = order.status,
                items = order.items.map { item ->
                    OrderItemRes.of(item)
                }.toList()
            )
        }
    }
}


