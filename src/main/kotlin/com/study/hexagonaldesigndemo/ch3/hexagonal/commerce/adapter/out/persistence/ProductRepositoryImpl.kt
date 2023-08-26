package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.adapter.out.persistence

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.out.ProductRepository
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.product.Product
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.product.ProductStatus
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
class ProductRepositoryImpl : ProductRepository {
    override fun findAll(): List<Product> {
        return mockProducts
    }

    override fun findAllByStatus(status: ProductStatus): List<Product> {
        return mockProducts.filter { product ->
            product.status == status
        }.toList()
    }

    override fun findByIdOrNull(id: Long): Product? {
        return mockProducts.find { product -> product.id == id }
    }

    companion object {
        private val mockProducts: List<Product> = listOf(
            Product(
                id = 1L,
                name = "상품1",
                price = BigDecimal.valueOf(1000),
                description = "상품설명!!",
                status = ProductStatus.ON_SALE,
                quantity = 100
            ),
            Product(
                id = 2L,
                name = "상품2",
                price = BigDecimal.valueOf(500),
                description = "상품설명-판매종료",
                status = ProductStatus.END_OF_SALE,
                quantity = 0
            ),
            Product(
                id = 3L,
                name = "상품3",
                price = BigDecimal.valueOf(5000),
                description = "상품설명!!",
                status = ProductStatus.WAIT_FOR_APPROVAL,
                quantity = 3
            )
        )
    }
}
