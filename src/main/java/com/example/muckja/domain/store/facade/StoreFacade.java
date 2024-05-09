package com.example.muckja.domain.store.facade;

import com.example.muckja.domain.store.domain.Store;
import com.example.muckja.domain.store.domain.repository.StoreRepository;
import com.example.muckja.domain.store.exception.StoreExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
}
