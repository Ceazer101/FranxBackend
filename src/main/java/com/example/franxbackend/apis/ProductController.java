package com.example.franxbackend.apis;

import com.example.franxbackend.dtos.BikeResponse;
import com.example.franxbackend.dtos.ProductRequest;
import com.example.franxbackend.dtos.ProductResponse;
import com.example.franxbackend.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@CrossOrigin
public class ProductController {

    ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductResponse> getAllBikes(){
        List<ProductResponse> response = service.getAllProducts();
        return response;
    }

    @PostMapping
    public ProductResponse addProduct(@RequestBody ProductRequest body){
        return service.addProduct(body);
    }


}
