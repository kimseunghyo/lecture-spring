package com.example.todo.service;

import com.example.todo.dto.TodoDto;
import java.util.List;

public interface TodoService {
  public int insertTodo(TodoDto todoDto);

  public List<TodoDto> getAllTodo(String pickedDate);

  public int deleteTodo(int no);

  public int updateTodo(TodoDto todoDto);
}
