package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.adapter.`in`.web.order

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.adapter.`in`.web.order.model.OrderCreateReq
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.adapter.`in`.web.order.model.OrderRes
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.adapter.`in`.web.order.model.OrdersRes
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.GetMemberQuery
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.GetOrderQuery
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.OrderRegistrationUseCase
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model.OrderItemRegisterCommand
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model.OrderRegisterCommand
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/orders")
class OrderController(
    private val memberQuery: GetMemberQuery,
    private val orderQuery: GetOrderQuery,
    private val orderRegistrationUseCase: OrderRegistrationUseCase,
) {
    @GetMapping
    fun getOrders(
        @RequestParam userId: Long
    ): OrdersRes {
        val member = memberQuery.getMember(userId)
        val orders = orderQuery.getOrders(member)

        return OrdersRes(
            orders = orders.map { order ->
                OrderRes.of(order)
            }.toList()
        )
    }

    @PostMapping
    fun registerOrder(
        @RequestBody @Valid orderCreateReq: OrderCreateReq,
    ) {
        val member = memberQuery.getMember(orderCreateReq.customerId)
        orderRegistrationUseCase.register(
            OrderRegisterCommand(
                items = orderCreateReq.items.map {
                    OrderItemRegisterCommand(
                        productId = it.productId,
                        quantity = it.quantity
                    )
                }.toList(),
                customer = member
            )
        )
    }

    @GetMapping("/{id}")
    fun getOrder(
        @PathVariable("id") id: Long,
        @RequestParam userId: Long
    ): OrderRes {
        val member = memberQuery.getMember(userId)
        val order = orderQuery.getOrder(id, member)

        return OrderRes.of(order)
    }

    @PutMapping("/{id}/cancel")
    fun cancelOrder(
        @PathVariable("id") Id: Long,
        @RequestParam userId: Long
    ) {
        val member = memberQuery.getMember(userId)

    }
}
