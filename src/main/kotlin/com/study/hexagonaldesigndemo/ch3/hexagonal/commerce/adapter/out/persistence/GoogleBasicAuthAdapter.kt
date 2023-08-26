package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.adapter.out.persistence

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.out.OAuthGoogleStatePort
import org.springframework.stereotype.Component

@Component
class GoogleBasicAuthAdapter : OAuthGoogleStatePort {
    override fun authenticate(code: String): Boolean {
        return true
    }
}
