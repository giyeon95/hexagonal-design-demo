package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.order

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.order.OrderStatus.*

data class Order(
    var id: Long? = null,
    val customerId: Long,
    var items: MutableList<OrderItem>,
    var status: OrderStatus
) {
    fun isCancelable(): Boolean {
        return when (status) {
            INIT -> true
            DELIVERED, CANCELLED, COMPLETED -> false
        }
    }

    fun updateCancel(): Order {
        require(isCancelable()) { "order ${status} is not cancelable" }
        return this.apply {
            this.status = CANCELLED
        }
    }
}
