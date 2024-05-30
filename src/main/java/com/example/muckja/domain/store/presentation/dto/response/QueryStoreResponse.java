package com.example.muckja.domain.store.presentation.dto.response;

import com.example.muckja.domain.store.domain.Store;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class QueryStoreResponse {
    private String name;

    private String address;

    private BigDecimal avg;

    private String menu;

    private BigDecimal taste;

    private BigDecimal amount;

    private BigDecimal kindness;

    private String site;


    public static QueryStoreResponse from(Store store){
        return QueryStoreResponse.builder()
                .name(store.getName())
                .address(store.getAddress())
                .avg(store.getAvg())
                .menu(store.getMenu())
                .taste(store.getTaste())
                .amount(store.getAmount())
                .kindness(store.getKindness())
                .site(store.getSite())
                .build();
    }
}
