package com.example.products.controller;

import com.example.products.dto.ProductDto;
import com.example.products.model.ProductModel;
import com.example.products.service.ProductsService;
import com.example.products.utils.error.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductsController {
    private final ProductsService productService;
    @GetMapping
    public ResponseEntity<List<ProductModel>> getAllProducts(){
        try {
            List<ProductModel> productsList = productService.getAllProductsList();
            return ResponseEntity.ok(productsList);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getProductById(@PathVariable("id") Long id){
        try {
            ProductModel model = productService.getProductById(id);
            return ResponseEntity.ok(model);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/price/{price}")
    public ResponseEntity<List<ProductModel>> getProductByPrice(@PathVariable Double price) {
        try {
            List<ProductModel> product = productService.getProductByPrice(price);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping("/add")
    public ResponseEntity<ProductModel> addProduct(@RequestBody ProductModel model){
        productService.addSomeProduct(model);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductModel> getDeleteById(@PathVariable("id") Long id){
        try {
        productService.deleteProductById(id);
           return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PatchMapping("/{id}/price")
    public ResponseEntity<ProductDto> editProductPriceById(@PathVariable Long id,
                                                           @RequestBody ProductDto productsDto){
        try {
            ProductDto updateProduct = productService.updateProductPrice(id, productsDto);
           return ResponseEntity.ok(updateProduct);
        }catch (ProductNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
