package com.star.sud.todo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.star.sud.todo.dto.Response;
import com.star.sud.todo.dto.ToDoDto;
import com.star.sud.todo.service.IToDoService;

@Controller
public class ToDoController {

	private static final Logger logger = LoggerFactory.getLogger(ToDoController.class);

	@Autowired
	private IToDoService service;

	@RequestMapping(value = "/todo", method = RequestMethod.GET)
	public ResponseEntity<List<ToDoDto>> getAllToDoDto() {
		logger.info("Returning all the ToDoDto´s");
		return new ResponseEntity<List<ToDoDto>>(service.getAllToDo(), HttpStatus.OK);
	}

	@RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
	public ResponseEntity<ToDoDto> getToDoDtoById(@PathVariable("id") long id) throws Exception {
		logger.info("ToDoDto id to return " + id);
		return new ResponseEntity<ToDoDto>(service.getToDoById(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/todo/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> removeToDoDtoById(@PathVariable("id") long id) throws Exception {
		logger.info("ToDoDto id to remove " + id);
		service.removeToDo(id);
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "ToDoDto has been deleted"),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/todo", method = RequestMethod.POST)
	public ResponseEntity<ToDoDto> saveToDoDto(@RequestBody ToDoDto payload) {
		logger.info("Payload to save " + payload);
		return new ResponseEntity<ToDoDto>(service.saveToDo(payload), HttpStatus.OK);
	}

	@RequestMapping(value = "/todo", method = RequestMethod.PUT)
	public ResponseEntity<ToDoDto> updateToDoDto(@RequestBody ToDoDto payload) throws Exception {
		logger.info("Payload to update " + payload);
		return new ResponseEntity<ToDoDto>(service.saveToDo(payload), HttpStatus.OK);
	}

}
