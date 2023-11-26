package com.miniproject.courseupdationdeletion.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="courses")
public class Courses {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="course_id", nullable=false, unique=true)
    private Long id;

    @Column(name="course_code", nullable=false, unique = true)
    private String courseCode;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="year")
    private int year;

    @Column(name="term", nullable = false)
    private String term;

    @Column(name="credits",nullable = false)
    private int credits;

    @Column(name="capacity",nullable = false)
    private int capacity;

    @JoinColumn(name = "faculty_id")
    private int facultyId;

//    @OneToMany(mappedBy = "prerequisite", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<CoursePrerequisite> prerequisites = new ArrayList<>();

//    public List<CoursePrerequisite> getPrerequisites() {
//        return prerequisites;
//    }
//
//    public void setPrerequisites(List<CoursePrerequisite> prerequisites) {
//        this.prerequisites = prerequisites;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }
}


//##COURSES
//        create table courses(
//        course_id smallint PRIMARY KEY,
//        course_code varchar(10) not null unique,
//        name varchar(50) not null,
//        description varchar(50),
//        year smallint not null,
//        term varchar(20) not null,
//        credits smallint not null,
//        capacity smallint not null,
//        faculty int
//        );