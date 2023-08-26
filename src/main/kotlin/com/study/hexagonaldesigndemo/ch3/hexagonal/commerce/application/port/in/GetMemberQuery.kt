package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.user.Member

interface GetMemberQuery {

    fun getMember(id: Long) : Member
}
