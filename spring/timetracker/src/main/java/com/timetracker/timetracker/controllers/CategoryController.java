package com.timetracker.timetracker.controllers;

import java.util.List;

import com.timetracker.timetracker.entities.Category;
import com.timetracker.timetracker.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    CategoryRepository repo;

    @GetMapping(value = "/categories")
    public List<Category> index() {
        return repo.findAll();
    }

    @PostMapping(value="/categories")
    public Category create(@RequestBody Category category) {
        repo.save(category);
        return category;
    }
}