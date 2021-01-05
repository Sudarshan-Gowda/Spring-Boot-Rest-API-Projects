package com.star.sud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.star.sud.dto.Employees;
import com.star.sud.model.Employee;
import com.star.sud.service.IEmployeeService;

@RestController
public class EmployeeController {

	// Attributes
	/////////////////
	@Autowired
	private IEmployeeService service;

	@GetMapping(path = "/employees", produces = "application/json")
	public Employees getEmployees() {
		return service.getEmployees();
	}

	@GetMapping(path = "/employees/{id}", produces = "application/json")
	public Employee getEmployeeById(@PathVariable Integer id) throws Exception {
		return service.getEmployeeByID(id);
	}

	@PostMapping(path = "/employees", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
		return service.addEmployee(employee);
	}

	@GetMapping(path = "/evictAllCache")
	public String evictAllCache() {
		return service.evictAllCache();
	}

}