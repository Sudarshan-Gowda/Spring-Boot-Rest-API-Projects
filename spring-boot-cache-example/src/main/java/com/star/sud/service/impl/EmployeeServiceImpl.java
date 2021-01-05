package com.star.sud.service.impl;

import java.net.URI;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.star.sud.dao.EmployeeRepository;
import com.star.sud.dto.Employees;
import com.star.sud.model.Employee;
import com.star.sud.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	private static Logger log = LogManager.getLogger(EmployeeServiceImpl.class);

	// Attributes
	///////////////
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	@Cacheable(value = "employees", unless = "#result == null")
	public Employees getEmployees() {

		log.info("getEmployees API Start");
		Employees response = new Employees();
		ArrayList<Employee> list = new ArrayList<>();
		employeeRepository.findAll().forEach(e -> list.add(e));
		response.setEmployeeList(list);
		log.info("getEmployees API End");

		return response;
	}

	@Override
	@Cacheable(value = "employee", condition = "#result == null")
	public Employee getEmployeeByID(Integer id) throws Exception {
		log.info("getEmployeeByID API");
		return employeeRepository.findById(id).orElseThrow(() -> new Exception("No record found"));
	}

	@Override
	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
		log.info("addEmployee API Starts");
		employee = employeeRepository.save(employee);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId())
				.toUri();
		log.info("addEmployee API Ends");
		return ResponseEntity.created(location).build();
	}

	@Override
	@CacheEvict(value = { "employees", "employee" }, allEntries = true)
	public String evictAllCache() {
		return "cache evicted successfully!";
	}

}
