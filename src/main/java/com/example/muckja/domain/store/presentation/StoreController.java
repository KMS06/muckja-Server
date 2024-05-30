package com.example.muckja.domain.store.presentation;

import com.example.muckja.domain.store.presentation.dto.request.StoreUploadRequest;
import com.example.muckja.domain.store.presentation.dto.response.QueryStoreResponse;
import com.example.muckja.domain.store.service.QueryStoreService;
import com.example.muckja.domain.store.service.StoreUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/stores")
@RequiredArgsConstructor
@RestController
public class StoreController {
    private final StoreUploadService storeUploadService;
    private final QueryStoreService queryStoreService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/upload")
    public void storeUpload(@RequestBody @Valid StoreUploadRequest request){
        storeUploadService.execute(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<QueryStoreResponse> queryStore(@RequestParam String name){
        return queryStoreService.execute(name);
    }
}
