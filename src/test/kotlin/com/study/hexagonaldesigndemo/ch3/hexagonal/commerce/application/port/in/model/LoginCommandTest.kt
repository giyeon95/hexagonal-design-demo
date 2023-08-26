package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource

class LoginCommandTest {

    @ParameterizedTest
    @EmptySource
    fun `email은 공백일 수 없다`(email: String) {
        // given

        // when, then
        assertThrows<RuntimeException> {
            LoginCommand(
                email = email,
                password = "abc",
                type = LoginType.BASIC
            )
        }
    }

    @ParameterizedTest
    @EmptySource
    fun `password는 공백일 수 없다`(password: String) {
        // given

        // when, then
        assertThrows<RuntimeException> {
            LoginCommand(
                email = "abc",
                password = password,
                type = LoginType.BASIC
            )
        }

    }
}
