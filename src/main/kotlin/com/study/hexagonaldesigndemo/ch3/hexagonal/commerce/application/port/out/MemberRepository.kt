package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.out

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.user.Member

interface MemberRepository {
    fun findByEmail(email: String): Member
}
