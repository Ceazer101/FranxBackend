package com.example.franxbackend.apis;

import com.example.franxbackend.dtos.BikeResponse;
import com.example.franxbackend.dtos.ProductRequest;
import com.example.franxbackend.dtos.ProductResponse;
import com.example.franxbackend.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@CrossOrigin
public class ProductController {

    ProductService productService;

    public ProductController(ProductService service) {
        this.productService = service;
    }

    @GetMapping
    public List<ProductResponse> getAllBikes(){
        List<ProductResponse> response = productService.getAllProducts();
        return response;
    }

    @PostMapping
    public ProductResponse addProduct(@RequestBody ProductRequest body){
        return productService.addProduct(body);
    }

    @GetMapping("/{productNumber}")
    public ProductResponse getSignleProduct(@PathVariable Integer productNumber){
        ProductResponse productResponse = productService.getSingleProduct(productNumber);
        return productResponse;
    }

    @PutMapping("/{productNumber}")
    public ResponseEntity<Boolean> editProduct(@RequestBody ProductRequest body, @PathVariable Integer productNumber){
        productService.editProduct(body, productNumber);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
