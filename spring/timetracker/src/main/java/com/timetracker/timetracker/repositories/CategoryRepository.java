package com.timetracker.timetracker.repositories;

import java.util.List;

import javax.transaction.Transactional;

import com.timetracker.timetracker.entities.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT c FROM Category c WHERE c.id = :id")
    public List<Category> findAllById(Long id);

    
}