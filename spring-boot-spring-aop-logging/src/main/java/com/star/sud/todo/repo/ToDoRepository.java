package com.star.sud.todo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.star.sud.todo.model.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {

}
