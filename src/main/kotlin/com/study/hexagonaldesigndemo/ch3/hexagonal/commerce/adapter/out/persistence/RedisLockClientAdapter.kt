package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.adapter.out.persistence

import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.out.RedisLockClient
import org.springframework.stereotype.Component

@Component
class RedisLockClientAdapter : RedisLockClient {
    override fun lockAll(ids: List<Long>): Boolean {
        // 상품별로 모두 별개의 락을 겁니다.
        return true
    }

    override fun unlockAll(ids: List<Long>): Boolean {
        // 상품별로 모두 별개의 락을 해지합니다.
        return true
    }
}
