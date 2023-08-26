package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model.ProductResult
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.product.ProductStatus

interface GetProductQuery {

    fun getAllProducts(): List<ProductResult>

    fun getFilteredProducts(status: ProductStatus): List<ProductResult>

    fun getProduct(id: Long): ProductResult
}
