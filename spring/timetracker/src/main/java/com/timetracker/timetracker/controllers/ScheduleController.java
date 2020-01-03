package com.timetracker.timetracker.controllers;

import java.util.List;

import com.timetracker.timetracker.entities.Schedule;
import com.timetracker.timetracker.repositories.CategoryRepository;
import com.timetracker.timetracker.repositories.ScheduleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {

    @Autowired
    ScheduleRepository repo;
    
    @Autowired
    CategoryRepository categoryRepo;

    @GetMapping(value = "/schedule")
    public List<Schedule> index(
        @RequestParam(name="startAt", required = false) String startAt,
        @RequestParam(name="categoryId", required = false) Integer categoryId) {
            if(startAt != null && categoryId == null){
                return repo.findAllByStartAt(startAt);
            } else if (startAt == null && categoryId != null){
                return repo.findAllByCategoryId(categoryId);
            }
            return repo.findAll();
    }


    @PostMapping(value="/schedule")
    public Schedule create(@RequestBody Schedule schedule) {
        repo.save(schedule);
        return schedule;
    }

    @PutMapping(value="/schedule/{id}")
    public Schedule schedule(
        @PathVariable("id") Long id,
        @RequestBody Schedule data
    ){
        Schedule schedule = repo.findById(id).orElse(null);
        schedule.setDescription(data.getDescription());
        schedule.setCreatedAt(data.getCreatedAt());
        schedule.setEnd_at(data.getEnd_at());
        schedule.setCategoryId(data.getCategoryId());
        schedule.setPlanActual(data.getPlanActual());
        repo.save(schedule);

        return schedule;

    }

    @DeleteMapping(value = "/schedule/{id}")
    public String delete(@PathVariable("id") Long id){
        Schedule schedule = repo.findById(id).orElse(null);

        if(schedule != null){
            repo.delete(schedule);
            return "Schedule successfully deleted";
        } else {
            return "Schedule doesn't exist";
        }
    }
     
}