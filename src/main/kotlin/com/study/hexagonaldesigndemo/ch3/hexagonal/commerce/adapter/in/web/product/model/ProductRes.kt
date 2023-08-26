package com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.adapter.`in`.web.product.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.study.hexagonaldesigndemo.ch3.hexagonal.commerce.domain.product.ProductStatus

data class ProductRes(
    val id: Long,
    val name: String,
    val price: String,
    val status: ProductStatus,
    val quantity: Int,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    /**
     * product 상세 조회가 아닌경우, 응답값에 포함되지 않습니다.
     * product 목록 조회 응답의 변경 주기가 동일할 가능성이 높아보여 응답 모델을 분리하지 않았습니다.
     */
    val detail: ProductDetailRes? = null,
)


data class ProductDetailRes(
    val description: String,
)
