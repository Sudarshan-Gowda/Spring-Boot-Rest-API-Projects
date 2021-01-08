package com.star.sud.todo.service;

import java.util.List;

import com.star.sud.todo.dto.ToDoDto;

public interface IToDoService {

	public List<ToDoDto> getAllToDo();

	public ToDoDto getToDoById(long id) throws Exception;

	public ToDoDto saveToDo(ToDoDto todo);

	public void removeToDo(Long id) throws Exception;

}
