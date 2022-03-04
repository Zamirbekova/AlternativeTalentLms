package com.hadicha.service;

import com.hadicha.dao.TeacherDao;
import com.hadicha.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService{
    private TeacherDao teacherDao;
    @Override
    public void saveTeacher(Teacher teacher) {
        teacherDao.saveTeacher(teacher);
    }

    @Override
    public void deleteTeacherById(int id) {
teacherDao.deleteTeacherById(id);
    }

    @Override
    public List<Teacher> getById(int id) {
        return teacherDao.getById(id);
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherDao.getAllTeacher();
    }

    @Override
    public void updateTeacher(Teacher teacher) {
teacherDao.updateTeacher(teacher);
    }
}
