package com.example.muckja.domain.review.domain.repository;

import com.example.muckja.domain.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findByUserId(Long userId);
}
