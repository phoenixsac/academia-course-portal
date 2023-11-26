package com.miniproject.courseupdationdeletion.ResponseBody;

public class CourseResponse {

    private Long id;
    private String courseCode;

    private String courseName;

    private String courseDesc;

    private int courseYear;

    private String courseTerm;

    private int courseCredits;

    private int courseCapacity;

    private int courseFacId;

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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public int getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(int courseYear) {
        this.courseYear = courseYear;
    }

    public String getCourseTerm() {
        return courseTerm;
    }

    public void setCourseTerm(String courseTerm) {
        this.courseTerm = courseTerm;
    }

    public int getCourseCredits() {
        return courseCredits;
    }

    public void setCourseCredits(int courseCredits) {
        this.courseCredits = courseCredits;
    }

    public int getCourseCapacity() {
        return courseCapacity;
    }

    public void setCourseCapacity(int courseCapacity) {
        this.courseCapacity = courseCapacity;
    }

    public int getCourseFacId() {
        return courseFacId;
    }

    public void setCourseFacId(int courseFacId) {
        this.courseFacId = courseFacId;
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
//        faculty_id int
//        );
