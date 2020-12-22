package com.star.sud.app.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.star.sud.app.shoppingcart.entity.ShoppingCartItems;

public interface ShoppingCartItemsRepository extends JpaRepository<ShoppingCartItems, Long> {

}
