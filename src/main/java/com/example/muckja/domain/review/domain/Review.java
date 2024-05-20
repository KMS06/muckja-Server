package com.example.muckja.domain.review.domain;

import com.example.muckja.domain.store.domain.Store;
import com.example.muckja.domain.user.domain.User;
import com.example.muckja.global.entity.BaseIdEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor
@Entity
public class Review extends BaseIdEntity {
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "storeId")
    private Store store;

    @Column(nullable = false)
    private Integer rating;

    private String content;

    @Column(nullable = false)
    private Integer taste;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private Integer kindness;

    @Builder
    public Review(User user, Store store, Integer rating, String content, Integer taste, Integer amount, Integer kindness ) {
        this.user = user;
        this.store = store;
        this.rating = rating;
        this.content = content;
        this.taste = taste;
        this.amount = amount;
        this.kindness = kindness;
    }
}
