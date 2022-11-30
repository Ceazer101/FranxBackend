package com.example.franxbackend.services;

import com.example.franxbackend.dtos.BikeRequest;
import com.example.franxbackend.dtos.BikeResponse;
import com.example.franxbackend.dtos.ProductRequest;
import com.example.franxbackend.dtos.ProductResponse;
import com.example.franxbackend.entities.Bike;
import com.example.franxbackend.entities.Product;
import com.example.franxbackend.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> products = repository.findAll();
        List<ProductResponse> response = products.stream().map(product ->
                new ProductResponse(product)).collect(Collectors.toList());

        return response;
    }

    public ProductResponse addProduct(ProductRequest productRequest){
        Product newProduct = ProductRequest.getProductEntity(productRequest);
        newProduct = repository.save(newProduct);
        return new ProductResponse(newProduct);
    }

}
