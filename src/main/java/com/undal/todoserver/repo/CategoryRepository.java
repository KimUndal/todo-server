package com.undal.todoserver.repo;

import com.undal.todoserver.model.Category;
import com.undal.todoserver.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, String> {

    @Transactional
    @Modifying
    @Query("delete from Category c where c.id = ?1")
    void deleteCategoryById(String id);

    @Query("select c from Category c where c.id = ?1")
    Optional<Category> findCategoryById(String id);
}
