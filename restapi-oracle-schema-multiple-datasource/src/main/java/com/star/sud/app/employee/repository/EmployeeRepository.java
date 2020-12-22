package com.star.sud.app.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.star.sud.app.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
