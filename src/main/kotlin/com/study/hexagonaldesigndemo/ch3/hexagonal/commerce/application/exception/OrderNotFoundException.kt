package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.exception

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.exception.model.ErrorType

class OrderNotFoundException(
    detailMessage: String
) : BaseCustomException(ErrorType.ORDER_NOT_FOUND, detailMessage)
