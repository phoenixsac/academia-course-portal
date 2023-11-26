package com.miniproject.courseupdationdeletion.Service;

import com.miniproject.courseupdationdeletion.Entities.CoursePrerequisite;
import com.miniproject.courseupdationdeletion.Exception.CourseNotFoundException;
import com.miniproject.courseupdationdeletion.Repository.CoursePrerequisiteRepository;
import com.miniproject.courseupdationdeletion.RequestBody.CourseReqBody;
import com.miniproject.courseupdationdeletion.RequestBody.PrereqReqBody;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miniproject.courseupdationdeletion.ResponseBody.CourseResponse;
import com.miniproject.courseupdationdeletion.Entities.Courses;
import com.miniproject.courseupdationdeletion.Repository.CoursesRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import java.util.List;

@Service
public class CourseServiceImpl {

    @Autowired
    private final CoursesRepository courseRepository;

    @Autowired
    private final CoursePrerequisiteRepository coursePrereqRepo;

    @Autowired
    public CourseServiceImpl(CoursesRepository courseRepository, CoursePrerequisiteRepository coursePrereqRepo) {
        this.courseRepository = courseRepository;
        this.coursePrereqRepo = coursePrereqRepo;
    }

    public List<CourseResponse> getAllCourses() {
        List<Courses> courses = courseRepository.findAll();
        return courses.stream()
                .map(this::mapToResponseModel)
                .collect(Collectors.toList());
    }

    public CourseResponse getCourseById(int courseId) {
        Courses course = new Courses();
        course = courseRepository.findCourseById(courseId);
        if(course==null)
            throw new CourseNotFoundException("Course not found in database");
        else
            return mapToResponseModel(course);
    }


//    public Courses createCourse(CourseReqBody courseReqBody) {
//        Courses course = new Courses();
//        course.setCourseCode(courseReqBody.getCourseCode());
//        course.setName(courseReqBody.getCourseName());
//        course.setCapacity(courseReqBody.getCourseCapacity());
//        course.setCredits(courseReqBody.getCourseCredits());
//        course.setDescription(courseReqBody.getCourseDescription());
//        course.setTerm(courseReqBody.getCourseTerm());
//        course.setYear(courseReqBody.getCourseYear());
//        course.setFacultyId(courseReqBody.getCourseFacultyId());
//
//        courseRepository.save(course);
//        CoursePrerequisite crsPrereqEntry=new CoursePrerequisite();
//      //  Courses crsEntry=new Courses();
//
//        List<PrereqReqBody> crsPrereqList=courseReqBody.getPreReqList();
//
//
//        if (crsPrereqList != null) {
//            for (PrereqReqBody prereqReqBody : crsPrereqList) {
//                Courses prereqEntry=new Courses();
//                crsPrereqEntry.setCourse(course);
//                prereqEntry=courseRepository.coursgetPrereqCourseById(prereqReqBody.getPrereqId());
//                crsPrereqEntry.setPrerequisite(prereqEntry);
//                crsPrereqEntry.setPrereqDescription(prereqReqBody.get);
//            }
//
//           // mapToCoursePrerequisiteTable(courseReqBody, course);
//        }



//    public Courses createCourse(CourseReqBody courseReqBody) {
//        Courses course = new Courses();
//        course.setCourseCode(courseReqBody.getCourseCode());
//        course.setName(courseReqBody.getCourseName());
//        course.setCapacity(courseReqBody.getCourseCapacity());
//        course.setCredits(courseReqBody.getCourseCredits());
//        course.setDescription(courseReqBody.getCourseDescription());
//        course.setTerm(courseReqBody.getCourseTerm());
//        course.setYear(courseReqBody.getCourseYear());
//        course.setFacultyId(courseReqBody.getCourseFacultyId());
//
//        courseRepository.save(course);
//
//        List<PrereqReqBody> crsPrereqList = courseReqBody.getPreReqList();
//
//        if (crsPrereqList != null) {
//            for (PrereqReqBody prereqReqBody : crsPrereqList) {
//                CoursePrerequisite crsPrereqEntry = new CoursePrerequisite();
//                Courses prereqEntry = courseRepository.coursgetPrereqCourseById(prereqReqBody.getPrereqId());
//                crsPrereqEntry.setCourse(course);
//                crsPrereqEntry.setPrerequisite(prereqEntry);
//                crsPrereqEntry.setPrereqDescription(prereqReqBody.getDescription());
//
//                // Save each CoursePrerequisite entry
//                coursePrereqRepo.insertCoursePrerequisite(course.getId(),crsPrereqEntry.getId(), prereqEntry.getDescription());
//            }
//        }
//
//        return course;
//    }



//        @Autowired
//        private CourseRepository courseRepository;
//
//        @Autowired
//        private CoursePrerequisiteRepository coursePrerequisiteRepository;



public Courses createCourse(CourseReqBody courseReqBody) {
    Courses course = new Courses();
    // Set properties of the course from courseReqBody
    course.setCourseCode(courseReqBody.getCourseCode());
    course.setName(courseReqBody.getCourseName());
    course.setCapacity(courseReqBody.getCourseCapacity());
    course.setCredits(courseReqBody.getCourseCredits());
    course.setDescription(courseReqBody.getCourseDescription());
    course.setTerm(courseReqBody.getCourseTerm());
    course.setYear(courseReqBody.getCourseYear());
    course.setFacultyId(courseReqBody.getCourseFacultyId());

    // Save the course to get its ID
    Courses savedCourse=courseRepository.save(course);

    // Create and save course prerequisites
    List<PrereqReqBody> prereqList = courseReqBody.getPreReqList();
    if (prereqList != null) {
        for (PrereqReqBody prereqReqBody : prereqList) {
            Courses prerequisiteCourse = courseRepository.findById(prereqReqBody.getPrereqId())
                    .orElseThrow(() -> new EntityNotFoundException("Prerequisite course not found"));

            CoursePrerequisite coursePrerequisite = new CoursePrerequisite();
            coursePrerequisite.setCourse(savedCourse);
            coursePrerequisite.setPrerequisite(prerequisiteCourse);
            coursePrerequisite.setPrereqDescription(prereqReqBody.getDescription());

            coursePrereqRepo.save(coursePrerequisite);
        }
    }

    return course;
}




        public Courses modifyCourse(int courseId, CourseReqBody courseReqBody) {
        Courses course = new Courses();
        course=courseRepository.findCourseById(courseId);

        course.setCourseCode(courseReqBody.getCourseCode());
        course.setName(courseReqBody.getCourseName());
        course.setCapacity(courseReqBody.getCourseCapacity());
        course.setCredits(courseReqBody.getCourseCredits());
        course.setDescription(courseReqBody.getCourseDescription());
        course.setTerm(courseReqBody.getCourseTerm());
        course.setYear(courseReqBody.getCourseYear());
        course.setFacultyId(courseReqBody.getCourseFacultyId());

        return courseRepository.save(course);
    }

    @Transactional
    public boolean deleteCourse(Long courseId) {

        Optional<Courses> optionalCourse = Optional.ofNullable(courseRepository.findCourseByIdOptionalWrapper(courseId));

        if (optionalCourse.isPresent()) {
            Courses courseToDelete = optionalCourse.get();

            Set<Long> uniquePrereqIds = new HashSet<>();
            Set<Long> preReqIds1 = coursePrereqRepo.deleteEntriesBasedOnCourseId(courseToDelete.getId());
            uniquePrereqIds.addAll(preReqIds1);

            Set<Long> preReqIds2 = coursePrereqRepo.deleteEntriesBasedOnPrerequisiteId(courseToDelete.getId());
            uniquePrereqIds.addAll(preReqIds2);

            uniquePrereqIds.forEach(preReqId ->coursePrereqRepo.deleteById(preReqId));
            courseRepository.delete(courseToDelete);
            return true;
        } else {
            // Course not found
            return false;
        }
    }

    public void deletePrereqCourse(Long coursePrereqId){
        courseRepository.deleteById(coursePrereqId);
    }

    public CourseResponse mapToResponseModel(Courses course) {
       CourseResponse response = new CourseResponse();
        response.setId(course.getId());
        response.setCourseName(course.getName());
        response.setCourseCode(course.getCourseCode());
        response.setCourseCapacity(course.getCapacity());
        response.setCourseDesc(course.getDescription());
        response.setCourseTerm(course.getTerm());
        response.setCourseYear(course.getYear());

        // Map other properties if needed
        return response;
   }
}
