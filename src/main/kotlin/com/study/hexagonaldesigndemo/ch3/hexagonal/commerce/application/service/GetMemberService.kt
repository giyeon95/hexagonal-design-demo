package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.service

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.exception.MemberNotFoundException
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.GetMemberQuery
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.out.MemberRepository
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.user.Member
import org.springframework.stereotype.Service

@Service
class GetMemberService(
    private val memberRepository: MemberRepository
) : GetMemberQuery {
    override fun getMember(id: Long): Member {
        return memberRepository.findByIdOrNull(id) ?: throw MemberNotFoundException("id = $id")
    }
}
