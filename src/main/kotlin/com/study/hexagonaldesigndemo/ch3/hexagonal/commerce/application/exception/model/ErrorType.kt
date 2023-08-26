package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.exception.model

enum class ErrorType(
    val code: Int,
    val message: String
) {
    ORDER_CANNOT_CANCEL(400101, "order cannot cancel"),

    AUTH_FAIL(401101, "Authentication fail"),

    MEMBER_NOT_FOUND(404101, "user not found"),
    PRODUCT_NOT_FOUND(404102, "product not found"),

    ORDER_NOT_FOUND(404103, "order not found"),
}
