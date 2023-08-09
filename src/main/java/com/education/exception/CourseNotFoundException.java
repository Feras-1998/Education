package com.education.exception;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(Long id) {
        super("Course with Id "+id+" not found");
    }

}
