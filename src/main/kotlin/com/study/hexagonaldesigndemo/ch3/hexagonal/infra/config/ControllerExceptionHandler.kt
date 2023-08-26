package com.study.hexagonaldesigndemo.ch3.hexagonal.infra.config

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.exception.BaseCustomException
import com.study.hexagonaldesigndemo.ch3.hexagonal.infra.model.ErrorRes
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ControllerExceptionHandler {

    @ExceptionHandler(value = [BaseCustomException::class])
    fun handleBaseCustomException(e: BaseCustomException): ErrorRes {
        return ErrorRes(e.code, e.message)
    }

    @ExceptionHandler(value = [IllegalArgumentException::class])
    fun handleIllegalArgumentException(e: IllegalArgumentException): ErrorRes {
        return ErrorRes(400, e.message ?: "Bad Request")
    }

    @ExceptionHandler(value = [Exception::class])
    fun handleException(e: Exception): ErrorRes {
        return ErrorRes(500, e.message ?: "Internal Server Error")
    }
}
