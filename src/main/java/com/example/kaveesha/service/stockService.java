package com.example.kaveesha.service;

import com.example.kaveesha.api.Entitiy.stock;
import com.example.kaveesha.api.repository.IRepository;
import com.example.kaveesha.api.request.stockRequest;
import com.example.kaveesha.api.response.stockResponse;
import com.example.kaveesha.api.utils.stockUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class stockService {

    @Autowired
    private IRepository repository;

    //Add for mysql
    public stockResponse addStock(stockRequest stockRes) {

        System.out.println(stockRes);
       stock stockObj = stock.builder()
                .id(stockRes.getId())
                .name(stockRes.getName())
                .price(stockRes.getPrice())
                .visibility(stockRes.getVisibility())
                .quantity(stockRes.getQuantity())
                .description(stockRes.getDescription())
                .image(stockRes.getImage())
                .build();

       return stockUtils.mapToResponse(repository.save(stockObj));

    }
    //Get all stock

    /*
    public Optional<stock> getStockById(String id) {
        Optional optional = Optional.empty();
        for (stock stock : stockList) {
            if (stock.getId().equals(id)) {
                optional = Optional.of(stock);
                return optional;
            }
        }
        return optional;

    }

    //Delete stock by id
    public void deleteStockById(String id) {
        Optional optional = getStockById(id);
        if (optional.isPresent()) {
            stockList.remove((stock) optional.get());
        }
    }
*/
    //Update visibility
    /*public void updateVisibility(String id,String visibility) {
        Optional optional = getStockById(id);
        if (optional.isPresent()) {
            stock stock = (stock) optional.get();
            stock.setVisibility(visibility);
        }
    }*/
}
