package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.service

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.exception.BaseCustomException
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.exception.OrderNotFoundException
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.exception.model.ErrorType
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.OrderCancelUseCase
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model.OrderCancelCommand
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.out.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderCancelService(
    private val orderRepository: OrderRepository,
) : OrderCancelUseCase {
    override fun cancel(command: OrderCancelCommand) {
        val order = orderRepository.findByIdOrNull(command.orderId) ?: throw OrderNotFoundException("id = ${command.orderId}")
        require(order.customerId == command.customer.id) { "order customer id is different" }

        val cancelable = order.isCancelable()
        if (!cancelable) {
            throw BaseCustomException(ErrorType.ORDER_CANNOT_CANCEL)
        }

        val updatedOrder = order.updateCancel()
        orderRepository.update(updatedOrder)
    }
}
