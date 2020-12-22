package com.star.sud.app.shoppingcart.service;

import java.text.ParseException;

import org.springframework.http.ResponseEntity;

import com.star.sud.app.exception.RecordNotFoundException;
import com.star.sud.app.shoppingcart.dto.ProductDto;
import com.star.sud.app.shoppingcart.dto.ShoppingCartDto;
import com.star.sud.app.shoppingcart.dto.UserDto;

public interface IOnlineAppService {

	ResponseEntity<?> createProduct(ProductDto request) throws ParseException;

	ResponseEntity<?> createUser(UserDto request);

	ResponseEntity<?> updateUser(String userId, UserDto request) throws Exception;

	ResponseEntity<?> updateProduct(Long prdId, ProductDto request) throws Exception;

	ResponseEntity<?> deleteUser(String userId);

	ResponseEntity<?> deleteProduct(Long prdId);

	ResponseEntity<?> createShoppingCart(ShoppingCartDto request);

	ResponseEntity<?> deleteShoppingCart(Long cartId);

	ResponseEntity<?> getShoppingCartById(Long cartId) throws RecordNotFoundException;

	ResponseEntity<?> getProductById(Long prdId) throws RecordNotFoundException;

	ResponseEntity<?> getUserById(String userId) throws RecordNotFoundException;

}