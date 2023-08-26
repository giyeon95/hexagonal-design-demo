package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model.OrderResult
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.user.Member

interface GetOrderQuery {
    fun getOrders(member: Member): List<OrderResult>

    fun getOrder(id: Long, member: Member): OrderResult

}
