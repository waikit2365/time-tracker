package com.timetracker.timetracker.entities;

import java.sql.Timestamp;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @Column
    private Timestamp start_at;

    @Column
    private Timestamp end_at;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "modify_at")
    private Timestamp modifyAt;

    @Column(name = "plan_actual")
    private String planActual;

    @Column(name = "category_id", insertable = false, updatable = false)
    private Integer categoryId;

    @JsonIgnoreProperties("schedule")
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getStart_at() {
        return this.start_at;
    }

    public void setStart_at(Timestamp start_at) {
        this.start_at = start_at;
    }

    public Timestamp getEnd_at() {
        return this.end_at;
    }

    public void setEnd_at(Timestamp end_at) {
        this.end_at = end_at;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getModifyAt() {
        return this.modifyAt;
    }

    public void setModifyAt(Timestamp modifyAt) {
        this.modifyAt = modifyAt;
    }

    public String getPlanActual() {
        return this.planActual;
    }

    public void setPlanActual(String planActual) {
        this.planActual = planActual;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}