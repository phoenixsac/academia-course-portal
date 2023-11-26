package com.miniproject.courseupdationdeletion.Repository;

import com.miniproject.courseupdationdeletion.Entities.CoursePrerequisite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface CoursePrerequisiteRepository extends JpaRepository<CoursePrerequisite, Long> {

    @Query(value = "SELECT course_prereq_id FROM course_prerequisite WHERE course_id = :preReqId", nativeQuery = true)
    List<Integer> findPrereqIds(@Param("preReqId") int preReqId);



    @Modifying
    @Query(value = "INSERT INTO course_prerequisite (course_id_fk, prereq_id, prereq_description) VALUES (:courseIdFk, :prereqId, :prereqDescription)", nativeQuery = true)
    void insertCoursePrerequisite(@Param("courseIdFk") Long courseIdFk, @Param("prereqId") Long prereqId, @Param("prereqDescription") String prereqDescription);




    @Query(value = "SELECT id FROM course_prerequisite WHERE course_id_fk = :courseId", nativeQuery = true)
    Set<Long> deleteEntriesBasedOnCourseId(@Param("courseId") Long courseId);

    @Query(value = "SELECT id FROM course_prerequisite WHERE  prereq_id = :courseId", nativeQuery = true)
    Set<Long> deleteEntriesBasedOnPrerequisiteId(@Param("courseId") Long courseId);

    void deleteById(Long id);

}
