package com.undal.todoserver.service;

import com.undal.todoserver.exceptions.TodoNotFoundException;
import com.undal.todoserver.model.Category;
import com.undal.todoserver.model.Todo;
import com.undal.todoserver.repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo addTodo(Todo todo, String categoryId){
        todo.setId(java.util.UUID.randomUUID().toString());
        todo.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        todo.setCompleted(false);
        todo.setCategoryId(categoryId);
        return todoRepository.save(todo);
    }

    public List<Todo> findAllTodosByCategoryId(String categoryId){
        return todoRepository.findAllTodosByCategoryId(categoryId);
    }

    public void updateTodo(Todo todo, String categoryId, String todoId){
       todoRepository.updateTodo(todo.isCompleted(), todo.getTask(), categoryId, todoId);
    }

/*    public void updateCompleted(String categoryId, String id){
         todoRepository.setCompleted(categoryId, id);
    }*/
    public Todo findTodoByIdAndCategoryId(String categoryId, String id){
        return todoRepository.findTodoByCategoryIdAndId(categoryId, id).orElseThrow(()-> new TodoNotFoundException("Todo by id: " + id + " was not found"));
    }

    public void deleteTodoByIdAndCategoryId(String id, String categoryId){
        todoRepository.deleteTodoByIdAndCategoryId(id, categoryId);
    }


}
