package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.product

import java.math.BigDecimal

data class Product(
    val id: Long,
    val name: String,
    val price: BigDecimal,
    val description: String,
    val status: ProductStatus,
    val quantity: Int,
)
