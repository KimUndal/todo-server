package com.undal.todoserver.repo;

import com.undal.todoserver.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, String> {

    @Query("select t from Todo t where t.categoryId = ?1 and t.id = ?2")
    Optional<Todo> findTodoByCategoryIdAndId(String categoryId, String id);

    @Transactional
    @Modifying
    @Query("delete from Todo t where t.id = ?1 and t.categoryId = ?2")
    void deleteTodoByIdAndCategoryId(String id, String categoryId);
    @Query("select t from Todo t where t.categoryId = ?1")
    List<Todo> findAllTodosByCategoryId(String categoryId);

    @Modifying
    @Transactional
    @Query("update Todo t set t.completed = :completed, t.task = :task where t.categoryId = :categoryId and t.id = :id")
    void updateTodo(boolean completed, String task, String categoryId, String id);

/*    @Modifying
    @Transactional
    @Query("update Todo t set t.completed = true where t.categoryId = :categoryId and t.id = :id")
    void setCompleted(String categoryId, String id);*/
}