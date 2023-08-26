package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.adapter.out.persistence

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.out.OrderRepository
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.order.Order
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.order.OrderItem
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.order.OrderStatus
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
class OrderRepositoryImpl : OrderRepository {
    override fun findAllByCustomerId(customerId: Long): List<Order> {
        return mockOrders.filter { it.customerId == customerId }
            .toList()
    }

    override fun findByIdOrNull(id: Long): Order? {
        return mockOrders.find { it.id == id }
    }

    companion object {
        private val mockOrders: List<Order> = listOf(
            Order(
                id = 1L,
                customerId = 1L,
                items = listOf(
                    OrderItem(
                        id = 1L,
                        productId = 1L,
                        productName = "상품명 1",
                        quantity = 3,
                        price = BigDecimal.valueOf(1000)
                    ),
                    OrderItem(
                        id = 2L,
                        productId = 2L,
                        productName = "상품명 2",
                        quantity = 1,
                        price = BigDecimal.valueOf(200)
                    ),
                ),
                status = OrderStatus.CANCELLED
            ),
            Order(
                id = 2L,
                customerId = 2L,
                items = listOf(
                    OrderItem(
                        id = 3L,
                        productId = 1L,
                        productName = "상품1 이름 스냅샷",
                        quantity = 2,
                        price = BigDecimal.valueOf(1000)
                    ),
                    OrderItem(
                        id = 4L,
                        productId = 2L,
                        productName = "상품2 이름 스냅샷",
                        quantity = 3,
                        price = BigDecimal.valueOf(100)
                    ),
                ),
                status = OrderStatus.DELIVERED
            ),

            Order(
                id = 3L,
                customerId = 1L,
                items = listOf(
                    OrderItem(
                        id = 5L,
                        productId = 1L,
                        productName = "상품1 이름 스냅샷",
                        quantity = 3,
                        price = BigDecimal.valueOf(1000)
                    ),
                    OrderItem(
                        id = 6L,
                        productId = 2L,
                        productName = "상품2 이름 스냅샷",
                        quantity = 1,
                        price = BigDecimal.valueOf(200)
                    ),
                ),
                status = OrderStatus.COMPLETED
            ),
        )
    }
}
