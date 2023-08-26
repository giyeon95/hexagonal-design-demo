package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.order

import java.math.BigDecimal

data class OrderItem(
    var id: Long? = null,
    val productId: Long,
    val productName: String,
    val quantity: Int,
    val price: BigDecimal
)
