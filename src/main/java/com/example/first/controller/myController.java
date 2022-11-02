package com.example.first.controller;


import com.example.first.entities.Course;
import com.example.first.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class myController {

    private final CourseService courseService;

    public myController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/home")
    public ResponseEntity<?> home() {
        return new ResponseEntity<>(courseService.home(), HttpStatus.OK);
    }


    //    get the courses
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.courseService.getCourse();

    }


    @GetMapping("/courses/{courseID}")
    public Course getCourses(@PathVariable String courseID) {
        return this.courseService.getCourses(Long.parseLong(courseID));
    }

    @DeleteMapping("/courses/{courseid}")
    public Course deleteCourse(@PathVariable String courseid) {
        Course c = this.courseService.deleteCourse(Long.parseLong(courseid));
        return c;

    }


    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        return this.courseService.addCourse(course);
    }

    @PutMapping("/courses/{courseID}")
    public Course updateCourse(@RequestBody Course course, @PathVariable String courseID){
        Course course1 = this.courseService.updateCourse(course, Long.parseLong(courseID));
        return course1;

    }


}
