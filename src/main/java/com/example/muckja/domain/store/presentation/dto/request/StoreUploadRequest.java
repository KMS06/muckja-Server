package com.example.muckja.domain.store.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class StoreUploadRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    private String menu;

    private String site;
}
