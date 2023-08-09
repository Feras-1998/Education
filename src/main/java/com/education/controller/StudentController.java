package com.education.controller;

import com.education.model.Student;
import com.education.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("apis/students")
@Tag(name = "Student Controller", description = "Student CRUD Operation")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    @Operation(
            summary = "Find all students",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "401", description = "Add token Request Header")
            }
    )
    private List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Find student by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "401", description = "Add token Request Header"),
                    @ApiResponse(responseCode = "404", description = "A request with the specified id did not exist")

            }
    )
    private Student findById(@PathVariable long id) {
        return studentService.findById(id);
    }

    @PutMapping
    @Operation(
            summary = "Save student",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "400", description = "Empty Body"),
                    @ApiResponse(responseCode = "401", description = "A request with the specified id did not exist")
            }
    )
    private Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete student by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "401", description = "A request with the specified id did not exist"),
                    @ApiResponse(responseCode = "404", description = "Add token Request Header")
            }
    )
    private void delete(@PathVariable long id) {
        studentService.delete(id);
    }

}
