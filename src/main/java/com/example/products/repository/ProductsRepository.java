package com.example.products.repository;

import com.example.products.model.ProductModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<ProductModel, Long> {
    @Query("SELECT p from ProductModel p where p.price =:price")
    List<ProductModel> findByPrice(@Param("price") Double price);
}
