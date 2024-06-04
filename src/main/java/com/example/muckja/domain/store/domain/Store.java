package com.example.muckja.domain.store.domain;

import com.example.muckja.domain.review.domain.Review;
import com.example.muckja.global.entity.BaseIdEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;


@Getter
@NoArgsConstructor
@Entity
public class Store extends BaseIdEntity {
    @Column(length = 100, nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private BigDecimal avg;

    private String menu;

    @Column(nullable = false)
    private BigDecimal taste;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private BigDecimal kindness;

    private String site;

    @OneToMany(mappedBy = "store")
    private List<Review> review;

    @Builder
    public Store(String name, String address, BigDecimal avg, String menu, BigDecimal taste, BigDecimal amount, BigDecimal kindness, String site, List<Review> review){
        this.name = name;
        this.address = address;
        this.avg = avg;
        this.menu = menu;
        this.taste = taste;
        this.amount = amount;
        this.kindness = kindness;
        this.site = site;
        this.review = review;
    }

    public void update(BigDecimal avg, BigDecimal taste, BigDecimal amount, BigDecimal kindness){
        this.avg = avg;
        this.taste = taste;
        this.amount = amount;
        this.kindness = kindness;
    }
}
