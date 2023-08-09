package com.education.service;

import com.education.model.Student;
import com.education.model.StudentCourse;
import com.education.repository.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentRegistrationService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Transactional
    public void registerStudentCourse(long studentId, long courseId) {
        StudentCourse studentCourse = studentCourseRepository.findByStudentIdAndCourseId(studentId, courseId).orElse(StudentCourse.builder().studentId(studentId).courseId(courseId).build());
        studentCourseRepository.save(studentCourse);
    }

    public List<Student> getAllStudentsRegisterCourse(long courseId) {
        return studentService.findAllStudentByCourseId(courseId);
    }

    @Transactional
    public void updateStudentCourses(long studentId, List<Long> courseIds) {
        studentCourseRepository.deleteStudentCourses(studentId);

        if (courseIds != null) {
            List<StudentCourse> studentCourseList = new ArrayList<>();
            courseIds.stream().parallel().forEach((Long courseId) -> studentCourseList.add(StudentCourse.builder().studentId(studentId).courseId(courseId).build()));
            studentCourseRepository.saveAll(studentCourseList);
        }
    }
}
