package com.example.todo.service;

import com.example.todo.dao.TodoDao;
import com.example.todo.dto.TodoDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

  @Autowired
  TodoDao todoDao;

  public int insertTodo(TodoDto todoDto) {
    int result = todoDao.insertTodo(todoDto);
    return result;
  }

  public List<TodoDto> getAllTodo(String pickedDate) {
    List<TodoDto> todoList = todoDao.getAllTodo(pickedDate);
    return todoList;
  }

  public int deleteTodo(int no) {
    int result = todoDao.deleteTodo(no);
    return result;
  }

  public int updateTodo(TodoDto todoDto) {
    int result = todoDao.updateTodo(todoDto);
    return result;
  }
}
