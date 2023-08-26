package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.exception

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.exception.model.ErrorType

open class BaseCustomException(
    private val errorType: ErrorType,
    private val detailMessage: String?,
) : RuntimeException() {
    constructor(errorType: ErrorType) : this(errorType, null)

    val code: Int
        get() = errorType.code
    override val message: String
        get() {
            return when {
                detailMessage != null -> {
                    """${errorType.message}(${detailMessage})"""
                }

                else -> errorType.message
            }
        }
}
