package com.example.muckja.domain.store.presentation;

import com.example.muckja.domain.store.presentation.dto.request.StoreUploadRequest;
import com.example.muckja.domain.store.service.StoreUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/stores")
@RequiredArgsConstructor
@RestController
public class StoreController {
    private final StoreUploadService storeUploadService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/upload")
    public void storeUpload(@RequestBody @Valid StoreUploadRequest request){
        storeUploadService.execute(request);
    }
}
