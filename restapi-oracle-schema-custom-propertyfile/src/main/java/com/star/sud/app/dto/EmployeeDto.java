package com.star.sud.app.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class EmployeeDto implements Serializable {

	// Static Attributes
	//////////////////////
	private static final long serialVersionUID = 7771414936043651134L;

	// Attributes
	////////////////
	private String empId;

	@Size(max = 100, message = "empName should not exceed lenght 100")
	private String empName;

	@Size(max = 120, message = "empEmail should not exceed lenght 120")
	private String empEmail;

	@NotNull(message = "yearOfExp identifier is required")
	private BigDecimal yearOfExp;

	@NotEmpty(message = "deptCode identifier is required")
	private String deptCode;

	@NotEmpty(message = "dob identifier is required")
	private String dob;

	@JsonIgnore
	private Character status;

	private Set<AddressDetailDto> addressDetails;

	private Set<ProjectsDto> projects;

	// Properties
	///////////////
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<AddressDetailDto> getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(Set<AddressDetailDto> addressDetails) {
		this.addressDetails = addressDetails;
	}

	public Set<ProjectsDto> getProjects() {
		return projects;
	}

	public void setProjects(Set<ProjectsDto> projects) {
		this.projects = projects;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public BigDecimal getYearOfExp() {
		return yearOfExp;
	}

	public void setYearOfExp(BigDecimal yearOfExp) {
		this.yearOfExp = yearOfExp;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

}
