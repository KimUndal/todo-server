package com.undal.todoserver.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
public class Todo implements Serializable {
    @Id
    @Column(nullable = false, updatable = false)
    private String id;
    private String task;
    private boolean completed;
    private java.sql.Timestamp createdAt;


    private String categoryId;

    public Todo() {
    }

    public Todo(String task, boolean completed, String categoryId) {
        this.task = task;
        this.completed = completed;
        this.categoryId = categoryId;
    }
    public Todo(String task, String categoryId){
        this.task = task;
        this.categoryId = categoryId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String title) {
        this.task = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id='" + id + '\'' +
                ", title='" + task + '\'' +
                ", completed=" + completed +
                ", createdAt=" + createdAt +
                '}';
    }
}
