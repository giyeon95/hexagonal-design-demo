package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.application.port.out

interface RedisLockClient {

    fun lockAll(ids: List<Long>): Boolean

    fun unlockAll(ids: List<Long>): Boolean

}
