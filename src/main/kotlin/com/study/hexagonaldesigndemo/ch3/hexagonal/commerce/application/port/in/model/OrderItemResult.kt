package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.order.OrderItem
import java.math.BigDecimal

data class OrderItemResult(
    val id: Long,
    val productId: Long,
    val productName: String,
    val quantity: Int,
    val price: BigDecimal,
) {
    companion object {
        fun of(item: OrderItem): OrderItemResult {
            return OrderItemResult(
                id = item.id!!,
                productId = item.productId,
                productName = item.productName,
                quantity = item.quantity,
                price = item.price,
            )
        }
    }
}

