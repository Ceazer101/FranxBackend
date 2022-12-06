package com.example.franxbackend.services;

import com.example.franxbackend.dtos.BikeResponse;
import com.example.franxbackend.dtos.ProductRequest;
import com.example.franxbackend.dtos.ProductResponse;
import com.example.franxbackend.entities.Bike;
import com.example.franxbackend.entities.Product;
import com.example.franxbackend.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository repository) {
        this.productRepository = repository;
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();
        List<ProductResponse> response = products.stream().map(product ->
                new ProductResponse(product)).collect(Collectors.toList());

        return response;
    }

    public ProductResponse addProduct(ProductRequest productRequest){
        Product newProduct = ProductRequest.getProductEntity(productRequest);
        newProduct = productRepository.save(newProduct);
        return new ProductResponse(newProduct);
    }

    public ProductResponse getSingleProduct(Integer productNumber){
        Product product = productRepository.findById(productNumber).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Product with this product id does not exist"));
        ProductResponse productResponse = new ProductResponse(product);
        return productResponse;
    }

    public void editProduct(ProductRequest body, Integer productNumber){
        Product product = productRepository.findById(productNumber).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Product with this product id does not exist"));

        product.setProductName(body.getProductName());
        product.setProductDesc(body.getProductDesc());
        product.setDistributor(body.getDistributor());
        product.setTaxCode(body.getTaxCode());
        product.setNumberOfUnits(body.getNumberOfUnits());
        product.setUnitPrice(body.getUnitPrice());
        productRepository.save(product);
    }

}
