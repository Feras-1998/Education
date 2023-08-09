package com.education.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleStudentNotFoundException(StudentNotFoundException studentNotFoundException, WebRequest webRequest){
        Map<String, String> response = new HashMap<>();

        response.put("timestamp", LocalDateTime.now().toString());
        response.put("message", "Student not found!!!");

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCourseNotFoundException(CourseNotFoundException courseNotFoundException, WebRequest webRequest){
        Map<String, String> response = new HashMap<>();

        response.put("timestamp", LocalDateTime.now().toString());
        response.put("message", "Course not found!!!");

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<Map<String, String>> handleUserAlreadyExistException(UserAlreadyExistException userAlreadyExistException, WebRequest webRequest){
        Map<String, String> response = new HashMap<>();

        response.put("timestamp", LocalDateTime.now().toString());
        response.put("message", "Username is already exist!!!");

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
