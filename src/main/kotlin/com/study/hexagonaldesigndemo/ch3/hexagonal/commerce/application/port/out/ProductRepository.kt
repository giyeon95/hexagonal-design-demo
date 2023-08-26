package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.out

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.product.Product
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.product.ProductStatus

interface ProductRepository {
    fun findAll(): List<Product>
    fun findAllByStatus(status: ProductStatus): List<Product>
    fun findByIdOrNull(id: Long): Product?
}
