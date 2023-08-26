package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.exception

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.exception.model.ErrorType

class ProductNotFoundException(
    detailMessage: String
) : BaseCustomException(ErrorType.PRODUCT_NOT_FOUND, detailMessage)
