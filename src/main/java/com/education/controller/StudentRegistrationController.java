package com.education.controller;

import com.education.model.Student;
import com.education.service.StudentRegistrationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("apis/student-registration")
@Tag(name = "Student Registration Management", description = "Student Registration Management APIs")
public class StudentRegistrationController {

    @Autowired
    private StudentRegistrationService studentRegistrationService;

    @Operation(
            summary = "Register Student Course",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "401", description = "Add token Request Header")
            }
    )
    @PostMapping("register-student-course/{studentId}/{courseId}")
    private void registerStudentCourse(@PathVariable long studentId, @PathVariable long courseId){
        studentRegistrationService.registerStudentCourse(studentId, courseId);
    }

    @Operation(
            summary = "Get All Students Register Course",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "401", description = "Add token Request Header"),
                    @ApiResponse(responseCode = "404", description = "A request with the specified id did not exist")
            }
    )
    @GetMapping("get-all-students-register-course/{courseId}")
    private List<Student> getAllStudentsRegisterCourse(@PathVariable long courseId){
        return studentRegistrationService.getAllStudentsRegisterCourse(courseId);
    }

    @Operation(
            summary = " Update Student Courses",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "400", description = "Empty Body"),
                    @ApiResponse(responseCode = "401", description = "A request with the specified id did not exist")
            }
    )
    @PostMapping("update-student-courses/{studentId}")
    private void updateStudentCourses(@PathVariable long studentId, @RequestBody List<Long> courseIds){
        studentRegistrationService.updateStudentCourses(studentId, courseIds);
    }

}
