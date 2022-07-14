package com.undal.todoserver.model;

public interface TodoRepository extends org.springframework.data.jpa.repository.JpaRepository<com.undal.todoserver.model.Todo, java.util.UUID> {
}