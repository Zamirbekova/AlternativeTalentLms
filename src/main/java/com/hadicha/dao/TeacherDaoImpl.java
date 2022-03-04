package com.hadicha.dao;

import com.hadicha.entity.Student;
import com.hadicha.entity.Teacher;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class TeacherDaoImpl implements TeacherDao{
    @PersistenceContext
private EntityManager entityManager;
    @Override
    public void saveTeacher(Teacher teacher) {
        entityManager.persist(teacher);
    }

    @Override
    public void deleteTeacherById(int id) {
 Teacher teacher=entityManager.find(Teacher.class,id);
 entityManager.remove(teacher);
    }

    @Override
    public List<Teacher> getById(int id) {
        return (List<Teacher>) entityManager.find(Teacher.class,id);
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return entityManager.createQuery("select u from Teacher u",Teacher.class)
                .getResultList();
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        entityManager.merge(teacher);

    }
}
