package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.adapter.`in`.web

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.adapter.`in`.web.model.UserLoginReq
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.adapter.`in`.web.model.UserLoginRes
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.UserLoginUseCase
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model.LoginCommand
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class UserController(
    private val userLoginUseCase: UserLoginUseCase
) {
    @PostMapping("/login")
    fun login(
        @RequestBody req: UserLoginReq
    ): UserLoginRes {

        val member = userLoginUseCase.login(
            LoginCommand(
                email = req.email,
                password = req.password,
                type = req.type
            )
        )

        return UserLoginRes(
            id = member.id,
            name = member.name,
            email = member.email,
            token = member.token,
        )
    }
}
