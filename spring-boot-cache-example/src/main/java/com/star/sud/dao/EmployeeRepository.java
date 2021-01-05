package com.star.sud.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.star.sud.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}