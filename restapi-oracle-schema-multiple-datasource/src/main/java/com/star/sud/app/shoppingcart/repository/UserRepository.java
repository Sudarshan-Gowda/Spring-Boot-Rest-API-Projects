package com.star.sud.app.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.star.sud.app.shoppingcart.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
