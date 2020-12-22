package com.star.sud.app.employee.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.star.sud.app.constant.Constants;

@Entity
@Table(name = "PROJECTS", schema = Constants.SCHEMA_NAME)
public class Projects implements Serializable {

	// Static Attributes
	/////////////////////
	private static final long serialVersionUID = -2204690509747045007L;

	// Attributes
	////////////////
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROJECT_ID_SEQ")
	@SequenceGenerator(name = "PROJECT_ID_SEQ", allocationSize = 1, sequenceName = "PROJECT_ID_SEQ", schema = Constants.SCHEMA_NAME)
	@Column(name = "PROJECT_ID")
	private Long projectId;

	@Column(name = "PROJECT_CODE")
	private String projectCode;

	@Column(name = "PROJECT_NAME")
	private String projectName;

	@Column(name = "PROJECT_DESC")
	private String projectDesc;

	@Column(name = "STATUS")
	private Character status;

	@Column(name = "CREATE_DATE")
	private Date createDate;

	@ManyToMany(mappedBy = "projects")
	private Set<Employee> employees;

	// Properties
	////////////////
	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
