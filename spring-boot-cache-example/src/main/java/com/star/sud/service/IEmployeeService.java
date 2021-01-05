package com.star.sud.service;

import org.springframework.http.ResponseEntity;

import com.star.sud.dto.Employees;
import com.star.sud.model.Employee;

public interface IEmployeeService {

	Employees getEmployees();

	ResponseEntity<Object> addEmployee(Employee employee);

	Employee getEmployeeByID(Integer id) throws Exception;

	String evictAllCache();

}
