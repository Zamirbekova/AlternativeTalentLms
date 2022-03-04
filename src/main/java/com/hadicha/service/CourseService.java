package com.hadicha.service;

import com.hadicha.entity.Company;
import com.hadicha.entity.Course;

import java.util.List;

public interface CourseService {
    void saveCourse(Course course);
    void deleteCourseById(int id);
    Course getById(int id);
    List<Course> getAllCourse();
    void updateCourse(Course course);
}
