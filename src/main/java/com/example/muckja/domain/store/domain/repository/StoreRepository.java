package com.example.muckja.domain.store.domain.repository;

import com.example.muckja.domain.store.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
