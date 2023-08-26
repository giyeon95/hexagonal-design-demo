package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.service

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.exception.ProductNotFoundException
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.OrderRegistrationUseCase
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model.OrderRegisterCommand
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.out.OrderRepository
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.out.ProductRepository
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.out.RedisLockClient
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.order.Order
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.order.OrderItem
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.order.OrderStatus
import org.springframework.stereotype.Service

@Service
class OrderRegistrationService(
    private val productRepository: ProductRepository,
    private val orderRepository: OrderRepository,
    private val redisLockClient: RedisLockClient,
) : OrderRegistrationUseCase {
    override fun register(command: OrderRegisterCommand) {
        val productIds = command.items.map { it.productId }.toList()

        try {
            redisLockClient.lockAll(productIds)

            val items = command.items.map {
                // QPS 등 여러가지를 고려해야 하지만, 예제 간소화를 위한 skip
                val product = productRepository.findByIdOrNull(it.productId) ?: throw ProductNotFoundException("id = ${it.productId}")
                require(product.quantity < it.quantity) { "product 갯수가 부족합니다." }

                OrderItem(
                    productId = it.productId,
                    productName = product.name,
                    quantity = it.quantity,
                    price = product.price,
                )
            }.toMutableList()

            orderRepository.save(
                Order(
                    customerId = command.customer.id,
                    items = items,
                    status = OrderStatus.INIT
                )
            )
        } finally {
            redisLockClient.unlockAll(productIds)
        }
    }
}
