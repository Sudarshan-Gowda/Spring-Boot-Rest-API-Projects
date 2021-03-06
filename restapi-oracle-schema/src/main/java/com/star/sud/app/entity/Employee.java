package com.star.sud.app.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.star.sud.app.constant.Constants;

@Entity
@Table(name = "EMPLOYEE", schema = Constants.SCHEMA_NAME)
public class Employee implements Serializable {

	// Static Attributes
	///////////////////////
	private static final long serialVersionUID = 3817027388706625963L;

	// Attributes
	///////////////
	@Id
	@GenericGenerator(name = "EMPLOYEE_SEQ", strategy = "com.star.sud.app.common.CustomGenerator")
	@GeneratedValue(generator = "EMPLOYEE_SEQ")
	@Column(name = "EMP_ID")
	private String empId;

	@Column(name = "EMP_NAME")
	private String empName;

	@Column(name = "EMP_EMAIL")
	private String empEmail;

	@OneToOne
	@JoinColumn(name = "DEPT_CODE")
	private Department department;

	@Column(name = "YEAR_OF_EXP")
	private BigDecimal yearOfExp;

	@Column(name = "DATE_OF_BIRTH")
	private Date dob;

	@Column(name = "STATUS")
	private Character status;

	@Column(name = "CREATE_DATE")
	private Date createDate;

	@OneToMany(targetEntity = AddressDetail.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
	private Set<AddressDetail> addressDetails;

	@ManyToMany
	@JoinTable(name = "EMPLOYEE_PROJECTS", joinColumns = { @JoinColumn(name = "EMP_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "PROJECT_ID") })
	private Set<Projects> projects;

	// Properties
	////////////////
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<AddressDetail> getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(Set<AddressDetail> addressDetails) {
		this.addressDetails = addressDetails;
	}

	public void addProjects(Projects project) {
		this.projects.add(project);
		project.getEmployees().add(this);
	}

	public void removeProjects(Projects project) {
		this.projects.remove(project);
		project.getEmployees().remove(this);
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Projects> getProjects() {
		return projects;
	}

	public void setProjects(Set<Projects> projects) {
		this.projects = projects;
	}

	public BigDecimal getYearOfExp() {
		return yearOfExp;
	}

	public void setYearOfExp(BigDecimal yearOfExp) {
		this.yearOfExp = yearOfExp;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
