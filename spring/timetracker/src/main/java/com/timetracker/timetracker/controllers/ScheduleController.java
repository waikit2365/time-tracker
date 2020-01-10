package com.timetracker.timetracker.controllers;

import java.time.LocalDateTime;
import java.util.List;

import com.timetracker.timetracker.entities.Category;
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
        @RequestParam(name="startAt", required = false) LocalDateTime startAt,
        @RequestParam(name="categoryId", required = false) Long categoryId) {
            if(startAt != null && categoryId == null){
                return repo.searchAllByStartAt(startAt);
            } else if (startAt == null && categoryId != null){
                return repo.searchAllByCategoryId(categoryId);
            }
            return repo.findAll();
    }

    @GetMapping(value = "/scheduleToday")
    public List<Schedule> show(){
        return repo.searchAllByToday();
    }


    // @GetMapping(value = "/scheduleWeek")
    // public List<Schedule> show(){
    //     return repo.searchAllByThisWeek();
    // }


    // @GetMapping(value = "/scheduleMonth")
    // public List<Schedule> show(){
    //     return repo.searchAllByThisMonth();
    // }

    @PostMapping(value="/schedule")
    public Schedule create(
        @RequestBody Schedule schedule
        ) {
        schedule.setDescription(schedule.getDescription());
        schedule.setCreatedAt(LocalDateTime.now());
        schedule.setStartAt(schedule.getStartAt());
        schedule.setEndAt(schedule.getEndAt());
        schedule.setPlanActual(schedule.getPlanActual());

        Category cat = categoryRepo.findById(schedule.getCategoryId()).orElse(null);

        if (cat != null) {
            schedule.setCategory(cat);
            cat.getSchedule().add(schedule);
        }
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
        schedule.setModifyAt(LocalDateTime.now());
        schedule.setStartAt(data.getStartAt());
        schedule.setEndAt(data.getEndAt());
        schedule.setPlanActual(data.getPlanActual());

        Category cat = categoryRepo.findById(schedule.getCategoryId()).orElse(null);

        if (cat != null) {
            schedule.setCategory(cat);
            cat.getSchedule().add(schedule);
        }
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