package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.service

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.exception.OrderNotFoundException
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.GetOrderQuery
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model.OrderResult
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.out.OrderRepository
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.user.Member
import org.springframework.stereotype.Service

@Service
class GetOrderService(
    private val orderRepository: OrderRepository,
) : GetOrderQuery {
    override fun getOrders(member: Member): List<OrderResult> {
        val orders = orderRepository.findAllByCustomerId(member.id)

        return orders.map { order ->
            OrderResult.of(order)
        }.toList()
    }

    override fun getOrder(id: Long, member: Member): OrderResult {
        val order = orderRepository.findByIdOrNull(id) ?: throw OrderNotFoundException("id = $id")
        if (order.customerId != member.id) {
            throw OrderNotFoundException("You do not have permission to view orders")
        }

        return OrderResult.of(order)
    }
}
