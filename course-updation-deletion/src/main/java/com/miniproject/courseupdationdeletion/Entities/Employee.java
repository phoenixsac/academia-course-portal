package com.miniproject.courseupdationdeletion.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="employee_id", nullable=false, unique=true)
    private int id;

    @Column(name="first_name", nullable=false)
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email", nullable=false, unique = true)
    private String email;

    @Column(name="title")
    private String title;



    @Column(name="type")
    private String type;

    @Column(name="photograph_path")
    private String photographPath;

//    @Column(name="dept_id")
//    private int deptId;

//    @ManyToOne
//    @JoinColumn(name = "dept_id")  // Specify the name of the foreign key column
//    private Department deptId;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotographPath() {
        return photographPath;
    }

    public void setPhotographPath(String photographPath) {
        this.photographPath = photographPath;
    }

    public Department getDeptId() {
        return department;
    }

    public void setDeptId(Department dept) {
        this.department = dept;
    }

}


//##EMPLOYEE
//        create table employee(
//        employee_id INT PRIMARY KEY,
//        first_name varchar(30) not null,
//        last_name varchar(30),
//        email varchar(30) not null unique,
//        title varchar(30),
//        photograph_path varchar(30),
//        dept_id int
//        );