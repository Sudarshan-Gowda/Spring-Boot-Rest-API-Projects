package com.star.sud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import com.star.sud.model.Employee;
import com.star.sud.model.Employees;

@SpringBootTest(classes = SpringBootJunit5ExampleApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Sql({ "classpath:schema.sql", "classpath:import.sql" })
	@Test
	public void testAllEmployees() {
		assertTrue(this.restTemplate.getForObject("http://localhost:" + port + "/employees", Employees.class)
				.getEmployeeList().size() == 1);
	}

	@Test
	public void testAddEmployee() {
		Employee employee = new Employee("User", "Test", "usertest@gmail.com");
		ResponseEntity<String> responseEntity = this.restTemplate
				.postForEntity("http://localhost:" + port + "/employees", employee, String.class);
		assertEquals(201, responseEntity.getStatusCodeValue());
	}
}