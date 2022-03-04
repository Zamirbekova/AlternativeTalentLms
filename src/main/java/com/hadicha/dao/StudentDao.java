package com.hadicha.dao;

import com.hadicha.entity.Course;
import com.hadicha.entity.Student;

import java.util.List;

public interface StudentDao {
    void saveStudent(Student student);
    void deleteStudentById(int id);
    Student getById(int id);
    List<Student> getAllStudent();
    void updateStudent(Student student);
}
