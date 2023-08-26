package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.out

interface OAuthGoogleStatePort {
    fun authenticate(code: String): Boolean
}
