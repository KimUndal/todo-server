package com.undal.todoserver.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Category implements Serializable {
    @Id
    @Column(nullable = false, updatable = false)
    private String id;
    private String title;

    public Category(String title) {
        id = java.util.UUID.randomUUID().toString();
        this.title = title;
    }

    public Category() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
