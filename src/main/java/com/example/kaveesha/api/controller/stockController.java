package com.example.kaveesha.api.controller;

import com.example.kaveesha.api.Entitiy.stock;
import com.example.kaveesha.api.request.stockRequest;
import com.example.kaveesha.api.response.stockResponse;
import com.example.kaveesha.service.stockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.util.Base64;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class stockController {


    @Autowired
    private stockService stockService;

    //get all stock
    @GetMapping("/stock")
    public java.util.List<stockResponse> getAllStock() {
        return stockService.getAllStock();
    }

    @PostMapping(value = "/stock", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public stockResponse addStock(
                                  @RequestParam("name") String name,
                                  @RequestParam("price") String price,
                                  @RequestParam("visibility") String visibility,
                                  @RequestParam("quantity") String quantity,
                                  @RequestParam("description") String description,
                                  @RequestParam("image") String imageFile) throws Exception {

        //        String imageString = Base64.getEncoder().encodeToString(imageFile.getBytes());

        stockRequest stockRes = stockRequest.builder()
                .name(name)
                .price(price)
                .visibility(visibility)
                .quantity(quantity)
                .description(description)
                .image(imageFile)
                .build();

        return stockService.addStock(stockRes);
    }

    //delete stock
    @DeleteMapping("/stock/{id}")
    public void deleteStock(@PathVariable Integer id) {
        stockService.deleteStock(id);
    }

    //update visibility to 0
    @PutMapping("/stock/unpublish/{id}")
    public void updateVisibility(@PathVariable Integer id) {
        stockService.updateVisibility(id,"0");

    }



    //Get stock by id
    @GetMapping("/stock/{id}")
    public Optional<stock> getStockById(@PathVariable Integer id) {
        return stockService.getStockById(id);
    }


}
