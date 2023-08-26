package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.adapter.`in`.web.product

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.adapter.`in`.web.product.model.ProductDetailRes
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.adapter.`in`.web.product.model.ProductRes
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.adapter.`in`.web.product.model.ProductsRes
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.GetProductQuery
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.product.ProductStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/products")
class ProductController(
    private val productQuery: GetProductQuery
) {
    @GetMapping
    fun getProducts(
        @RequestParam("status", required = false) status: ProductStatus?,
    ): ProductsRes {
        val response = status?.let { productQuery.getFilteredProducts(it) } ?: productQuery.getAllProducts()

        return ProductsRes(
            products = response.map {
                ProductRes(
                    id = it.id,
                    name = it.name,
                    price = it.price.toPlainString(),
                    status = it.status,
                    quantity = it.quantity,
                )
            }.toList()
        )
    }

    @GetMapping("/{id}")
    fun getProduct(
        @PathVariable("id") id: Long
    ): ProductRes {
        val product = productQuery.getProduct(id)

        return ProductRes(
            id = product.id,
            name = product.name,
            price = product.price.toPlainString(),
            status = product.status,
            quantity = product.quantity,
            detail = ProductDetailRes(
                product.description
            )
        )
    }
}
