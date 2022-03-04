package com.hadicha.service;

import com.hadicha.entity.Group;
import com.hadicha.entity.Student;

import java.util.List;

public interface StudentService {
    void saveStudent(Student student);
    void deleteStudentById(int id);
    Student getById(int id);
    List<Student> getAllStudent();
    void updateStudent(Student student);
}
