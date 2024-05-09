package com.example.muckja.domain.review.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class ReviewUploadRequest {
    @NotNull
    private long storeId;

    @NotNull
    private int rating;

    private String content;

    @NotNull
    private int taste;

    @NotNull
    private int amount;

    @NotNull
    private int kindness;
}
