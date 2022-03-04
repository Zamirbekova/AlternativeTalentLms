package com.hadicha.dao;

import com.hadicha.entity.Company;
import com.hadicha.entity.Course;

import java.util.List;

public interface CourseDao
{
    void saveCourse(Course course);
    void deleteCourseById(int id);
    Course getById(int id);
    List<Course> getAllCourse();
    void updateCourse(Course course);
}
