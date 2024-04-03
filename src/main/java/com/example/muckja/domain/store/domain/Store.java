package com.example.muckja.domain.store.domain;

import com.example.muckja.domain.review.domain.Review;
import com.example.muckja.global.entity.BaseIdEntity;
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
}
