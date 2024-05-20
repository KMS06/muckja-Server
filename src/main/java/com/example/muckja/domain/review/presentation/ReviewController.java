package com.example.muckja.domain.review.presentation;

import com.example.muckja.domain.review.domain.Review;
import com.example.muckja.domain.review.presentation.dto.request.ReviewUploadRequest;
import com.example.muckja.domain.review.presentation.dto.response.QueryReviewResponse;
import com.example.muckja.domain.review.service.QueryReviewService;
import com.example.muckja.domain.review.service.ReviewUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/review")
@RequiredArgsConstructor
@RestController
public class ReviewController {
    private final ReviewUploadService reviewUploadService;
    private final QueryReviewService queryReviewService;

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public void reviewUpload(@RequestBody @Valid ReviewUploadRequest request){
        reviewUploadService.execute(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<QueryReviewResponse> queryReview(@PathVariable("id") Long storeId){
        return queryReviewService.execute(storeId);
    }
}
