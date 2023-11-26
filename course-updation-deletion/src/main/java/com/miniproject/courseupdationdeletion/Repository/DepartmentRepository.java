package com.miniproject.courseupdationdeletion.Repository;

import com.miniproject.courseupdationdeletion.Entities.Courses;
import com.miniproject.courseupdationdeletion.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
