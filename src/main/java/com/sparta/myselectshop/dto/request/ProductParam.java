package com.sparta.myselectshop.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductParam {

    private String title;

    // 관심상품 썸네일 image URL
    private String image;

    // 관심상품 구매링크 URL
    private String link;

    // 관심상품의 최저가
    private int lprice;

}