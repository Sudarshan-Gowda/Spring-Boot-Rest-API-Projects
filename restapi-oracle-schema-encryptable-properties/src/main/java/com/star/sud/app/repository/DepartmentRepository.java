package com.star.sud.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.star.sud.app.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, String> {

}
