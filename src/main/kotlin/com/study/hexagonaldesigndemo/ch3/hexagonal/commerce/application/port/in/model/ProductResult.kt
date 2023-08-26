package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.product.Product
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.product.ProductStatus
import java.math.BigDecimal

data class ProductResult(
    val id: Long,
    val name: String,
    val price: BigDecimal,
    val status: ProductStatus,
    val quantity: Int,
    val description: String,
) {
    companion object {
        fun of(product: Product): ProductResult {
            return ProductResult(
                id = product.id,
                name = product.name,
                price = product.price,
                status = product.status,
                quantity = product.quantity,
                description = product.description
            )
        }
    }
}
