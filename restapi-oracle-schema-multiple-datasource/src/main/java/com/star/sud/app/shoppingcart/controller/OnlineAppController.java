package com.star.sud.app.shoppingcart.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.star.sud.app.exception.RecordNotFoundException;
import com.star.sud.app.shoppingcart.dto.ProductDto;
import com.star.sud.app.shoppingcart.dto.ShoppingCartDto;
import com.star.sud.app.shoppingcart.dto.UserDto;
import com.star.sud.app.shoppingcart.service.IOnlineAppService;

@RestController
@RequestMapping(value = "shop")
public class OnlineAppController {

	@Autowired
	private IOnlineAppService service;

	// Create Method
	@PostMapping("/product")
	public ResponseEntity<?> createProduct(@RequestBody ProductDto request) throws ParseException {
		return service.createProduct(request);
	}

	@PostMapping("/user")
	public ResponseEntity<?> createUser(@RequestBody UserDto request) {
		return service.createUser(request);
	}

	@PostMapping("/shoppingcart")
	public ResponseEntity<?> createShoppingCart(@RequestBody ShoppingCartDto request) {
		return service.createShoppingCart(request);
	}

	// Update Method
	@PutMapping("/product/{prdId}")
	public ResponseEntity<?> updateProduct(@PathVariable("prdId") Long prdId, @RequestBody ProductDto request)
			throws Exception {
		return service.updateProduct(prdId, request);
	}

	@PutMapping("/user/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable("userId") String userId, @RequestBody UserDto request)
			throws Exception {
		return service.updateUser(userId, request);
	}

	// Delete Method
	@DeleteMapping("/product/{prdId}")
	public ResponseEntity<?> deleteProduct(@PathVariable("prdId") Long prdId) {
		return service.deleteProduct(prdId);
	}

	@DeleteMapping("/user/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") String userId) {
		return service.deleteUser(userId);
	}

	@DeleteMapping("/shoppingcart/{cartId}")
	public ResponseEntity<?> deleteShoppingCart(@PathVariable("cartId") Long cartId) {
		return service.deleteShoppingCart(cartId);
	}

	// Get Method
	@GetMapping("/product/{prdId}")
	public ResponseEntity<?> getProductById(@PathVariable("prdId") Long prdId) throws RecordNotFoundException {
		return service.getProductById(prdId);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable("userId") String userId) throws RecordNotFoundException {
		return service.getUserById(userId);
	}

	@GetMapping("/shoppingcart/{cartId}")
	public ResponseEntity<?> getShoppingCartById(@PathVariable("cartId") Long cartId) throws RecordNotFoundException {
		return service.getShoppingCartById(cartId);
	}

}
