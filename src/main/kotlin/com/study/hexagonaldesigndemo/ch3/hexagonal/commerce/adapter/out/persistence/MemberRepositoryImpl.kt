package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.adapter.out.persistence

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.out.MemberRepository
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.user.Member
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Repository

@Repository
class MemberRepositoryImpl(
    private val passwordEncoder: PasswordEncoder,
) : MemberRepository {
    override fun findByIdOrNull(id: Long): Member? {
        return mockMembers.find { it.id == id }
    }

    override fun findByEmail(email: String): Member? {
        return mockMembers.find { it.email == email }?.apply {
            this.password = passwordEncoder.encode(password)
        }
    }

    companion object {
        private val mockMembers: List<Member> = listOf(
            Member(
                id = 1L,
                name = "kiyeon",
                email = "giyeon15@gmail.com",
                password = "1q2w3e4r"
            ),

            Member(
                id = 2L,
                name = "user2",
                email = "mockuser@gmail.com",
                password = "12313"
            ),
        )
    }

}
