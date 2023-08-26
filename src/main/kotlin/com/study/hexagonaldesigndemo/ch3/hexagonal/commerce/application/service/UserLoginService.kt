package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.service

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.exception.AuthenticationException
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.UserLoginUseCase
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model.LoginCommand
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model.LoginResult
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.`in`.model.LoginType
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.out.MemberRepository
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.out.OAuthGoogleStatePort
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.out.OAuthKakaoStatePort
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.user.Member
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserLoginService(
    private val passwordEncoder: PasswordEncoder,
    private val memberRepository: MemberRepository,
    private val oAuthKakaoStatePort: OAuthKakaoStatePort,
    private val oAuthGoogleStatePort: OAuthGoogleStatePort,
) : UserLoginUseCase {
    override fun login(loginCommand: LoginCommand): LoginResult {
        val member = memberRepository.findByEmail(loginCommand.email)
        member.verifyPasswordByType(loginCommand)

        return LoginResult(member.id, member.email, member.name, "token")
    }

    private fun Member.verifyPasswordByType(
        loginCommand: LoginCommand,
    ) {
        when (loginCommand.type) {
            LoginType.BASIC -> {
                if (passwordEncoder.matches(loginCommand.password, this.password)) {
                    throw AuthenticationException("password incorrect")
                }
            }

            LoginType.KAKAO -> {
                if (!oAuthKakaoStatePort.authenticate(loginCommand.password)) {
                    throw AuthenticationException("kakao login failed")
                }

            }

            LoginType.GOOGLE -> {
                if (!oAuthGoogleStatePort.authenticate(loginCommand.password)) {
                    throw AuthenticationException("google login failed")
                }
            }
        }
    }
}
