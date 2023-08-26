package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.exception.model

enum class ErrorType(
    val code: Int,
    val message: String
) {
    AUTH_FAIL(400101, "Authentication fail"),

    PRODUCT_NOT_FOUND(404102, "product not found"),
}
