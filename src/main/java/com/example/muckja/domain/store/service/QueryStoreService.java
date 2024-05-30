package com.example.muckja.domain.store.service;

import com.example.muckja.domain.store.domain.Store;
import com.example.muckja.domain.store.facade.StoreFacade;
import com.example.muckja.domain.store.presentation.dto.response.QueryStoreResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryStoreService {
    private final StoreFacade storeFacade;

    @Transactional
    public List<QueryStoreResponse> execute(String name){
        List<QueryStoreResponse> storeList = storeFacade.findByName(name).stream()
                .map(QueryStoreResponse::from)
                .toList();

        return storeList;
    }
}
