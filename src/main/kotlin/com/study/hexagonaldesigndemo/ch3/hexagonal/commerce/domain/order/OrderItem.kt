package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.order

import java.math.BigDecimal

data class OrderItem(
    val id: Long,
    val productId: Long,
    val quantity: Int,
    val price: BigDecimal
)
