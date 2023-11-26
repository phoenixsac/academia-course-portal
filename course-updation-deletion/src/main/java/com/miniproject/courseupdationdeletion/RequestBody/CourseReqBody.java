package com.miniproject.courseupdationdeletion.RequestBody;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CourseReqBody {

    @JsonProperty("course_code")
    private String courseCode;

    @JsonProperty("course_name")
    private String courseName;

    @JsonProperty("course_description")
    private String courseDescription;

    @JsonProperty("course_year")
    private int courseYear;

    @JsonProperty("course_term")
    private String courseTerm;

    @JsonProperty("course_credits")
    private int courseCredits;

    @JsonProperty("course_capacity")
    private int courseCapacity;

    @JsonProperty("course_faculty_id")
    private int courseFacultyId;

//    @JsonProperty("course_prereq_ids")
//    public List<Long> getCoursePrereqIds() {
//        return coursePrereqIds;
//    }

    @JsonProperty("course_prereq")
    public List<PrereqReqBody> preReqList;

    public List<PrereqReqBody> getPreReqList() {
        return preReqList;
    }

    public void setPreReqList(List<PrereqReqBody> preReqList) {
        this.preReqList = preReqList;
    }




}





//    {
//        course_code:"SS-002",
//                course_name:"ESD",
//            course_description:"Full Stack development",
//            course_year:2023,
//            course_term:"6 months"
//        course_credits:5,
//                course_capacity:25,
//            course_faculty_id:3
//    }

