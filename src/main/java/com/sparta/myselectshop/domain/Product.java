package com.sparta.myselectshop.domain;

import com.sparta.myselectshop.dto.request.ProductMyPriceParam;
import com.sparta.myselectshop.dto.request.ProductParam;
import com.sparta.myselectshop.dto.response.ItemForm;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.FetchType.LAZY;

@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Setter
@Table(name = "product") // 매핑할 테이블의 이름을 지정
@NoArgsConstructor
public class Product extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private int lprice;

    @Column(nullable = false)
    private int myprice;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Product(ProductParam param, User user) {
        this.title = param.getTitle();
        this.image = param.getImage();
        this.link = param.getLink();
        this.lprice = param.getLprice();
        this.user = user;
    }

    public void update(ProductMyPriceParam param) {
        this.myprice = param.getMyPrice();
    }

    public void updateByItemForm(ItemForm form) {
        this.lprice = form.getLprice();
    }
}