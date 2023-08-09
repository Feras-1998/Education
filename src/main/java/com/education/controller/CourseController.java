package com.education.controller;

import com.education.model.Course;
import com.education.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("apis/courses")
@Tag(name = "Course Controller", description = "Course CRUD Operation")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    @Operation(
            summary = "Find all courses",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "401", description = "Add token Request Header")
            }
    )
    private List<Course> findAll() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Find course by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "401", description = "Add token Request Header"),
                    @ApiResponse(responseCode = "404", description = "A request with the specified id did not exist")
            }
    )
    private Course findById(@PathVariable long id) {
        return courseService.findById(id);
    }

    @PutMapping
    @Operation(
            summary = "Save course",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "400", description = "Empty Body"),
                    @ApiResponse(responseCode = "401", description = "A request with the specified id did not exist")
            }
    )
    private Course save(@RequestBody Course course) {
        return courseService.save(course);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete course by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "401", description = "A request with the specified id did not exist"),
                    @ApiResponse(responseCode = "404", description = "Add token Request Header")
            }
    )
    private void delete(@PathVariable long id) {
        courseService.delete(id);
    }

}
