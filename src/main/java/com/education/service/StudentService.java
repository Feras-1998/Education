package com.education.service;

import com.education.exception.StudentNotFoundException;
import com.education.model.Student;
import com.education.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Transactional
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public void delete(long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> findAllStudentByCourseId(long courseId) {
        return studentRepository.findAllStudentByCourseId(courseId);
    }
}
