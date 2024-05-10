package com.example.muckja.domain.review.service;

import com.example.muckja.domain.review.domain.Review;
import com.example.muckja.domain.review.domain.repository.ReviewRepository;
import com.example.muckja.domain.review.facade.ReviewFacade;
import com.example.muckja.domain.review.presentation.dto.request.ReviewUploadRequest;
import com.example.muckja.domain.store.domain.Store;
import com.example.muckja.domain.store.domain.repository.StoreRepository;
import com.example.muckja.domain.store.exception.StoreNotFoundException;
import com.example.muckja.domain.user.domain.User;
import com.example.muckja.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReviewUploadService {
    private final UserFacade userFacade;
    private final ReviewRepository reviewRepository;
    private final StoreRepository storerepository;
    private final ReviewFacade reviewFacade;

    @Transactional
    public void execute(ReviewUploadRequest request){
        User user = userFacade.getCurrentUser();
        Store store = storerepository.findById(request.getStoreId())
                .orElseThrow(() -> StoreNotFoundException.EXCEPTION);

        reviewFacade.checkReviewExist(user.getId(), store.getId());

        reviewRepository.save(Review.builder()
                .user(user)
                .store(store)
                .rating(request.getRating())
                .content(request.getContent())
                .taste(request.getTaste())
                .amount(request.getAmount())
                .kindness(request.getKindness())
                .build());
    }
}
