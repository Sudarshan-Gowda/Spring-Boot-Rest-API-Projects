package com.star.sud.todo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TODO")
public class ToDo implements Serializable {

	// Static Attributes
	///////////////////////
	private static final long serialVersionUID = 8376544981107706024L;

	// Attributes
	////////////////////
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "DESC")
	private String desc;

	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "COMPLETION_DATE")
	private Date completionDate;

	@Column(name = "IS_COMPLETED")
	private Boolean isCompleted;

	// Constructors
	/////////////////
	public ToDo() {
		super();
	}

	/**
	 * @param id
	 * @param desc
	 * @param startDate
	 * @param completionDate
	 * @param isCompleted
	 */
	public ToDo(Long id, String desc, Date startDate, Date completionDate, Boolean isCompleted) {
		super();
		this.id = id;
		this.desc = desc;
		this.startDate = startDate;
		this.completionDate = completionDate;
		this.isCompleted = isCompleted;
	}

	// Properties
	/////////////////
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
