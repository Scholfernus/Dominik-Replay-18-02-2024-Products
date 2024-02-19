package com.example.products.service;

import com.example.products.dto.ProductDto;
import com.example.products.model.ProductModel;
import com.example.products.repository.ProductsRepository;
import com.example.products.utils.ProductMapper;
import com.example.products.utils.error.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository productRepository;

    public List<ProductModel> getAllProductsList() {
        return productRepository.findAll();
    }

    public ProductModel getProductById(Long id) throws Exception {
        return productRepository.findById(id).orElseThrow(()->new Exception("product doesn't exist"));
    }


    public void addSomeProduct(ProductModel model) {
        productRepository.save(model);
    }


    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
        }

    public ProductDto updateProductPrice(Long id, ProductDto productsDto) {
        ProductModel product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product doesn't exist"));
        product.setPrice(productsDto.getPrice());
        ProductModel saveProduct = productRepository.save(product);
        return ProductMapper.toProductDto(saveProduct);
    }

    public List<ProductModel> getProductByPrice(Double price) {
        return productRepository.findByPrice(price);
    }
}
