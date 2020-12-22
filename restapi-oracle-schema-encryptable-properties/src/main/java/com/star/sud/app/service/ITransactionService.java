package com.star.sud.app.service;

import java.text.ParseException;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.star.sud.app.dto.EmployeeDto;
import com.star.sud.app.dto.ProjectsDto;
import com.star.sud.app.exception.RecordNotFoundException;

public interface ITransactionService {

	ResponseEntity<?> createEmployee(EmployeeDto employee, BindingResult result) throws Exception;

	ResponseEntity<?> createProjects(Set<ProjectsDto> request, BindingResult result);

	ResponseEntity<?> getEmployeeById(String empId) throws Exception;

	ResponseEntity<?> getProjectsByCode(String projectCode) throws Exception;

	ResponseEntity<?> deleteEmployeeById(String empId);

	ResponseEntity<?> updateEmployeeById(String empId, @Valid EmployeeDto request)
			throws RecordNotFoundException, ParseException;

}
