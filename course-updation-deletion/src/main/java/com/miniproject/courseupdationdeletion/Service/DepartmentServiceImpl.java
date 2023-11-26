package com.miniproject.courseupdationdeletion.Service;

import com.miniproject.courseupdationdeletion.Entities.Courses;
import com.miniproject.courseupdationdeletion.Entities.Department;
import com.miniproject.courseupdationdeletion.Repository.CoursesRepository;
import com.miniproject.courseupdationdeletion.Repository.DepartmentRepository;
import com.miniproject.courseupdationdeletion.ResponseBody.CourseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import com.miniproject.courseupdationdeletion.ResponseBody.DepartmentResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl {

    private final DepartmentRepository deptRepo;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository deptRepo) {
        this.deptRepo = deptRepo;
    }

    public List<DepartmentResponse> getAllDepartments() {
        List<Department> departments = deptRepo.findAll();
        return departments.stream()
                .map(this::mapToResponseModel)
                .collect(Collectors.toList());
    }

    private DepartmentResponse mapToResponseModel(Department dept) {
        DepartmentResponse response = new DepartmentResponse();
        response.setId(dept.getId());
        response.setName(dept.getName());
        response.setCapacity(dept.getCapacity());

        //Map other properties if needed
        return response;
    }
}
