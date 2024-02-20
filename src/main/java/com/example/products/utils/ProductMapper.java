package com.example.products.utils;

import com.example.products.dto.ProductDto;
import com.example.products.model.ProductModel;

public class ProductMapper {
    public static ProductModel productModel(ProductDto productDto){
        ProductModel productModel = new ProductModel();
        productModel.setName(productDto.getName());
        productModel.setPrice(productDto.getPrice());
        return productModel;
    }
    public static ProductDto toProductDto(ProductModel model){
        ProductDto productDto = new ProductDto();
        productDto.setName(model.getName());
        productDto.setPrice(model.getPrice());
        return productDto;
    }

}
