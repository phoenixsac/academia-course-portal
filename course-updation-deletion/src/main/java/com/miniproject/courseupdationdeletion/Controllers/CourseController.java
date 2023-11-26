package com.miniproject.courseupdationdeletion.Controllers;

import com.miniproject.courseupdationdeletion.Entities.Courses;
import com.miniproject.courseupdationdeletion.Exception.CourseNotFoundException;
import com.miniproject.courseupdationdeletion.RequestBody.CourseReqBody;
import com.miniproject.courseupdationdeletion.ResponseBody.CourseResponse;
import com.miniproject.courseupdationdeletion.Service.CourseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping
public class CourseController {

    private final CourseServiceImpl courseService;

    Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    public CourseController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public ResponseEntity<List<CourseResponse>> getAllCourses() {

        logger.info("get courses endpoint");

        try {
            List<CourseResponse> courses = courseService.getAllCourses();
            return new ResponseEntity<>(courses, HttpStatus.OK);
        } catch (Exception e) {
            // Handle the exception and return an appropriate response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/courses/{courseId}")
    public ResponseEntity<CourseResponse> getCourseById(@PathVariable int courseId) {

        logger.info("get course by id endpoint");

        try {
            CourseResponse courseResp = courseService.getCourseById(courseId);
            return new ResponseEntity<>(courseResp, HttpStatus.OK);
        }
        catch (CourseNotFoundException e) {
            throw e;
        }catch (Exception e) {
         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create_course")
    public ResponseEntity<Courses> createPost(@RequestBody CourseReqBody courseReqBody) {
        logger.info("Create course API hit");
        try {
            Courses createdCourse = courseService.createCourse(courseReqBody);

            return ResponseEntity.of(Optional.of(createdCourse));

        }
             catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/update_course/{courseId}")
    public ResponseEntity<Courses> updatePost(@PathVariable int courseId, @RequestBody CourseReqBody courseReqBody) {
        logger.info("Modify course API hit");
        try {
            Courses updatedCourse = courseService.modifyCourse(courseId,courseReqBody);
            return ResponseEntity.of(Optional.of(updatedCourse));
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete_course/{courseId}")
    public ResponseEntity<String> deletePost(@PathVariable Long courseId) {
        logger.info("Delete course API hit");
        try {
            boolean deletionStatus = courseService.deleteCourse(courseId);
            if(deletionStatus)
                return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
            else
                return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<String> handleCourseNotFoundException(CourseNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }




    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
