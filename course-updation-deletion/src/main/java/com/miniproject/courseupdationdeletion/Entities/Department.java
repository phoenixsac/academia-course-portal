package com.miniproject.courseupdationdeletion.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="departments")
public class Department {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="department_id", nullable=false, unique=true)
    private int id;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="capacity")
    private int capacity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


}

