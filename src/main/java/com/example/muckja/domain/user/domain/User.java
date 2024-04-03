package com.example.muckja.domain.user.domain;


import com.example.muckja.domain.review.domain.Review;
import com.example.muckja.global.entity.BaseIdEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseIdEntity {
    @Column(length = 100, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(length = 100, nullable = false)
    private String name;

    @OneToMany(mappedBy = "user")
    private List<Review> review;
}
