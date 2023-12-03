package com.example.kaveesha.api.utils;


import com.example.kaveesha.api.Entitiy.stock;
import com.example.kaveesha.api.request.stockRequest;
import com.example.kaveesha.api.response.stockResponse;

public class stockUtils {
    public static stockResponse mapToResponse(stock stock) {
        return stockResponse.builder()
                .id(stock.getId())
                .name(stock.getName())
                .price(stock.getPrice())
                .visibility(stock.getVisibility())
                .quantity(stock.getQuantity())
                .description(stock.getDescription())
                .image(stock.getImage())
                .build();
    }
}
