package com.education.repository;

import com.education.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "select * from students where id in (select student_id from student_course where course_id = ?)", nativeQuery = true)
    List<Student> findAllStudentByCourseId(long courseId);

}