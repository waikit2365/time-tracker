package com.timetracker.timetracker.repositories;

import javax.transaction.Transactional;

import com.timetracker.timetracker.entities.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    

    
}