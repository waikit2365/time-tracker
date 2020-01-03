package com.timetracker.timetracker.repositories;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.timetracker.timetracker.entities.Schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    public List<Schedule> findAllByStartAt(String startAt);
    public List<Schedule> findAllByCategoryId(int categoryId);

    @Query("SELECT s FROM Schedule s WHERE s.categoryId = :categoryId")
    public List<Schedule> searchAllByCategoryId(@Param("categoryId")int categoryId);

    @Query("SELECT s FROM Schedule s WHERE s.startAt = :startAt")
    public List<Schedule> searchAllByStartAt(@Param("startAt") Date startAt);
}