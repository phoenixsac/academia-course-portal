package com.miniproject.courseupdationdeletion.Controllers;


import com.miniproject.courseupdationdeletion.ResponseBody.DepartmentResponse;
import com.miniproject.courseupdationdeletion.Service.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final com.miniproject.courseupdationdeletion.Service.DepartmentServiceImpl deptService;

    Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    public DepartmentController(DepartmentServiceImpl deptService) {
        this.deptService = deptService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getAllDepartments() {

        logger.info("get departments endpoint");

        try {
            List<DepartmentResponse> depts = deptService.getAllDepartments();
            return new ResponseEntity<>(depts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
