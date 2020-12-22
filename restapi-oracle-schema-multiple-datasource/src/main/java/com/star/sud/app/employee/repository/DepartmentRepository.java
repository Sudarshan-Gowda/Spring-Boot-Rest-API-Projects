package com.star.sud.app.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.star.sud.app.employee.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, String> {

}
