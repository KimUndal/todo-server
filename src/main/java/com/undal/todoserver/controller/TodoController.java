package com.undal.todoserver.controller;

import com.undal.todoserver.model.Category;
import com.undal.todoserver.model.Todo;
import com.undal.todoserver.service.CategoryService;
import com.undal.todoserver.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class TodoController {
    private final CategoryService categoryService;
    private final TodoService todoService;

    public TodoController(CategoryService categoryService, TodoService todoService) {
        this.categoryService = categoryService;
        this.todoService = todoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories = categoryService.findAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") String id){
        Category category = categoryService.findCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category newCategory = categoryService.addCategory(category);
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category){
        Category updateCategory = categoryService.updateCategory(category);
        return new ResponseEntity<>(updateCategory, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") String id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //---------------------------------//
    //todos

    @GetMapping("/all/{categoryId}/all")
    public ResponseEntity<List<Todo>> getAllTodos(@PathVariable("categoryId") String categoryId){
        List<Todo> todos = todoService.findAllTodosByCategoryId(categoryId);
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }
    @GetMapping("/find/{categoryId}/{todoId}")
    public ResponseEntity<Todo> getTodo(@PathVariable("categoryId") String categoryId, @PathVariable("todoId") String todoId){
        Todo todo = todoService.findTodoByIdAndCategoryId(categoryId, todoId);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PostMapping("/{categoryId}/add")
    public ResponseEntity<Todo> addTodo(@PathVariable("categoryId") String categoryId ,@RequestBody Todo todo){
        Todo newTodo = todoService.addTodo(todo, categoryId);
        return new ResponseEntity<>(newTodo, HttpStatus.CREATED);
    }

    @PatchMapping("/{categoryId}/update/{todoId}")
    public ResponseEntity<?> updateCategory(@PathVariable("categoryId") String categoryId, @PathVariable("todoId") String todoId, @RequestBody Todo todo){
        todoService.updateTodo(todo, categoryId, todoId);
        return new ResponseEntity<>( HttpStatus.OK);
    }

/*    @PutMapping("/{categoryId}/{id}/update")
    public ResponseEntity<?> setCompleted(@PathVariable("categoryId") String categoryId, @PathVariable("id") String id){
      todoService.updateCompleted(categoryId, id);
        return new ResponseEntity<>( HttpStatus.OK);
    }*/

    @DeleteMapping("/{categoryId}/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("categoryId") String categoryId ,@PathVariable("id") String id){
        todoService.deleteTodoByIdAndCategoryId(id, categoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
