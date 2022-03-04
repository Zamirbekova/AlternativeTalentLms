package com.hadicha.dao;

import com.hadicha.entity.Student;
import com.hadicha.entity.Teacher;

import java.util.List;

public interface TeacherDao {
    void saveTeacher(Teacher teacher);
    void deleteTeacherById(int id);
    List<Teacher> getById(int id);
    List<Teacher> getAllTeacher();
    void updateTeacher(Teacher teacher);
}
