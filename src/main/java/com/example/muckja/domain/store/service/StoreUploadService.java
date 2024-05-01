package com.example.muckja.domain.store.service;

import com.example.muckja.domain.store.domain.Store;
import com.example.muckja.domain.store.domain.repository.StoreRepository;
import com.example.muckja.domain.store.facade.StoreFacade;
import com.example.muckja.domain.store.presentation.dto.request.StoreUploadRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class StoreUploadService {
    private final StoreFacade storeFacade;
    private final StoreRepository storeRepository;
    @Transactional
    public void execute(StoreUploadRequest request){
        storeFacade.checkStoreExist(request.getName(), request.getAddress());

        storeRepository.save(Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .avg(BigDecimal.ZERO)
                .menu(request.getMenu())
                .taste(BigDecimal.ZERO)
                .amount(BigDecimal.ZERO)
                .kindness(BigDecimal.ZERO)
                .site(request.getSite())
                .build());
    }
}
