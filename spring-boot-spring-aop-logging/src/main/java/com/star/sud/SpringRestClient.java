package com.star.sud;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.star.sud.todo.dto.ToDoDto;

public class SpringRestClient {

	private static final String APP_URL = "http://localhost:8090/";
	private static final String APP_URL_GETALLTODO = APP_URL + "todo";
	private static final String APP_URL_GET_TODO_BYID = APP_URL + "todo/{id}";
	private static final String APP_URL_CREATE_TODO = APP_URL + "todo";
	private static final String APP_URL_UPDATE_TODO_BYID = APP_URL + "todo";
	private static final String APP_URL_DELETE_TODO_BYID = APP_URL + "todo/{id}";

	public static void main(String[] args) {

		SpringRestClient client = new SpringRestClient();
		client.getAllToDo();
		Long id = client.createTodo();
		client.getToDoById(id);
		client.updateTodo(id);
		client.deleteToDo(id);

	}

	public void getAllToDo() {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<String> result = new RestTemplate().exchange(APP_URL_GETALLTODO, HttpMethod.GET, entity,
				String.class);
		System.out.println(result);

	}

	public void getToDoById(Long id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(id));

		RestTemplate restTemplate = new RestTemplate();
		ToDoDto result = restTemplate.getForObject(APP_URL_GET_TODO_BYID, ToDoDto.class, params);
		System.out.println(result);

	}

	public Long createTodo() {
		ToDoDto dto = new ToDoDto("Learn Java", new Date(), new Date(), true);
		RestTemplate restTemplate = new RestTemplate();
		ToDoDto result = restTemplate.postForObject(APP_URL_CREATE_TODO, dto, ToDoDto.class);
		System.out.println(result);
		return result.getId();
	}

	public void updateTodo(Long id) {
		ToDoDto updateDto = new ToDoDto(id, "Learn Java 08", new Date(), new Date(), true);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(APP_URL_UPDATE_TODO_BYID, updateDto);
	}

	public void deleteToDo(Long id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(id));
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(APP_URL_DELETE_TODO_BYID, params);
	}

}
