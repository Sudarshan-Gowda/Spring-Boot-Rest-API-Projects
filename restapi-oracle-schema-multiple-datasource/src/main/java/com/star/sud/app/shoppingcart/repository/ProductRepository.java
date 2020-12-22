package com.star.sud.app.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.star.sud.app.shoppingcart.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}