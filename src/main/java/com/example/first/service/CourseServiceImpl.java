package com.example.first.service;

import com.example.first.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    List<Course> list = new ArrayList<>();

    public CourseServiceImpl() {
//        list = new ArrayList<>();
        list.add(new Course(123, "Java Core Course", "this course contain information about java"));
        list.add(new Course(122, "Spring Course", "Creating rest Api Using Spring Boot"));
        list.add(new Course(121, "JavaScript Course", "this course contain information about javascript"));
    }


    @Override
    public String home() {
        return "Welcome to home";
    }


//    listing all the course
    @Override
    public List<Course> getCourse() {
        return list;
    }

//    listing the course by id
    @Override
    public Course getCourses(Long courseId) {
        Course c = null;
        for (Course course : list) {
            if (course.getId() == courseId) {
                c = course;
                break;
            }
        }
        return c;
    }

//  deleting the course
    @Override
    public Course deleteCourse(Long courseid) {
        Course c = null;
        for (Course course : list) {
            if (course.getId() == courseid) {
                c = course;
            }
        }
        list.remove(c);
        return c;
    }


//  Adding the Course
    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }



//  updating the course
    @Override
    public Course updateCourse(Course course, Long courseId) {
        Course c2 = null;
        int x = 0;
        for (Course c : list) {
            if (c.getId() == courseId) {
                x = list.indexOf(c);//to capture the index of the
            }
        }
        c2 = course;
        list.set(x, c2);
        return c2;
    }


}
