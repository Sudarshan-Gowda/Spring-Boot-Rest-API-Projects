package com.star.sud.todo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ToDoDto {

	private Long id;

	private String desc;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date startDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date completionDate;

	private Boolean isCompleted;

	public ToDoDto() {
		super();
	}

	public ToDoDto(String desc, Date startDate, Date completionDate, Boolean isCompleted) {
		super();
		this.desc = desc;
		this.startDate = startDate;
		this.completionDate = completionDate;
		this.isCompleted = isCompleted;
	}

	public ToDoDto(Long id, String desc, Date startDate, Date completionDate, Boolean isCompleted) {
		super();
		this.id = id;
		this.desc = desc;
		this.startDate = startDate;
		this.completionDate = completionDate;
		this.isCompleted = isCompleted;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
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

}
