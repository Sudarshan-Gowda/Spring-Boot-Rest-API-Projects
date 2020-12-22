package com.star.sud.app.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.star.sud.app.employee.entity.Projects;

public interface ProjectsRepository extends JpaRepository<Projects, Long> {

	public Projects findByProjectCode(String projectCode);

}
