package com.star.sud.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.star.sud.todo.dto.ToDoDto;
import com.star.sud.todo.exception.ToDoException;
import com.star.sud.todo.model.ToDo;
import com.star.sud.todo.repo.ToDoRepository;

@Service
public class ToDoServiceImpl implements IToDoService {

	@Autowired
	private ToDoRepository toDoRepository;

	@Override
	public List<ToDoDto> getAllToDo() {

		List<ToDoDto> dtos = new ArrayList<>();
		toDoRepository.findAll().stream().forEach(todo -> {
			ToDoDto dto = new ToDoDto();
			BeanUtils.copyProperties(todo, dto);
			dtos.add(dto);
		});

		return dtos;
	}

	@Override
	public ToDoDto getToDoById(long id) throws Exception {
		ToDo todo = toDoRepository.findById(id).orElseThrow(() -> new Exception("No record found for id:" + id));
		ToDoDto dto = new ToDoDto();
		BeanUtils.copyProperties(todo, dto);
		return dto;
	}

	@Override
	public ToDoDto saveToDo(ToDoDto todo) {
		ToDo entity = new ToDo();
		BeanUtils.copyProperties(todo, entity);
		ToDo save = toDoRepository.save(entity);
		BeanUtils.copyProperties(save, todo);
		return todo;
	}

	public ToDoDto updateToDo(ToDoDto todo) throws Exception {
		if (todo.getId() == null)
			throw new ToDoException("Id must not be null or empty");

		ToDo entity = toDoRepository.findById(todo.getId())
				.orElseThrow(() -> new Exception("No record found for id:" + todo.getId()));

		BeanUtils.copyProperties(todo, entity, "id");
		toDoRepository.save(entity);
		return todo;
	}

	@Override
	public void removeToDo(Long id) throws Exception {
		ToDo todo = toDoRepository.findById(id).orElseThrow(() -> new Exception("No record found for id:" + id));
		toDoRepository.delete(todo);
	}

}
