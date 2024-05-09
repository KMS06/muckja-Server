package com.example.muckja.domain.review.presentation;

import com.example.muckja.domain.review.presentation.dto.request.ReviewUploadRequest;
import com.example.muckja.domain.review.service.ReviewUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/review")
@RequiredArgsConstructor
@RestController
public class ReviewController {
    private final ReviewUploadService reviewUploadService;

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public void reviewUpload(@RequestBody @Valid ReviewUploadRequest request){
        reviewUploadService.execute(request);
    }
}
