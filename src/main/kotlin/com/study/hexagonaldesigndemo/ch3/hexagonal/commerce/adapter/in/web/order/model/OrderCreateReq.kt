package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.adapter.`in`.web.order.model

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.PositiveOrZero

data class OrderCreateReq(
    @field:NotEmpty(message = "최소 한개부터 구매가 가능합니다.")
    val items: List<OrderItemCreateReq>,
    val customerId: Long, // 보통은 인증 헤더를 통해 받지만 기능 간소화를 위해 body를 통해 받음
)

data class OrderItemCreateReq(
    @field:PositiveOrZero
    val productId: Long,
    @field:Positive
    val quantity: Int,
)
