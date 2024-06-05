package com.example.muckja.domain.store.facade;

import com.example.muckja.domain.store.domain.Store;
import com.example.muckja.domain.store.domain.repository.StoreRepository;
import com.example.muckja.domain.store.exception.StoreExistException;
import com.example.muckja.domain.store.exception.StoreNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class StoreFacade {
    private final StoreRepository storeRepository;
    public void checkStoreExist(String name, String address){
        Optional<Store> store = storeRepository.findByNameAndAddress(name,address);
        if(store.isPresent())
            throw StoreExistException.EXCEPTION;
    }

    public List<Store> findByName(String name){
        return storeRepository.findByNameContainingOrderByAvg(name);
    }

    public Store findById(Long storeId){
        return storeRepository.findById(storeId)
                .orElseThrow(() -> StoreNotFoundException.EXCEPTION);
    }
}
