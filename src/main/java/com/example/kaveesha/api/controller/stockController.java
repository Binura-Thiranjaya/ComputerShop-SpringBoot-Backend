package com.example.kaveesha.api.controller;

import com.example.kaveesha.api.Entitiy.stock;
import com.example.kaveesha.api.request.stockRequest;
import com.example.kaveesha.api.response.stockResponse;
import com.example.kaveesha.service.stockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class stockController {


    @Autowired
    private stockService stockService;

    //get all stock
    @PostMapping(value = "/stock")
    @ResponseStatus(HttpStatus.CREATED)
    public stockResponse save(@RequestBody stockRequest stock) {
        return stockService.addStock(stock);
    }


}
