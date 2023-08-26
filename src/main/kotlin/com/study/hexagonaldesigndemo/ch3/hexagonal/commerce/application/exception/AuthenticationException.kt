package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.exception

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.exception.model.ErrorType

class AuthenticationException(
    detailMessage: String
) : BaseCustomException(ErrorType.AUTH_FAIL, detailMessage)
