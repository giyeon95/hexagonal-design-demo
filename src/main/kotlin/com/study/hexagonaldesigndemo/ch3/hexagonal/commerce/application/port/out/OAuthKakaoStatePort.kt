package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.out

interface OAuthKakaoStatePort {

    fun authenticate(code: String): Boolean
}
