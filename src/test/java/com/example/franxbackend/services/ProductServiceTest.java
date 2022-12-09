package com.example.franxbackend.services;

import com.example.franxbackend.dtos.ProductRequest;
import com.example.franxbackend.dtos.ProductResponse;
import com.example.franxbackend.entities.Product;

import com.example.franxbackend.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductServiceTest {

    ProductService productService;
    public static ProductRepository productRepository;


    @BeforeAll
    public static void initTestData(@Autowired ProductRepository product_repository) {
        productRepository = product_repository;
        productRepository.deleteAll();
        Product product = new Product(1234, "hjelm", "Til hovedet", "hjelmemanden", 'D', 3, 250);
        Product product1 = new Product(4321, "lygte", "til lys", "lygtemanden", 'Y', 45, 550);

        productRepository.save(product);
        productRepository.save(product1);
    }

    @BeforeEach
    public void initBikeService() {
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

    @Test
    void getSingleProductByNotExistingProductNumber() {
        ResponseStatusException productResponse = Assertions
                .assertThrows(ResponseStatusException.class, () -> productService.getSingleProduct(0));
        assertEquals(HttpStatus.NOT_FOUND, productResponse.getStatus());
    }

    @Test
    void editProduct() {
        ProductRequest productRequest = new ProductRequest
                (new Product(1234, "hjelm", "Til knæet", "hjelmemanden", 'D', 3, 300));
        productService.editProduct(productRequest, 1234);


        ProductResponse productResponse = productService.getSingleProduct(1234);
        assertEquals(300, productResponse.getUnitPrice());
        assertEquals("Til knæet", productResponse.getProductDesc());
    }

}