package com.example.muckja.domain.store.domain.repository;

import com.example.muckja.domain.store.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Store> findByNameAndAddress(String name, String address);

    List<Store> findByNameContaining(String name);
}
