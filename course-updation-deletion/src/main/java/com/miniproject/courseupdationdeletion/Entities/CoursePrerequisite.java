package com.miniproject.courseupdationdeletion.Entities;

import jakarta.persistence.*;
import com.miniproject.courseupdationdeletion.Entities.Courses;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="course_prerequisite")
public class CoursePrerequisite {


@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name="id", nullable=false, unique=true)
private Long id;

@ManyToOne(cascade = CascadeType.PERSIST)
@JoinColumn(name = "course_id_fk")
private Courses course;

@ManyToOne(cascade = CascadeType.PERSIST)
@JoinColumn(name = "prereq_id", nullable = false)
private Courses prerequisite;

@Column(name="prereq_description")
private String prereqDescription;

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public Courses getCourse() {
    return course;
}

public void setCourse(Courses course) {
    this.course = course;
}


public Courses getPrerequisite() {
    return prerequisite;
}

public void setPrerequisite(Courses prerequisite) {
    this.prerequisite = prerequisite;
}

public String getPrereqDescription() {
    return prereqDescription;
}

public void setPrereqDescription(String prereqDescription) {
    this.prereqDescription = prereqDescription;
}

}


//    create table course_prerequisite(
//        course__prereq_id INT PRIMARY KEY,
//        course_id smallint,
//        prerequisite_course_id smallint,
//        prereq_description varchar(50)
//);
