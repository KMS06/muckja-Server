package com.example.muckja.domain.store.service;

import com.example.muckja.domain.store.domain.Store;
import com.example.muckja.domain.store.domain.repository.StoreRepository;
import com.example.muckja.domain.store.facade.StoreFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class StoreDeleteService {
    private final StoreFacade storeFacade;
    private final StoreRepository storeRepository;

    @Transactional
    public void execute(Long storeId){
        Store store = storeFacade.findById(storeId);

        storeRepository.delete(store);
    }
}
