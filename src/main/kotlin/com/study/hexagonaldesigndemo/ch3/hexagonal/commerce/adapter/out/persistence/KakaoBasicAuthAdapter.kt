package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.adapter.out.persistence

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.out.OAuthKakaoStatePort
import org.springframework.stereotype.Component

@Component
class KakaoBasicAuthAdapter : OAuthKakaoStatePort {
    override fun authenticate(code: String): Boolean {
        return true
    }
}
