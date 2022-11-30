package com.example.franxbackend.services;


import com.example.franxbackend.dtos.BikeRequest;
import com.example.franxbackend.dtos.BikeResponse;
import com.example.franxbackend.dtos.ProductRequest;
import com.example.franxbackend.dtos.ProductResponse;

import com.example.franxbackend.entities.Bike;
import com.example.franxbackend.entities.Product;


import com.example.franxbackend.entities.Status;
import com.example.franxbackend.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductServiceTest {

    ProductService productService;
    public static ProductRepository productRepository;


    @BeforeAll
    public static void initTestData(@Autowired ProductRepository product_repository){
        productRepository = product_repository;
        productRepository.deleteAll();
        Product product = new Product(1234, "hjelm", "Til hovedet", "hjelmemanden", 'D', 3, 250);
        Product product1 = new Product(4321, "lygte", "til lys", "lygtemanden", 'Y', 45, 550);

        productRepository.save(product);
        productRepository.save(product1);
    }

    @BeforeEach
    public void initBikeService(){
        productService = new ProductService(productRepository);
    }


    @Test
    void getAllProducts() {
        List<ProductResponse> productList = productService.getAllProducts();
        assertEquals(2, productList.size());
    }

    @Test
    void addProduct() {
        Product product = new Product(6789, "hjelm", "Til hovedet", "hjelmemanden", 'D', 3, 250);
        ProductRequest productRequest = new ProductRequest(product);
        ProductResponse productResponse = productService.addProduct(productRequest);
        assertEquals(6789, productResponse.getProductNumber());
    }
}