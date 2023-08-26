package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.adapter.out.persistence

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.out.MemberRepository
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.user.Member
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Repository

@Repository
class MemberRepositoryImpl(
    private val passwordEncoder: PasswordEncoder,
) : MemberRepository {

    override fun findByEmail(email: String): Member {
        return Member(
            id = 1L,
            name = "kiyeon",
            email = email,
            password = passwordEncoder.encode("1q2w3e4r")
        )
    }
}
