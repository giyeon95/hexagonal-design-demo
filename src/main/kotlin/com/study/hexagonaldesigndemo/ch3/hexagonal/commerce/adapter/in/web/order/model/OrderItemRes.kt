package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.adapter.`in`.web.order.model

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model.OrderItemResult
import java.math.BigDecimal

data class OrderItemRes(
    val id: Long,
    val productId: Long,
    val productName: String,
    val quantity: Int,
    val price: BigDecimal,
) {
    companion object {
        fun of(item: OrderItemResult): OrderItemRes {
            return OrderItemRes(
                id = item.id,
                productId = item.productId,
                productName = item.productName,
                quantity = item.quantity,
                price = item.price
            )
        }
    }
}
