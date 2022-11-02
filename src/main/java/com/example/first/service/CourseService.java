package com.example.first.service;

import com.example.first.entities.Course;

import java.util.List;

public interface CourseService {

    String home();

    List<Course> getCourse();

    Course getCourses(Long courseId);

    Course deleteCourse(Long courseid);

    Course addCourse(Course course);

    Course updateCourse(Course course, Long courseId);
}
