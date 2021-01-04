package com.star.sud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.star.sud.model.TUser;

public interface UserRepository extends JpaRepository<TUser, Integer> {

}
