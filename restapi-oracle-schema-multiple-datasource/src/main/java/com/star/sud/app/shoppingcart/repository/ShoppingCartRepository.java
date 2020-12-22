package com.star.sud.app.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.star.sud.app.shoppingcart.entity.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

}
