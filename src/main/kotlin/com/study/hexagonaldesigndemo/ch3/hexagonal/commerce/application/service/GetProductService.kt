package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.service

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.exception.ProductNotFoundException
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.GetProductQuery
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model.ProductResult
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.out.ProductRepository
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.product.ProductStatus
import org.springframework.stereotype.Service

@Service
class GetProductService(
    private val productRepository: ProductRepository
) : GetProductQuery {

    override fun getAllProducts(): List<ProductResult> {
        val products = productRepository.findAll()

        return products.map {
            ProductResult.of(it)
        }.toList()
    }

    override fun getFilteredProducts(status: ProductStatus): List<ProductResult> {
        val products = productRepository.findAllByStatus(status)

        return products.map {
            ProductResult.of(it)
        }.toList()
    }

    override fun getProduct(id: Long): ProductResult {
        val product = productRepository.findByIdOrNull(id) ?: throw ProductNotFoundException("id = $id")
        return ProductResult.of(product)
    }
}
