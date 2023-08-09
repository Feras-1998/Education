package com.education.repository;

import com.education.model.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
    Optional<StudentCourse> findByStudentIdAndCourseId(long studentId, long courseId);


    @Modifying
    @Query(value = "delete from student_course where student_id = ?", nativeQuery = true)
    void deleteStudentCourses(long studentId);
}